import java.util.List;

public class LibraryHelper {
    private LibraryService service;

    public LibraryHelper(LibraryService service) {
        this.service = service;
    }

    public int countBooks() {
        List<Book> retrievedBooks = this.service.getAllBooks();
        return retrievedBooks.size();
    }

    public void saveBook(List<Book> books) {
        if (books.size() > 0) {
            this.service.storeData(books);
        }
    }

    public void deleteBook(String isbn) {
        service.deleteBook(isbn);
    }
}


