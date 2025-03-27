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

    // 주소를 위도와 경도로 변환
    public Map<String, Object> getGeocode(String address) {
        String url = String.format("%s?query=%s", geocodingUrl, address);

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 엔티티 설정
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // API 호출
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("API Response: {}", response.getBody());

        // 응답 데이터에서 위도, 경도 추출
        return extractLatLngFromResponse(response.getBody());
    }

    // 위도, 경도를 주소로 변환
    public String getAddressFromCoordinates(double latitude, double longitude) {
        String url = String.format("%s?coords=%f,%f&output=json", geocodingUrl, longitude, latitude);

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 엔티티 설정
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // API 호출
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info("API Response: {}", response.getBody());

        // 응답 데이터에서 주소 추출
        return extractAddressFromResponse(response.getBody());
    }

    // 응답에서 위도, 경도를 추출
    private Map<String, Object> extractLatLngFromResponse(String jsonResponse) {
        Map<String, Object> result = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode address = root.path("addresses").get(0);

            result.put("lat", address.path("y").asText());
            result.put("lng", address.path("x").asText());
        } catch (Exception e) {
            log.error("Error extracting latitude and longitude: {}", e.getMessage());
        }
        return result;
    }

    // 응답에서 주소를 추출
    private String extractAddressFromResponse(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);

            // API 응답이 정상인지 확인
            if (root.path("status").path("code").asInt() != 0) {
                return "주소를 찾을 수 없습니다.";
            }

            // 결과에서 첫 번째 주소 추출
            JsonNode results = root.path("results");
            if (results.isEmpty()) {
                return "주소 정보를 찾을 수 없습니다.";
            }

            JsonNode region = results.get(0).path("region");
            String area1 = region.path("area1").path("name").asText();  // 서울특별시
            String area2 = region.path("area2").path("name").asText();  // 중구
            String area3 = region.path("area3").path("name").asText();  // 태평로1가

            return String.format("%s %s %s", area1, area2, area3).trim();
        } catch (Exception e) {
            return "주소 변환 오류: " + e.getMessage();
        }
    }
}
