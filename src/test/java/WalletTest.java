import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    public static Wallet wallet;

    public WalletTest() {
    }

    @BeforeAll
    static void setup() {
        wallet = new Wallet();
    }

    @BeforeEach
    void setupMethod() {
        wallet.clearWallet();
        wallet.addMoney(100000, true);
        System.out.println("Test mulai");
    }

    @Test
    void testOwnerTidakBisaDiubah() {
        wallet.setOwner("Rila");
        assertEquals("Rila", wallet.getOwner());

        wallet.setOwner("Nana");
        assertEquals("Rila", wallet.getOwner());
    }

    @Test
    void testMenambahKartu() {
        wallet.addCard("BRI");
        wallet.addCard("BCA");

        List<String> expectedCards = Arrays.asList("BRI", "BCA");
        assertEquals(expectedCards, wallet.getCards());
    }

    @Test
    void testKartuTidakBolehDuplikat() {
        wallet.addCard("BRI");
        wallet.addCard("BRI");

        List<String> cards = wallet.getCards();
        assertEquals(1, cards.size());
        assertTrue(cards.contains("BRI"));
        assertFalse(cards.contains("BCA"));
    }

    @Test
    void testTambahUang() {
        wallet.addMoney(200000, true);
        wallet.addMoney(50000, false);

        assertEquals(350000, wallet.getTotalMoney(), "Total uang harus Rp350.000 setelah penambahan");
    }

    @Test
    void testTarikUang() {
        wallet.addMoney(50000, true);

        assertTrue(wallet.withdrawMoney(50000, true));
        assertEquals(100000, wallet.getTotalMoney());

        assertFalse(wallet.withdrawMoney(60000, true));
        assertEquals(100000, wallet.getTotalMoney());
    }

    @Test
    void testAmbilKartu() {
        wallet.addCard("BCA");
        assertTrue(wallet.takeCard("BCA"), "Harus bisa mengambil kartu BCA");
    }

    @Test
    void testTampilTotalUang() {
        wallet.addMoney(200000, true);
        wallet.addMoney(100000, false);

        System.out.println("Total uang di dompet: Rp" + wallet.getTotalMoney());

        assertEquals(400000, wallet.getTotalMoney(), "Total uang harus Rp400000");
    }

    @AfterEach
    void cleanupMethod() {
        wallet.clearWallet();
        System.out.println("Test selesai");
    }

    @AfterAll
    static void cleanup() {
        wallet = null;
        System.out.println("Semua test selesai");
    }
}











