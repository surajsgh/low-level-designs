import java.util.List;

public class ParkingLot {
    private final List<Level> levels;
    private final AvailabilityService availabilityService;
    private final ParkService parkService;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
        this.availabilityService = new AvailabilityService();
        this.parkService = new ParkService();
    }

    public int getAvailableFreeSpots(int levelId) {
        return this.availabilityService.getAvailableFreeSpots(this.levels, levelId);
    }

    public int totalAvailableFreeSpots() {
        return this.availabilityService.totalAvailableFreeSpots(this.levels);
    }

    public ParkingSpot park(int levelId, Vehicle vehicle) {
        return this.parkService.park(this.levels, levelId, vehicle);
    }

    public void release(int levelId, ParkingSpot parkingSpot) {
        this.parkService.release(levels, levelId, parkingSpot);
    }
}

class AvailabilityService {
    public int getAvailableFreeSpots(List<Level> levels, int levelId) {
        if (levelId<=0) {
            throw new RuntimeException("Please enter a valid input");
        }
        for (Level level: levels) {
            if (level.getId()==levelId) {
                return level.totalAvailableSpots();
            }
        }
        System.out.println("Please enter a valid entry");
        return 0;
    }

    public int totalAvailableFreeSpots(List<Level> levels) {
        int totalAvailableSpots = 0;
        for (Level level: levels) {
            totalAvailableSpots += level.totalAvailableSpots();
        }
        return totalAvailableSpots;
    }
}

class ParkService {
    public ParkingSpot park(List<Level> levels, int levelId, Vehicle vehicle) {
        if (levelId<=0) {
            throw new RuntimeException("Please enter a valid input");
        }
        for (Level level: levels) {
            if (level.getId()==levelId) {
                return level.park(vehicle);
            }
        }
        return null;
    }

    public void release(List<Level> levels, int levelId, ParkingSpot parkingSpot) throws RuntimeException {
        if (levelId<=0) {
            throw new RuntimeException("Please enter a valid input");
        }
        for (Level level: levels) {
            if (level.getId()==levelId) {
                level.release(parkingSpot);
            }
        }
    }
}