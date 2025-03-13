package gpstest.gpscordbackend.repository;

import gpstest.gpscordbackend.entity.GpsPoint;
import gpstest.gpscordbackend.entity.GpsPointId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GpsPointRepository extends JpaRepository<GpsPoint, GpsPointId> {
    List<GpsPoint> findByIdDevice(int idDevice);
    List<GpsPoint> findByDateBetween(LocalDateTime start, LocalDateTime end);


}