package ru.netology;


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


    private Product prod1 = new Book(1, "Doom", 500, "Ivanov");
    private Product prod2 = new Book(2, "Java", 600, "Pupkin");
    private Product prod3 = new Book(3, "Piton", 700, "Vasa");
    private Product prod4 = new Smartphone(4, "Armor 3W", 1100, "UleFone");
    private Product prod5 = new Smartphone(5, "Galaxy", 800, "Samsung");
    private Product prod6 = new Smartphone(6, "Pupkin", 100, "Hp");



    @Test
    public void shouldFindAuthorName() {
        Product[] returned = new Product[]{prod1,prod2,prod3,prod4,prod5,prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Pupkin");
        Product[] expected = new Product[]{prod2,prod6};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindNameProducer() {
        Product[] returned = new Product[]{prod1,prod2,prod3,prod4,prod5,prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{prod5};

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