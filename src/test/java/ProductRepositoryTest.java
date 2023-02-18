import org.example.Book;
import org.example.NotFoundException;
import org.example.Product;
import org.example.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void testSaveProduct() {
        ProductRepository repository = new ProductRepository();
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptyProductRepository() {
        ProductRepository repository = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repository.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductWhenIdExisted() {
        ProductRepository repository = new ProductRepository();
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.removeById(1);

        Product[] expected = {book2, book3};
        Product[] actual = repository.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductWhenIdNotExisted() {
        ProductRepository repository = new ProductRepository();
        Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
        Book book2 = new Book(2, "Война и мир", 1700, "Лев Толстой");
        Book book3 = new Book(3, "Тихий Дон", 900, "Михаил Шолохов");

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.removeById(1);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(4)
                );

    }

}
