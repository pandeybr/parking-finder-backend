package com.parkingfinder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String address;
    @Column(nullable = false) private double latitude;
    @Column(nullable = false) private double longitude;
    @Column(nullable = false) private int capacity;
    @Column(nullable = false) private int availableSpaces;
    @Column(nullable = false) private double pricePerHour;
    @Column(nullable = false) private String parkingType;
    private double rating;

    public Parking() {}

    public Parking(String name, String address, double latitude, double longitude,
                    int capacity, int availableSpaces, double pricePerHour,
                    String parkingType, double rating) {
        this.name=name; this.address=address; this.latitude=latitude; this.longitude=longitude;
        this.capacity=capacity; this.availableSpaces=availableSpaces; this.pricePerHour=pricePerHour;
        this.parkingType=parkingType; this.rating=rating;
    }

    public Long getId(){return id;}
    public String getName(){return name;}
    public String getAddress(){return address;}
    public double getLatitude(){return latitude;}
    public double getLongitude(){return longitude;}
    public int getCapacity(){return capacity;}
    public int getAvailableSpaces(){return availableSpaces;}
    public double getPricePerHour(){return pricePerHour;}
    public String getParkingType(){return parkingType;}
    public double getRating(){return rating;}
}
