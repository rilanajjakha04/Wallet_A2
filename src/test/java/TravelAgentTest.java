import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

public class TravelAgentTest {

    @Test
    void testCekBookingIdManual() {
        Assertions.assertTrue(TravelAgent.cekBookingId("BOOK-1234"));
        Assertions.assertFalse(TravelAgent.cekBookingId("INVALID-5678"));
        Assertions.assertFalse(TravelAgent.cekBookingId(null));
    }

    // Test dengan @ValueSource → Menguji calculateTotalPrice
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void testCalculateTotalPrice(int numPeople) {
        int pricePerPerson = 100;
        int expected = pricePerPerson * numPeople;
        Assertions.assertEquals(expected, TravelAgent.calculateTotalPrice(pricePerPerson, numPeople));
    }

    // Test dengan @CsvSource → Menguji destinasi tersedia atau tidak
    @ParameterizedTest
    @CsvSource({
            "Bali, true",
            "Jakarta, true",
            "Surabaya, true",
            "Yogyakarta, true",
            "'', false",
            "'Paris', false"
    })
    void testIsDestinationAvailable(String destination, boolean expected) {
        Assertions.assertEquals(expected, TravelAgent.isDestinationAvailable(destination));
    }

    // Test dengan @MethodSource → Menguji validasi Booking ID
    static Stream<Arguments> provideBookingIds() {
        return Stream.of(
                Arguments.of("BOOK-1234", true),
                Arguments.of("INVALID-1234", false),
                Arguments.of("1234-BOOK", false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideBookingIds")
    void testCekBookingId(String bookingId, boolean expected) {
        Assertions.assertEquals(expected, TravelAgent.cekBookingId(bookingId));
    }

    // Test dengan @EnumSource → Menguji kategori paket berdasarkan enum
    @ParameterizedTest
    @EnumSource(TravelAgent.PackageType.class)
    void testGetPackageCategory(TravelAgent.PackageType type) {
        Assertions.assertEquals(type.name(), TravelAgent.getPackageCategory(type));
    }

    // Test dengan @NullSource → Menguji validasi destinasi dengan input null
    @ParameterizedTest
    @NullSource
    void testDestinationWithNull(String destination) {
        Assertions.assertFalse(TravelAgent.isDestinationAvailable(destination));
    }

    // Test dengan @EmptySource → Menguji validasi destinasi dengan input kosong
    @ParameterizedTest
    @EmptySource
    void testDestinationWithEmpty(String destination) {
        Assertions.assertFalse(TravelAgent.isDestinationAvailable(destination));
    }
}
