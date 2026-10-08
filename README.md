# Parking Finder MVP

Runnable Java 21 / Spring Boot backend that finds nearby parking using PostgreSQL + PostGIS.

## Prerequisites
- Java 21
- Maven 3.9+
- Docker Desktop
- IntelliJ IDEA (recommended)

## Start database
From the project directory:

```bash
docker compose up -d
```

## Start application

```bash
mvn spring-boot:run
```

Or run `ParkingFinderApplication` from IntelliJ.

The API runs at `http://localhost:8080`.

## Test

Open in browser/Postman:

```text
http://localhost:8080/api/parking/nearby?latitude=18.5204&longitude=73.8567&radius=5000
```

Or:

```bash
curl "http://localhost:8080/api/parking/nearby?latitude=18.5204&longitude=73.8567&radius=5000"
```

The result contains parking name, coordinates, distance in meters, capacity, availability, price and rating.

## Project structure

```text
parking-finder
├── pom.xml
├── docker-compose.yml
├── README.md
└── src/main
    ├── java/com/parkingfinder
    │   ├── ParkingFinderApplication.java
    │   ├── config/DataInitializer.java
    │   ├── controller/ParkingController.java
    │   ├── dto/ParkingResponse.java
    │   ├── entity/Parking.java
    │   ├── repository/ParkingRepository.java
    │   └── service/ParkingService.java
    └── resources
        ├── application.yml
        └── schema.sql
```

## Important
The included Pune parking records are demo data, not verified live parking availability.

## Next
- Flutter mobile UI + map
- User GPS location
- Google Maps/Mapbox navigation
- Add/update parking locations
- Authentication
- Parking-owner portal
- Live availability
- Reservation and payment
