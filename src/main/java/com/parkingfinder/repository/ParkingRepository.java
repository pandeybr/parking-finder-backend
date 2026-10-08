package com.parkingfinder.repository;

import com.parkingfinder.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query(value = """
        SELECT p.* FROM parking p
        WHERE ST_DWithin(
          ST_SetSRID(ST_MakePoint(p.longitude, p.latitude),4326)::geography,
          ST_SetSRID(ST_MakePoint(:longitude, :latitude),4326)::geography,
          :radius)
        ORDER BY ST_Distance(
          ST_SetSRID(ST_MakePoint(p.longitude, p.latitude),4326)::geography,
          ST_SetSRID(ST_MakePoint(:longitude, :latitude),4326)::geography)
        """, nativeQuery = true)
    List<Parking> findNearby(@Param("latitude") double latitude,
                             @Param("longitude") double longitude,
                             @Param("radius") double radius);
}
