public class Book {
    String title;
    String isbn;
    String author;

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
}
