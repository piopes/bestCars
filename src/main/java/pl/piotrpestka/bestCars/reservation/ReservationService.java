package pl.piotrpestka.bestCars.reservation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.piotrpestka.bestCars.car.Car;
import pl.piotrpestka.bestCars.car.CarRepository;
import pl.piotrpestka.bestCars.user.User;
import pl.piotrpestka.bestCars.user.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, CarRepository carRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public UserDetails getCurrentLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication;
    }

    public Car findCarById(Long carId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("We can't find that car"));
        return car;
    }


    public boolean makeReservation(Long carId, LocalDate dateFrom, LocalDate dateTo){
        String email = getCurrentLoggedUser().getUsername();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("We can't find that car"));
        Reservation reservation = new Reservation(dateFrom, dateTo,car.getId(), user.getId());
        Reservation madeReservation = reservationRepository.save(reservation);
        return madeReservation !=null;

    }


   /* private void validateReservationDates(LocalDate from, LocalDate to, Long carId) {
        boolean noneOfTheReservationOverlap = reservationRepository.findAllByCarId(carId).
    }*/


}
