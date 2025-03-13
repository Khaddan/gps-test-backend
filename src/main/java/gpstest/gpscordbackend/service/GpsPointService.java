package gpstest.gpscordbackend.service;

import gpstest.gpscordbackend.entity.GpsPoint;
import gpstest.gpscordbackend.repository.GpsPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class GpsPointService {
    private final GpsPointRepository gpsPointRepository;

    public GpsPointService(GpsPointRepository gpsPointRepository) {
        this.gpsPointRepository = gpsPointRepository;
    }

    public List<GpsPoint> getAllGPSPoints() {
        return gpsPointRepository.findAll();
    }

    public List<GpsPoint> getGpsPointsByDeviceId(int idDevice) {
        return gpsPointRepository.findAll()
                .stream()
                .filter(point -> point.getIdDevice() == idDevice)
                .toList();
    }

    public List<GpsPoint> getGpsPointsByTimestamp(LocalDateTime start, LocalDateTime end) {
        return gpsPointRepository.findByDateBetween(start, end);
    }
}



//    public List<GpsPoint> getGpsPointsByTimestamp(LocalDateTime start, LocalDateTime end) {
//        return gpsPointRepository.findByTimestampBetween(start, end); // Method name must match
//    }

//    public List<GpsPoint> getAllGpsPoints() {
//        return gpsPointRepository.findAll();
//    }



