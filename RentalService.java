import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public ActiveRental startRental(String bikeID, String userEmail) {
        if (bikeID == null || userEmail == null) {
            return null;
        }
        LocalDateTime tripStartTime = LocalDateTime.now();
        ActiveRental rental = new ActiveRental(bikeID, userEmail, tripStartTime);
        activeRentalsList.add(rental);
        return rental;
    }

    public boolean endRental(String bikeID) {
        if (bikeID == null) {
            return false;
        }
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID() != null && rental.getBikeID().equalsIgnoreCase(bikeID)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean cancelRental(String bikeID) {
        return endRental(bikeID);
    }

    public void displayActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
            return;
        }
        for (ActiveRental rental : activeRentalsList) {
            System.out.println(rental);
        }
    }

    public LinkedList<ActiveRental> getActiveRentals() {
        return activeRentalsList;
    }
}
