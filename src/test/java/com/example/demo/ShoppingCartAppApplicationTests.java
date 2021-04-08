package com.example.demo;

import com.example.demo.controllers.ShoppingCartController;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShoppingCartAppApplicationTests {

    @TestConfiguration
    public class ResourceNotFoundExceptionMock extends RuntimeException {
        public ResourceNotFoundExceptionMock() {
            super();
        }

        public ResourceNotFoundExceptionMock(String message) {
            super(message);
        }
    }

    @TestConfiguration
    static class ShoppingCartServiceMock {
        @MockBean
        private ShoppingCartRepository shoppingCartRepository;

        @Bean
        public ShoppingCartServiceMock shoppingCartServiceMock() {
            return new ShoppingCartServiceMock();
        }
    }

    @TestConfiguration
    static class ProductServiceMock {

        @MockBean
        ProductRepository productRepository;

        @Bean
        public ProductServiceMock productServiceMock() {
            return new ProductServiceMock();
        }

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }
    }

    @Autowired
    private ShoppingCartServiceMock shoppingCartServiceMock;
    @Autowired
    private ProductServiceMock productServiceMock;

    @MockBean
    ShoppingCart shoppingCart;

    @MockBean
    Product product;

    @Before
    public void setUp() {
        long productId = 1;
        long cartId = 2;

        shoppingCart.setCartId(cartId);

        Mockito.when(shoppingCartServiceMock.shoppingCartRepository
                .findById(shoppingCart.getCartId())
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + shoppingCart.getCartId())));

        product.setProductId(productId);

        Mockito.when(productServiceMock.productRepository.findById(product.getProductId()).get());

    }

    @Test
    public void testException() {
        ResourceNotFoundExceptionMock ex = Assert.assertThrows(ResourceNotFoundExceptionMock.class, () -> shoppingCartServiceMock.shoppingCartRepository
                .findById(shoppingCart.getCartId()).orElseThrow(()
                        -> new ResourceNotFoundExceptionMock("Cart not found " + shoppingCart.getCartId())));

        Assert.assertTrue(ex.getMessage().equals("Cart not found 0"));
    }

    @Test
    public void testGetAllProductsFromProduct() {
        Assert.assertNotNull(productServiceMock.getAllProducts());
    }


}

