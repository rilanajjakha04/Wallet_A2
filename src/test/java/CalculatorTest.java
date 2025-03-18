import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


//@TestMethodOrder(MethodOrderer.class)
public class CalculatorTest {

    @Test
    void testCalculatorAdd() {
        Assertions.assertEquals(11, Calculator.add(1, 10));
        Assertions.assertEquals(30, Calculator.add(10, 20));
        Assertions.assertEquals(5, Calculator.add(2, 3));
    }

//    @Order(1)
    @ParameterizedTest // (WAJIB SEPAKET) harus dipakai kalo test method butuh parameter
    @CsvSource ({ // jika butuh kombinasi di test method
            "1, 10, 11",
            "10, 20, 30",
            "2, 3, 5",
    })
    void testAddition(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a, b));
    }  // sampai sini bisanya 1 gt


//    @Order(2)
    @ParameterizedTest
    @CsvSource ({
            "1, 10, 11",
            "10, 20, 30",
            "2, 3, 5",
    })
    void testMultiply(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a, b));
    }

    // ini yang bener
    @ParameterizedTest
    @CsvSource ({
            "1, 10, 10",  // 1 * 10 = 10
            "10, 20, 200", // 10 * 20 = 200
            "2, 3, 6" // 2 * 3 = 6
    })
    void testMultiply1(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.multiply(a, b));
    }


    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    void testEven(int number) {
        Assertions.assertTrue(Calculator.isEven(number));
        // apakah numbernya genap apa ngga?
    }


    static Stream<List<String>> provideArray() {
        return Stream.of(
                Arrays.asList("abc", "def", "ghi"),
                Arrays.asList("def", "ghi", "abc", "def")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArray")
    void testYangPakaiArray(List<String>array) {
        Assertions.assertNotNull(array);
    }

//    static Stream<Arguments> provideAddData() {
//        return Stream.of(
//                Arguments.of(1, 10, 11),
//                Arguments.of(10, 20, 30),
//                Arguments.of(2, 3, 5)
//        );
//    }

    // dari ("provideAddData") -> ("TestData#provideAddData") pindah kelas
    @ParameterizedTest
    @MethodSource("TestData#provideAddData")
    void TestAddPakaiMethod(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a, b));
    }
}

// jelasin lagi PAKAI YANG LAIN JANGAN CALCULATOR, bikin kelas baru jg boleh otomatis parameternya jg beda.
// minimal kek hari ini
// ada method yang lain selain @Csvresore, mungkin ada source yang lain? intinya masi berhubungan dengan souce
// IMPLEMENTASIKAN LAGI KEK HARI INI
// KODE UNDERTEST & TEST-NYA

// @test order gausah
