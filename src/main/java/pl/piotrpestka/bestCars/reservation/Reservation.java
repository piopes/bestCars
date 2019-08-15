package pl.piotrpestka.bestCars.reservation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateTo;
    private Long userId;
    private Long carId;

    public Reservation(LocalDate dateFrom, LocalDate dateTo, Long userId, Long carId) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.userId = userId;
        this.carId = carId;
    }

    public Reservation() {
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
