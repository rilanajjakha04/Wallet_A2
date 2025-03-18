// pakai static bisa langsung memanggil metode tersebut tanpa harus membuat objek dari kelas Calculator
public class Calculator {
    public  static int add(int a, int b) {
        return a + b;
    }

    public  static int multiply(int a, int b) {
        return a * b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}