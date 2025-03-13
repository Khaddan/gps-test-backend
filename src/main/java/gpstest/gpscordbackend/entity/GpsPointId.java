package gpstest.gpscordbackend.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GpsPointId implements Serializable {
    // Getters/Setters
    private LocalDateTime date;
    private int idDevice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GpsPointId)) return false;
        GpsPointId that = (GpsPointId) o;
        return idDevice == that.idDevice &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, idDevice);
    }
}