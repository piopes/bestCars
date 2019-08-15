package pl.piotrpestka.bestCars.car;

import pl.piotrpestka.bestCars.reservation.Reservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private String vinNumber;
    private int price;
    private CarStatus carStatus;
    @OneToMany(mappedBy = "carId")
    List<Reservation> ReservationList;


    public Car(String brand, String model, int year, String color, int mileage, String vinNumber, int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
        this.price = price;
        this.carStatus = CarStatus.AVAILABLE;
        this.ReservationList = new ArrayList<>();


    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }


}