// SETELAH PERBAIKAN

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.Arrays;
//import java.util.List;
//
//public class WalletTest {
//
//    @Test
//    void testOwnerTidakBisaDiubah() {
//        Wallet wallet = new Wallet();
//
//        wallet.setOwner("Rila");
//        assertEquals("Rila", wallet.getOwner()); // Harus sukses, karena owner pertama kali di-set
//
//        wallet.setOwner("Nana");
//        assertEquals("Rila", wallet.getOwner()); // Owner tetap "Rila", tidak boleh berubah
//    }
//
//    @Test
//    void testMenambahKartu() {
//        Wallet wallet = new Wallet();
//
//        wallet.addCard("BRI");
//        wallet.addCard("BCA");
//
//        List<String> expectedCards = Arrays.asList("BRI", "BCA");
//        assertEquals(expectedCards, wallet.getCards()); // List kartu harus berisi "BRI" & "BCA"
//    }
//
//    @Test
//    void testKartuTidakBolehDuplikat() {
//        Wallet wallet = new Wallet();
//        wallet.addCard("BRI");
//
//        wallet.addCard("BRI"); // Seharusnya tidak ditambahkan lagi
//
//        List<String> cards = wallet.getCards();
//
//        assertEquals(1, cards.size(), "Kartu duplikat tidak boleh ditambahkan");
//
//        assertTrue(cards.contains("BRI"), "Kartu BRI harus tetap ada");
//        assertFalse(cards.contains("BCA"), "BCA belum pernah ditambahkan");
//    }
//
//    @Test
//    void testTambahUang() {
//        Wallet wallet = new Wallet();
//
//        wallet.addMoney(200000, true);
//        wallet.addMoney(50000, false);
//
//        assertEquals(250000, wallet.getTotalMoney(), "Total uang harus Rp250.000 setelah penambahan");
//    }
//
//    @Test
//    void testTarikUang() {
//        Wallet wallet = new Wallet();
//        wallet.addMoney(100000, true);
//        wallet.addMoney(50000, true);
//
//        assertEquals(150000, wallet.getTotalMoney(), "Saldo awal harus Rp150.000");
//
//        assertTrue(wallet.withdrawMoney(50000, true), "Harus bisa menarik Rp50.000");
//        assertEquals(100000, wallet.getTotalMoney(), "Saldo harus Rp100.000 setelah penarikan Rp50.000");
//
//        assertFalse(wallet.withdrawMoney(60000, true), "Tidak bisa menarik lebih dari saldo yang tersedia");
//        assertEquals(100000, wallet.getTotalMoney(), "Saldo tetap Rp100.000 karena penarikan Rp60.000 gagal");
//    }
//
//    @Test
//    void testAmbilKartu() {
//        Wallet wallet = new Wallet();
//
//        wallet.addCard("BCA");
//        assertTrue(wallet.takeCard("BCA"), "Harus bisa mengambil kartu BCA");
//    }
//
//    @Test
//    void testTampilTotalUang() {
//        Wallet wallet = new Wallet();
//
//        wallet.addMoney(200000, true);
//        wallet.addMoney(100000, false);
//
//        System.out.println("Total uang di dompet: Rp" + wallet.getTotalMoney());
//
//        assertEquals(300000, wallet.getTotalMoney(), "Total uang harus Rp300000");
//    }
//}














