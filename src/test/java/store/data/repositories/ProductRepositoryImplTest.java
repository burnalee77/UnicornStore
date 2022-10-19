package store.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.models.Category;
import store.data.models.Product;
import store.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryImplTest {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    private Product product;

    @BeforeEach
    void setUp(){
        product = new Product();
        product.setName("milk");
        product.setCategory(Category.BEVERAGES);
        product.setPrice(BigDecimal.valueOf(50));
    }

    @Test
    void saveProductTest() {
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
    }

    @Test
    void findProductByIdTest() {
        Product savedProduct = productRepository.save(product);
        Product foundProduct = productRepository.findById(savedProduct.getId());
        assertNotNull(foundProduct);
        assertEquals(savedProduct.getId(), foundProduct.getId());
    }

    @Test
    void testThatExceptionIsThrownWhenInvalidIdPassedToFindById(){
        productRepository.save(product);
        assertThrows(ProductNotFoundException.class,
                ()->productRepository.findById(900));

    }

    @Test
    void findAllProductsTest() {
        List<Product> products = productRepository.findAll();
        assertEquals(0, products.size());
        productRepository.save(product);
        List<Product> newProductList = productRepository.findAll();
        assertEquals(1, newProductList.size());
    }

    @Test
    void deleteProductTest() {
        Product savedProduct=productRepository.save(product);
        productRepository.delete(savedProduct);
        assertThrows(ProductNotFoundException.class, ()->productRepository
                .findById(savedProduct.getId()));

    }
}