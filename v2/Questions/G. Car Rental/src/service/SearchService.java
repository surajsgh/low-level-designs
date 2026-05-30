package service;

import enums.CarCategory;
import enums.ReservationStatus;
import model.Car;
import model.Reservation;
import repository.CarRepository;
import repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

public class SearchService {
    CarRepository carRepository;
    ReservationRepository reservationRepository;

    public SearchService(CarRepository carRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Car> searchCar(CarCategory carCategory, double startPrice, double endPrice, LocalDateTime startTime, LocalDateTime endTime) {
        return carRepository.getCars().stream().
            filter(car ->
                    car.getCarCategory().equals(carCategory)
            ).filter(car ->
                car.getRentalPrice() >= startPrice && car.getRentalPrice() <= endPrice
            ).filter(car ->
                isAvailable(car.getId(), startTime, endTime)
            ).toList();
    }

    public boolean isAvailable(String carId, LocalDateTime startTime, LocalDateTime endTime) {
        for (Reservation reservation: reservationRepository.getReservation()) {
            if (!reservation.getCarId().equals(carId)) {
                continue;
            }

            if (reservation.getReservationStatus().equals(ReservationStatus.CANCELLED)) {
                continue;
            }

            boolean overlap = !(startTime.isBefore(reservation.getStart()) || endTime.isAfter(reservation.getEnd()));
            if (overlap) return false;
        }
        return true;
    }
}
