package service;

import enums.ReservationStatus;
import model.Car;
import model.Customer;
import model.Reservation;
import repository.ReservationRepository;
import strategy.CreditCardPayment;
import strategy.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ReservationService {
    SearchService searchService;
    ReservationRepository reservationRepository;
    PaymentStrategy paymentStrategy = new CreditCardPayment();

    public ReservationService(SearchService searchService, ReservationRepository reservationRepository) {
        this.searchService = searchService;
        this.reservationRepository = reservationRepository;
    }

    public synchronized Reservation createReservation(Car car, Customer customer, LocalDateTime startTime, LocalDateTime endTime, double amount) {
        boolean available = searchService.searchCar(car.getCarCategory(), 0, Double.MAX_VALUE, startTime, endTime).stream().anyMatch(existingCar -> existingCar.getId().equals(car.getId()));

        if(!available) throw new RuntimeException("Car already booked.");

        Reservation reservation = new Reservation(UUID.randomUUID().toString(), car.getId(), customer.getId(), startTime, endTime);
        reservation.setReservationStatus(ReservationStatus.COMPLETE);
        reservationRepository.save(reservation);
        paymentStrategy.pay(amount, customer);
        return reservation;
    }

    public void modifyReservation(String reservationId, LocalDateTime startTime, LocalDateTime endTime) {
        Reservation reservation = reservationRepository.getByReservationId(reservationId);
        if (reservation==null) {
            throw new RuntimeException("No reservation found");
        }

        reservation.setStart(startTime);
        reservation.setEnd(endTime);
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationRepository.getByReservationId(reservationId);
        if (reservation==null) {
            throw new RuntimeException("No reservation found");
        }

        reservation.setReservationStatus(ReservationStatus.CANCELLED);
    }
}
