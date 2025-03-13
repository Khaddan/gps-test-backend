package gpstest.gpscordbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@IdClass(GpsPointId.class)
@Table(name = "arch_1004901")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GpsPoint {
    @Id
    @Column(name = "date") // Correspond à la colonne 'date' en base
    private LocalDateTime date;

    @Getter
    @Id
    @Column(name = "id_device") // Colonne 'id_device' en base (pas 'device_id')
    private int idDevice;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "speed")
    private int speed;

    @Column(name = "fuel")
    private int fuel;

    @Column(name = "heading")
    private int heading;

    @Column(name = "temp")
    private int temp;

    @Column(name = "tram_id")
    private int tramId;

    public int getIdDevice() {
        return this.idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

}