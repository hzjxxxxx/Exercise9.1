import java.time.LocalDateTime;

public class BikeService {

    public String findAvailableBike(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation() != null 
                    && bike.getLocation().equalsIgnoreCase(location) 
                    && bike.isAvailable()) {
                return bike.getBikeID();
            }
        }
        return null;
    }

    public boolean validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation() != null 
                    && bike.getLocation().equalsIgnoreCase(location) 
                    && bike.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public void reserveBike(String bikeID) {
        if (bikeID == null) {
            return;
        }
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID() != null && bike.getBikeID().equalsIgnoreCase(bikeID)) {
                bike.setIsAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }

    public void releaseBike(String bikeID) {
        if (bikeID == null) {
            return;
        }
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID() != null && bike.getBikeID().equalsIgnoreCase(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }
}
