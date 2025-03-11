import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    @Mock
    public LibraryService service;

    @InjectMocks
    public LibraryHelper helper;

    @Test
    public void testCountBooks() {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "123", "Rila"));
        books.add(new Book("OOP", "456", "Nana"));
        when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(2, helper.countBooks());
    }

    @Test
    public void testSaveEmptyBooks() {
        List<Book> books = new ArrayList<>();
        helper.saveBook(books);

        verify(service, never()).storeData(any());
    }

    @Test
    public void testSaveNotEmptyBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "123", "Rila"));
        books.add(new Book("OOP", "456", "Nana"));
        helper.saveBook(books);

        verify(service).storeData(books);
    }

    @Test
    public void testDeleteBookExists() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "123", "Rila"));
        books.add(new Book("OOP", "456", "Nana"));
        when(service.getAllBooks()).thenReturn(books);

        doAnswer(invocation -> {
            String isbn = invocation.getArgument(0);
            books.removeIf(book -> book.getIsbn().equals(isbn));
            return null;
        }).when(service).deleteBook(anyString());

        Assertions.assertTrue(service.getAllBooks().stream().anyMatch(book -> book.getIsbn().equals("123")));
        helper.deleteBook("123");
        Assertions.assertFalse(service.getAllBooks().stream().anyMatch(book -> book.getIsbn().equals("123")));
    }

    @Test
    public void testDeleteBookThrowsException() {
        doThrow(new RuntimeException("Book not found")).when(service).deleteBook("999");

        Assertions.assertThrows(RuntimeException.class, () -> helper.deleteBook("999"));
    }

    @Test
    public void testDeleteBookUsingSpy() {
        LibraryService realService = new LibraryService();
        LibraryService spyService = Mockito.spy(realService);
        LibraryHelper helperWithSpy = new LibraryHelper(spyService);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "123", "Rila"));
        spyService.storeData(books);

        Assertions.assertEquals(1, spyService.getAllBooks().size());
        helperWithSpy.deleteBook("123");
        Assertions.assertEquals(0, spyService.getAllBooks().size());
    }
}






























//
//    @Test
//    public void testDeleteBookExists() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "Rila"));
//        when(service.getAllBooks()).thenReturn(books);
//        helper.deleteBook("123");
//
//        verify(service).deleteBook("123");
//    }
//
//    @Test
//    public void testDeleteBookNotExists() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "Rila"));
//        when(service.getAllBooks()).thenReturn(books);
//        helper.deleteBook("999");
//
//        verify(service, never()).deleteBook("999");
//    }
//
//
//    @Test
//    public void testDeleteBookWithoutException() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "John Doe"));
//        Mockito.when(service.getAllBooks()).thenReturn(books);
//        Mockito.doNothing().when(service).deleteBook("123");
//
//        Assertions.assertDoesNotThrow(() -> helper.deleteBook("123"));
//
//        verify(service, times(1)).deleteBook("123");
//    }
//
//
//    @Test
//    public void testSpyOnLibraryService() {
//        LibraryService realService = new LibraryService();
//        LibraryService spyService = Mockito.spy(realService);
//
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "John Doe"));
//        spyService.storeData(books);
//
//        Assertions.assertEquals(1, spyService.getAllBooks().size());
//
//        verify(spyService).storeData(books);
//    }
//
//    @Test
//    public void testMethodCallOrder() {
//        InOrder inOrder = Mockito.inOrder(service);
//
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "John Doe"));
//
//        Mockito.when(service.getAllBooks()).thenReturn(books);
//
//        helper.saveBook(books);
//        helper.deleteBook("123");
//
//        inOrder.verify(service).storeData(books);
//        inOrder.verify(service).deleteBook("123");
//    }
//}








//
//
//    @Test
//    public void testStoreDataWithAnswer() {
//        // Arrange: Simulasikan bahwa storeData akan mencetak daftar buku yang diterima
//        Mockito.doAnswer(invocation -> {
//            List<Book> booksReceived = invocation.getArgument(0);
//            System.out.println("Books stored: " + booksReceived.size());
//            return null;
//        }).when(service).storeData(Mockito.anyList());
//
//        // Act: Simpan beberapa buku
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Java Basics", "123", "John Doe"));
//        books.add(new Book("Advanced Java", "456", "Jane Smith"));
//
//        helper.saveBook(books);
//
//        // Assert: Pastikan storeData dipanggil dengan parameter yang benar
//        verify(service).storeData(books);
//    }
