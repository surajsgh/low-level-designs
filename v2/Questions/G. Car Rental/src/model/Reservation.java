package model;

import enums.ReservationStatus;

import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private String carId;
    private String customerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private ReservationStatus reservationStatus;

    public Reservation(String id, String carId, String customerId, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public String getCarId() {
        return carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", carId='" + carId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}


