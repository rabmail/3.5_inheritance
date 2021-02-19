package ru.netology.manager;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager manager;


    private Product prod1 = new Book(1, "Hutor", 100, "Gogol");
    private Product prod2 = new Book(2, "Super", 200, "Vova");
    private Product prod3 = new Book(3, "Super", 300, "Vova");
    private Product prod4 = new Smartphone(4, "Iphone", 1000, "Apple");
    private Product prod5 = new Smartphone(5, "Galaxy", 900, "Samsung");
    private Product prod6 = new Smartphone(6, "Vova", 500, "Samsung");



    @Test
    public void shouldFindAuthorName() {
        Product[] returned = new Product[]{prod1,prod2,prod3,prod4,prod5,prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Vova");
        Product[] expected = new Product[]{prod2,prod3,prod6};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindNameProducer() {
        Product[] returned = new Product[]{prod1,prod2,prod3,prod4,prod5,prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{prod5,prod6};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldNotFindAnything() {
        Product[] returned = new Product[]{prod1,prod2,prod3,prod4,prod5,prod6};;
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("NOTHING");
        Product[] expected = new Product[]{};

        assertArrayEquals(actual, expected);

    }

}