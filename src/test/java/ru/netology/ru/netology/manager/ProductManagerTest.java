package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Ауто", 1000, "Уолтер Айзексон");
    private Book book2 = new Book(2, "Алхимик", 1000, "Паоло Коэльо");
    private Book book3 = new Book(3, "Iphone 11", 1000, "Steven Jobs");
    private Smartphone smartphone1 = new Smartphone(4, "Nokia 3310", 1000, "Nokia");
    private Smartphone smartphone2 = new Smartphone(5, "Iphone 11", 100000, "Steven Jobs");
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
    void shouldFindNameBook() {


        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Алхимик");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAuthorBook() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Уолтер Айзексон");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindManufactureSmartphone() {

        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTitleSmartphone() {

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("Nokia 3310");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNull() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplaySeveralSuitableProducts1() {
        Product[] expected = new Product[]{book3, smartphone2};
        Product[] actual = manager.searchBy("Iphone 11");
        assertArrayEquals(expected, actual);
    }

}

//    public void saveProduct(){
//        repository.save(book1);
//        repository.save(book2);
//        repository.save(book3);
//        repository.save(smartphone1);
//        repository.save(smartphone2);
//        repository.save(smartphone3);
//    }

//        @BeforeEach
//    public void setUp() {
//        manager.add(book1);
//        manager.add(book2);
//        manager.add(book3);
//        manager.add(smartphone1);
//        manager.add(smartphone2);
//        manager.add(smartphone3);
//    }
//
