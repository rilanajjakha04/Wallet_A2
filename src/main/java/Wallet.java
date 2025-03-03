import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String owner;
    private List<String> cards;
    private List<Integer> lembaran;
    private List<Integer> koin;

    public Wallet() {
        this.owner = null;
        this.cards = new ArrayList<>();
        this.lembaran = new ArrayList<>();
        this.koin = new ArrayList<>();
    }

    public void setOwner(String owner) {
        if (this.owner == null) {
            this.owner = owner;
        }
    }

    public String getOwner() {
        return owner;
    }

    public void addCard(String card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    public boolean takeCard(String card) {
        return cards.remove(card);
    }

    public List<String> getCards() {
        return new ArrayList<>(cards);
    }

    public void addMoney(int amount, boolean isLembaran) {
        if (amount > 0) {
            if (isLembaran) {
                lembaran.add(amount);
            } else {
                koin.add(amount);
            }
        }
    }

    public boolean withdrawMoney(int amount, boolean isLembaran) {
        List<Integer> moneyList = isLembaran ? lembaran : koin;

        if (moneyList.contains(amount)) { // Cek apakah pecahan tersedia
            moneyList.remove(Integer.valueOf(amount)); // Hapus pecahan
            return true;
        }
        return false; // Jika tidak ada pecahan yang sesuai, gagal menarik uang
    }

    public int getTotalMoney() {
        int total = 0;

        for (int uang : lembaran) {
            total += uang;
        }
        for (int uang : koin) {
            total += uang;
        }
        return total;
    }

    public void clearWallet() {
        this.cards.clear();
        this.lembaran.clear();
        this.koin.clear();
    }
}











//// NOMOR 1
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Wallet {
//
//    private String owner;
//    private List<String> cards;
//
//    public Wallet() {
//        this.owner = null;
//        this.cards = new ArrayList<>();
//    }
//
//    public void setOwner(String owner) {
//        if (this.owner == null) {
//            this.owner = owner;
//        }
//    }
//
//    public String getOwner() {
//        return owner;
//    }
//
//    public void addCard(String card) {
//        if (!cards.contains(card)) {
//            cards.add(card);
//        }
//    }
//
//    public List<String> getCards() {
//        return new ArrayList<>(cards);
//    }
//}