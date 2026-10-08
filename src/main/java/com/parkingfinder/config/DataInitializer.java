package com.parkingfinder.config;

import com.parkingfinder.entity.Parking;
import com.parkingfinder.repository.ParkingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner loadSampleData(ParkingRepository repo) {
        return args -> {
            if(repo.count()>0) return;
            repo.save(new Parking("Phoenix Mall Parking","Viman Nagar, Pune",18.5621,73.9167,500,120,50,"MALL",4.3));
            repo.save(new Parking("Koregaon Park Public Parking","Koregaon Park, Pune",18.5362,73.8937,150,32,40,"PUBLIC",4.1));
            repo.save(new Parking("Shivajinagar Metro Parking","Shivajinagar, Pune",18.5308,73.8475,300,75,30,"METRO",4.0));
            repo.save(new Parking("Deccan Parking","Deccan Gymkhana, Pune",18.5158,73.8417,100,18,30,"PUBLIC",3.9));
            repo.save(new Parking("Kalyani Nagar Parking","Kalyani Nagar, Pune",18.5484,73.9037,180,44,35,"PUBLIC",4.2));
            repo.save(new Parking("Hadapsar Parking","Hadapsar, Pune",18.5089,73.9260,220,60,25,"PUBLIC",3.8));
        };
    }
}
