import enums.CarCategory;
import model.Car;
import model.Customer;
import repository.CarRepository;
import repository.CustomerRepository;
import repository.ReservationRepository;
import service.ReservationService;
import service.SearchService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        Car car = new Car(UUID.randomUUID().toString(), "Maruti", "800", 2026, "KA02AB1234", 1000, CarCategory.SUV);
        carRepository.save(car);

        CustomerRepository customerRepository = new CustomerRepository();
        Customer suraj = new Customer(UUID.randomUUID().toString(), "Suraj", "1234567890", "1212");
        Customer mansi = new Customer(UUID.randomUUID().toString(), "Mansi", "0987654321", "1111");
        customerRepository.save(suraj);
        customerRepository.save(mansi);

        ReservationRepository reservationRepository = new ReservationRepository();

        SearchService searchService = new SearchService(carRepository, reservationRepository);
        ReservationService reservationService = new ReservationService(searchService, reservationRepository);

        Thread firstThread = new Thread(() -> {
            reservationService.createReservation(car, suraj, LocalDateTime.now(), LocalDateTime.now().plusDays(3), 1000);
        });

        Thread secondThread = new Thread(() -> {
           reservationService.createReservation(car, mansi, LocalDateTime.now(), LocalDateTime.now().plusDays(2), 750);
        });

        try {
            firstThread.start();
            firstThread.join();
            secondThread.start();
            secondThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}