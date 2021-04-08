package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

////Functionality for backend + RestController
//    public ResponseEntity<ShoppingCart> addProductToCart(long cart_id, long product_id)
//            throws ResourceNotFoundException {
//
//        ShoppingCart cart =
//                shoppingCartRepository
//                        .findById(cart_id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cart_id));
//        Product product = productRepository.findById(product_id).get();
//        cart.getProducts().add(product);
//        ShoppingCart updated = this.shoppingCartRepository.save(cart);
//        return new ResponseEntity<>(updated, HttpStatus.OK);
//    }
//
//    public ResponseEntity<List<Product>> getAllProducts(long cart_id)
//            throws ResourceNotFoundException {
//
//        ShoppingCart cart =
//                shoppingCartRepository
//                        .findById(cart_id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cart_id));
//        return ResponseEntity.ok().body(cart.getProducts());
//    }
//
//    public ResponseEntity<Double> getTotalPrice(long cart_id)
//            throws ResourceNotFoundException {
//
//        ShoppingCart cart =
//                shoppingCartRepository
//                        .findById(cart_id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cart_id));
//        return ResponseEntity.ok().body(cart.getTotalPrice());
//    }

    public ShoppingCart addProductToCart(long cartId, long productId)
            throws ResourceNotFoundException {

        ShoppingCart cart =
                shoppingCartRepository
                        .findById(cartId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cartId));
        Product product = productRepository.findById(productId).get();
        cart.getProducts().add(product);
        ShoppingCart updated = this.shoppingCartRepository.save(cart);
        return updated;
    }

    public List<Product> getAllProducts(long cartId)
            throws ResourceNotFoundException {

        ShoppingCart cart =
                shoppingCartRepository
                        .findById(cartId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cartId));
        return cart.getProducts();
    }

    public Double getTotalPrice(long cartId)
            throws ResourceNotFoundException {

        ShoppingCart cart =
                shoppingCartRepository
                        .findById(cartId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cart not found " + cartId));
        return cart.getTotalPrice();
    }
}

