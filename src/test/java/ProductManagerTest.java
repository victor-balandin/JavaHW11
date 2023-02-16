import org.example.Book;
import org.example.Product;
import org.example.ProductManager;
import org.example.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void testAdd() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Война");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchTwoProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy(" и ");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNullProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("война");


        Assertions.assertArrayEquals(expected, actual);
    }

}





