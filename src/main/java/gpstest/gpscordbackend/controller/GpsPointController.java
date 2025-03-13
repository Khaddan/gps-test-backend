package gpstest.gpscordbackend.controller;

import gpstest.gpscordbackend.entity.GpsPoint;
import gpstest.gpscordbackend.entity.GpsPointId;
import gpstest.gpscordbackend.service.GpsPointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Validated
@RestController
@RequestMapping("/api/gps-points")
public class GpsPointController {

    private final GpsPointService gpsPointService;

    public GpsPointController(GpsPointService gpsPointService) {
        this.gpsPointService = gpsPointService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GpsPoint> getAllGpsPoints() {
        return gpsPointService.getAllGPSPoints(); // Ensure this method exists in the service
    }
    @GetMapping("/devices/{idDevice}")
    public ResponseEntity<List<GpsPoint>> getGpsPointsByDeviceId(@PathVariable int idDevice) {
        List<GpsPoint> points = gpsPointService.getGpsPointsByDeviceId(idDevice);
        return ResponseEntity.ok(points); // Always returns 200, even if empty
    }

//    @Operation(summary = "Get GPS points within a timestamp range")
//    @GetMapping("/range")
//    public List<GpsPoint> getGpsPointsByRange(
//            @Parameter(description = "Start timestamp (ISO format)")
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
//            @Parameter(description = "End timestamp (ISO format)")
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
//        return gpsPointService.getGpsPointsByTimestamp(start, LocalDateTime.parse(String.valueOf(end)));
//    }
@GetMapping("/range")
public ResponseEntity<List<GpsPoint>> getGpsPointsByRange(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
    return ResponseEntity.ok(gpsPointService.getGpsPointsByTimestamp(start, end));
}


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(NoSuchElementException ex) {
        return ex.getMessage();
    }
}