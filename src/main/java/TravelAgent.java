import java.util.Arrays;

public class TravelAgent {
    public static int calculateTotalPrice(int pricePerPerson, int numPeople) {
        return pricePerPerson * numPeople;
    }

    public static boolean isDestinationAvailable(String destination) {
        String[] validDestinations = {"Bali", "Jakarta", "Yogyakarta", "Surabaya"};
        return destination != null && !destination.trim().isEmpty() &&
                Arrays.asList(validDestinations).contains(destination);
    }

    public static boolean cekBookingId(String bookingId) {
        return bookingId != null && bookingId.startsWith("BOOK-") && bookingId.length() == 9;
    }

    public static String getPackageCategory(PackageType type) {
        return type.name();
    }

    public enum PackageType {
        LUXURY, BUDGET, ADVENTURE, FAMILY
    }
}
