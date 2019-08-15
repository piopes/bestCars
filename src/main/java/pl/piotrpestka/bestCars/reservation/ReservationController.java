package pl.piotrpestka.bestCars.reservation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piotrpestka.bestCars.car.Car;


import java.time.LocalDate;


@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/reservation")
    public String reservation(@RequestParam Long carId, Model model) {
        Car car = reservationService.findCarById(carId);
        model.addAttribute("chosenCar", car.getBrand()+ " " + car.getModel());
        return "reservation/newReservationForm";
    }

    @PostMapping("/reservation/{carId}")
    public String mekeReservation(@PathVariable Long carId,
                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom,
                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo,
                                  Model model){
        try{

            boolean result = reservationService.makeReservation(carId, dateFrom,dateTo);

            model.addAttribute("madeReservation", result);
            return "redirect:/reservation/reservationInfo";

        }catch (Exception e) {
            return "reservation/newReservationForm";
        }
    }
}