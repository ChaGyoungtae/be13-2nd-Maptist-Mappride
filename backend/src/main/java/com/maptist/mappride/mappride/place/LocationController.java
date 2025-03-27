package com.maptist.mappride.mappride.place;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class LocationController {
    private final NaverGeocodingService naverGeocodingService;

    public LocationController(NaverGeocodingService naverGeocodingService) {
        this.naverGeocodingService = naverGeocodingService;
    }

    @GetMapping("/geocode")
    public ResponseEntity<Map<String,Object>> getGeocode(@RequestParam String address) {

        log.info("geocode address = {}",address);
        log.info("geocode address = {}",address);
        return ResponseEntity.ok(naverGeocodingService.getGeocode(address));
    }
    @GetMapping("/reverse-geocode")
    public String getAddress(@RequestParam("lat") double lat, @RequestParam("lon") double lon) {
        return naverGeocodingService.getAddressFromCoordinates(lat, lon);
    }
}