// SEBELUM PERBAIKAN

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//class WalletTest {
//
//    @Test
//    void testOwnerTidakBisaDiubah() {
//        Wallet wallet = new Wallet();
//
//        wallet.setOwner("Rila");
//
//        assertEquals("Rila", wallet.getOwner()); // Harus sukses, karena owner pertama kali di-set
//
//        wallet.setOwner("Nana");
//        assertEquals("Rila", wallet.getOwner()); // Owner tetap "Rila", tidak boleh berubah
//    }
//
//    @Test
//    void testMenambahKartu() {
//        Wallet wallet = new Wallet();
//
//        wallet.addCard("BRI");
//        wallet.addCard("BCA");
//
//        List<String> expectedCards = Arrays.asList("BRI", "BCA");
//        assertEquals(expectedCards, wallet.getCards()); // List kartu harus berisi "BRI" & "BCA"
//    }
//
//    @Test
//    void testKartuTidakBolehDuplikat() {
//        Wallet wallet = new Wallet();
//        wallet.addCard("BRI");
//
//        wallet.addCard("BRI"); // Seharusnya tidak ditambahkan lagi
//
//        List<String> cards = wallet.getCards();
//
//        assertEquals(1, cards.size(), "Kartu duplikat tidak boleh ditambahkan");
//
//        assertTrue(cards.contains("BRI"), "Kartu BRI harus tetap ada");
//        assertFalse(cards.contains("BCA"), "BCA belum pernah ditambahkan");
//    }
//
//    @Test
//    void testTambahDanTampilkanTotalUang() {
//        Wallet wallet = new Wallet();
//
//        wallet.addMoney(75000, true);
//        wallet.addMoney(3500, false);
//
//        System.out.println("Total uang setelah penambahan: Rp" + wallet.getTotalMoney());
//
//        assertEquals(78500, wallet.getTotalMoney(), "Total uang harus Rp78.500");
//    }
//
//    @Test
//    void testTarikUang() {
//        Wallet wallet = new Wallet();
//        wallet.addMoney(100000, true);
//        wallet.addMoney(50000, true);
//
//        assertTrue(wallet.withdrawMoney(50000, true), "Harus bisa menarik Rp50.000");
//        assertFalse(wallet.withdrawMoney(60000, true), "Tidak bisa menarik lebih dari saldo");
//
//        System.out.println("Sisa saldo: Rp" + wallet.getTotalMoney());
//
//        assertEquals(100000, wallet.getTotalMoney(), "Sisa uang harus Rp100.000 (karena 50.000 diambil dari 150.000)");
//    }
//
//    @Test
//    void testTarikUang1() {
//        Wallet wallet = new Wallet();
//        wallet.addMoney(100000, true);
//        wallet.addMoney(50000, true);
//
//        // Cek total saldo awal
//        assertEquals(150000, wallet.getTotalMoney(), "Saldo awal harus Rp150.000");
//
//        // Tarik uang Rp50.000 (harus berhasil)
//        assertTrue(wallet.withdrawMoney(50000, true), "Harus bisa menarik Rp50.000");
//        assertEquals(100000, wallet.getTotalMoney(), "Saldo harus Rp100.000 setelah penarikan Rp50.000");
//
//        // Coba tarik Rp60.000 (harus gagal)
//        assertFalse(wallet.withdrawMoney(60000, true), "Tidak bisa menarik lebih dari saldo yang tersedia");
//        assertEquals(100000, wallet.getTotalMoney(), "Saldo tetap Rp100.000 karena penarikan Rp60.000 gagal");
//
//        System.out.println("Sisa saldo setelah transaksi: Rp" + wallet.getTotalMoney());
//    }
//
//
//    @Test
//    void testMenambahDanMengambilKartu() {
//        Wallet wallet = new Wallet();
//
//        wallet.addCard("BCA");
//        wallet.addCard("Mandiri");
//
//        assertTrue(wallet.takeCard("BCA"), "Harus bisa mengambil kartu BCA");
//        assertFalse(wallet.takeCard("BCA"), "Tidak bisa mengambil kartu BCA lagi");
//
//        assertEquals(1, wallet.getCards().size(), "Harus tersisa 1 kartu di dompet");
//        assertTrue(wallet.getCards().contains("Mandiri"), "Mandiri harus tetap ada");
//    }
//}















//// NOMOR 1
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WalletTest {
//
//    @Test
//    void testOwnerTidakBisaDiubah() {
//        Wallet wallet = new Wallet();
//
//        wallet.setOwner("Rila");
//
//        assertEquals("Rila", wallet.getOwner()); // Harus sukses, karena owner pertama kali di-set
//
//        wallet.setOwner("Nana");
//        assertEquals("Rila", wallet.getOwner()); // Owner tetap "Rila", tidak boleh berubah
//    }
//
//    @Test
//    void testMenambahKartu() {
//        Wallet wallet = new Wallet();
//
//        wallet.addCard("BRI");
//        wallet.addCard("BCA");
//
//        List<String> expectedCards = Arrays.asList("BRI", "BCA");
//        assertEquals(expectedCards, wallet.getCards()); // List kartu harus berisi "BRI" & "BCA"
//    }
//
//    @Test
//    void testKartuTidakBolehDuplikat() {
//        Wallet wallet = new Wallet();
//        wallet.addCard("BRI");
//
//        wallet.addCard("BRI"); // Seharusnya tidak ditambahkan lagi
//
//        List<String> cards = wallet.getCards();
//
//        assertEquals(1, cards.size(), "Kartu duplikat tidak boleh ditambahkan");
//
//        assertTrue(cards.contains("BRI"), "Kartu BRI harus tetap ada");
//        assertFalse(cards.contains("BCA"), "BCA belum pernah ditambahkan");
//    }
//}