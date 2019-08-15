package pl.piotrpestka.bestCars.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCarForm() {
        return "car/addCarForm";
    }

    @PostMapping("/cars")
    public String addNewCar(@RequestParam String brand, @RequestParam String model,
                            @RequestParam int year, @RequestParam String color,
                            @RequestParam int mileage, @RequestParam String vinNumber,
                            @RequestParam int price, Model mod) {

        try {


            boolean result = carService.addNewCar(brand, model, year, color, mileage, vinNumber, price);
            // List<Car> listOfCars = carService.findAll();
            mod.addAttribute("addedCar", result);
            // mod.addAttribute("allMyCars",listOfCars);
            return "car/deletedCarInfo";

        } catch (Exception e) {
            mod.addAttribute("errorMessage", e.getLocalizedMessage());
            return "car/addCarForm";
        }


    }

    @GetMapping("/cars/delete")
    public String listOfCars(Model model) {
        List<Car> listOfCars = carService.findAll();
        model.addAttribute("allMyCars", listOfCars);

        return "car/deleteCar";
    }

    @GetMapping("/cars/deleteCar")
    public String deleteCar(@RequestParam long carId, Model model) {
        Car car = carService.deleteCar(carId);
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("deleteCarResult", true);
        model.addAttribute("deletedCar", car.getBrand()+ " " + car.getModel());
        return "car/deletedCarInfo";
    }
    @GetMapping("/cars/listofbought")
    public String listOfBoughtCars(Model model){
        List<Car> listOfBoughtCars = carService.listOfBought;
        model.addAttribute("listOfBought", listOfBoughtCars);
        return "car/yourCars";
    }
    @GetMapping("/cars/rent")
    public String rentCar(Model model) {
        List<Car> listOfCars = carService.findAll();
        model.addAttribute("allMyCars", listOfCars);

        return "car/rentCar";
    }


}