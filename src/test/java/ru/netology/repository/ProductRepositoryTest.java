package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Ауто", 1000, "Уолтер Айзексон");
    private Book book2 = new Book(2, "Алхимик", 1000, "Паоло Коэльо");
    private Book book3 = new Book(3, "Iphone 11", 1000, "Steven Jobs");
    private Smartphone smartphone1 = new Smartphone(4, "Nokia 3310", 1000, "Nokia");
    private Smartphone smartphone2 = new Smartphone(5, "Iphone 11", 100000, "Apple");
    private Smartphone smartphone3 = new Smartphone(6, "Huawei 15", 10000, "Huawei");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        repository.save(new Smartphone(7, "BQ", 2500, "MReader"));
        int expected = 7;
        Product[] actual = repository.findAll();
    }

    @Test
    void shouldFindAll1() {
        int expected = 6;
        Product[] actual = repository.findAll();
        assertEquals(expected, actual.length);
    }

    @Test
    void shouldRemoveById() {
        Product[] expected = new Product[]{book2, book3, smartphone1, smartphone2, smartphone3};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
//