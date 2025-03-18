import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    // menyimpan semua buku
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void storeData(List<Book> newBooks) {
        books.addAll(newBooks);
    }

    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}

















//import java.util.ArrayList;
//import java.util.List;
//
//public class LibraryService {
//    public List<Book> getAllBooks(){
//        // membaca sesuatu dari db / API
//        return new ArrayList<>();
//    }
//
//    public void storeData(List<Book> books) {
//        // store data ke DB / panggil API
//    }
//
//    public void deleteBook(String isbn) {
//        getAllBooks().removeIf(book -> book.isbn.equals(isbn));
//    }
//
//}
