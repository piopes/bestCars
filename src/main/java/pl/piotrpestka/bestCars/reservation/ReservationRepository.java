package pl.piotrpestka.bestCars.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

  Optional<Reservation>findAllByCarId(Long carId);
}
