package com.maptist.mappride.mappride.place;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final NaverGeocodingService naverGeocodingService;

    public LocationController(NaverGeocodingService naverGeocodingService) {
        this.naverGeocodingService = naverGeocodingService;
    }

    @GetMapping("/reverse-geocode")
    public String getAddress(@RequestParam("lat") double lat, @RequestParam("lon") double lon) {
        return naverGeocodingService.getAddressFromCoordinates(lat, lon);
    }
}
