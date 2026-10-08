package com.parkingfinder.controller;

import com.parkingfinder.dto.ParkingResponse;
import com.parkingfinder.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins="*")
public class ParkingController {
    private final ParkingService service;
    public ParkingController(ParkingService service){this.service=service;}

    @GetMapping("/nearby")
    public ResponseEntity<List<ParkingResponse>> nearby(
        @RequestParam double latitude,
        @RequestParam double longitude,
        @RequestParam(defaultValue="2000") double radius) {
        if(latitude < -90 || latitude > 90) throw new IllegalArgumentException("Invalid latitude");
        if(longitude < -180 || longitude > 180) throw new IllegalArgumentException("Invalid longitude");
        if(radius <= 0 || radius > 50000) throw new IllegalArgumentException("Radius must be 1-50000 meters");
        return ResponseEntity.ok(service.findNearby(latitude,longitude,radius));
    }
}
