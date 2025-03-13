package gpstest.gpscordbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/coords")
public class CoordinatesController {

    @GetMapping
    public List<Coordinate> getCoordinates() {
        // Remplace par les données réelles de ton serveur
        return Arrays.asList(
                new Coordinate(48.8566, 2.3522), // Paris
                new Coordinate(51.5074, -0.1278), // Londres
                new Coordinate(40.7128, -74.0060)  // New York
        );
    }

    static class Coordinate {
        private double lat;
        private double lng;

        public Coordinate(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public double getLng() {
            return lng;
        }
    }
}
