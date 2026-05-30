package repository;

import model.Car;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRepository {
    private static final Map<String, Car> map = new ConcurrentHashMap<>();

    public void save(Car car) {
        map.put(car.getId(), car);
    }

    public Car getCarById(String carId) {
        return map.get(carId);
    }

    public Collection<Car> getCars() {
        return map.values();
    }
}
