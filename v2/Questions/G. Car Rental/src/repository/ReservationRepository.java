package repository;

import model.Reservation;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    private static final Map<String, Reservation> map = new ConcurrentHashMap<>();

    public void save(Reservation reservation) {
        map.put(reservation.getId(), reservation);
    }

    public Reservation getByReservationId(String reservationId) {
        return map.get(reservationId);
    }

    public Collection<Reservation> getReservation() {
        return map.values();
    }
}
