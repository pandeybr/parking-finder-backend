package com.parkingfinder.service;

import com.parkingfinder.dto.ParkingResponse;
import com.parkingfinder.entity.Parking;
import com.parkingfinder.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingService {
    private final ParkingRepository repository;
    public ParkingService(ParkingRepository repository){this.repository=repository;}

    public List<ParkingResponse> findNearby(double latitude,double longitude,double radius){
        return repository.findNearby(latitude,longitude,radius).stream()
            .map(p -> new ParkingResponse(p.getId(),p.getName(),p.getAddress(),
                p.getLatitude(),p.getLongitude(),
                Math.round(haversine(latitude,longitude,p.getLatitude(),p.getLongitude())*10)/10.0,
                p.getCapacity(),p.getAvailableSpaces(),p.getPricePerHour(),
                p.getParkingType(),p.getRating()))
            .toList();
    }

    private double haversine(double lat1,double lon1,double lat2,double lon2){
        double r=6371000, dLat=Math.toRadians(lat2-lat1), dLon=Math.toRadians(lon2-lon1);
        double a=Math.sin(dLat/2)*Math.sin(dLat/2)+
            Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*
            Math.sin(dLon/2)*Math.sin(dLon/2);
        return r*2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
    }
}
