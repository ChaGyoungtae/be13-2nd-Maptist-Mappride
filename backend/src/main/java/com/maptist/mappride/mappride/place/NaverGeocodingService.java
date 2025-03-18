package com.maptist.mappride.mappride.place;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NaverGeocodingService {

    @Value("${naver.client-id}")
    private String clientId;

    @Value("${naver.client-secret}")
    private String clientSecret;

    @Value("${naver.geocoding-url}")
    private String geocodingUrl;

    private final RestTemplate restTemplate = new RestTemplate();

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
