package com.parkingfinder.dto;

public record ParkingResponse(
    Long id, String name, String address, double latitude, double longitude,
    double distanceMeters, int capacity, int availableSpaces,
    double pricePerHour, String parkingType, double rating) {}
