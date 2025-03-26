package com.maptist.mappride.mappride.place;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class NaverGeocodingService {

    @Value("${naver.client-id}")
    private String clientId;

    @Value("${naver.client-secret}")
    private String clientSecret;

    @Value("${naver.geocoding-url}")
    private String geocodingUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getGeocode(String address) throws IOException {

        String fullUrl = geocodingUrl + URLEncoder.encode(address, "UTF-8");
        HttpURLConnection conn = (HttpURLConnection) new URL(fullUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();
        log.info("response = {}",response);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        log.info("root = {}", root);
        JsonNode addr = root.get("addresses").get(0);
//        if (addr == null || !addr.isArray() || addr.isEmpty()) {
//            throw new IllegalArgumentException("유효한 주소 결과가 없습니다.");
//        }

        Map<String, Object> result = new HashMap<>();
        result.put("lat", addr.get("y").asText());
        result.put("lng", addr.get("x").asText());
        log.info("result latlng = {}",result);
        return result;

    }

    public String getAddressFromCoordinates(double latitude, double longitude) {
        String url = String.format("%s?coords=%f,%f&output=json", geocodingUrl, longitude, latitude);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return extractAddress(response.getBody());  // JSON 응답을 그대로 반환
    }

    private String extractAddress(String jsonResponse) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);

            // API 응답이 정상인지 확인
            if (root.path("status").path("code").asInt() != 0) {
                return "주소를 찾을 수 없습니다.";
            }

            // "results" 배열에서 첫 번째 결과 가져오기
            JsonNode results = root.path("results");
            if (results.isEmpty()) {
                return "주소 정보를 찾을 수 없습니다.";
            }

            JsonNode region = results.get(0).path("region");

            // 주소 구성 요소 가져오기
            String area1 = region.path("area1").path("name").asText();  // 서울특별시
            String area2 = region.path("area2").path("name").asText();  // 중구
            String area3 = region.path("area3").path("name").asText();  // 태평로1가

            return String.format("%s %s %s", area1, area2, area3).trim();
            } catch (Exception e) {
                return "주소 변환 오류: " + e.getMessage();
            }
    }
}
