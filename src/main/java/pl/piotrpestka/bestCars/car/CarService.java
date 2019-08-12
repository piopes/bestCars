package pl.piotrpestka.bestCars.car;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    boolean addNewCar (String brand, String model, int year, String color, int mieleage, String vinNumber, int price){
        boolean doWeHaveThatCar = carRepository.findAll().stream().anyMatch(car -> car.getVinNumber().equals(vinNumber));
        if (doWeHaveThatCar){
            throw new RuntimeException ("this car is already in our system,<br/> check your vin number");
        }
        Car car = new Car(brand,model,year,color,mieleage,vinNumber, price);
        Car carAdded = carRepository.save(car);

        return carAdded !=null;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }
    List<Car> listOfBought = new ArrayList<>();

    public Car deleteCar(long carId){
        Car car = carRepository.findById(carId).orElseThrow(()-> new RuntimeException("We can't find that car") );
        listOfBought.add(car);
        carRepository.delete(car);
        return car;

    }


}
