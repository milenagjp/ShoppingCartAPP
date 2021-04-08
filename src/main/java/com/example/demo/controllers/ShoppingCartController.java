package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.ProductCart;
import com.example.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Controller for testing backend functionality
//@RestController
//@RequestMapping("/api/v1")
//public class ShoppingCartController {
//
//    @Autowired
//    private ShoppingCartService shoppingCartService;
//
//    //Add product to shopping cart
//    @PostMapping(value = "/addProduct", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<List<Product>> addProductToCart(@RequestBody ProductCart productCart) {
//        shoppingCartService.addProductToCart(productCart.getCart_id(), productCart.getProduct_id());
//        return shoppingCartService.getAllProducts(productCart.getCart_id());
//    }
//
//    //Get list of all products in the shopping cart
//    @GetMapping("/cart/{id}")
//    public ResponseEntity<List<Product>> getAllProducts(@PathVariable(value = "id") Long cart_id)
//            throws ResourceNotFoundException {
//        return shoppingCartService.getAllProducts(cart_id);
//    }
//
//    //Get the total price of products in the shopping cart
//    @GetMapping("/total/{id}")
//    public ResponseEntity<Double> getTotalPrice(@PathVariable(value = "id") Long cart_id)
//            throws ResourceNotFoundException {
//        return shoppingCartService.getTotalPrice(cart_id);
//    }
//}



/*Controller for backend + frontend*/
@Controller
@RequestMapping("/api/v1")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //Add product to shopping cart
    @PostMapping(value = "/addProduct", consumes = "application/json", produces = "application/json")
    public ModelAndView addProductToCart(@RequestBody ProductCart productCart) {

        shoppingCartService.addProductToCart(productCart.getCartId(), productCart.getProductId());
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", shoppingCartService.getAllProducts(productCart.getCartId()));
        return modelAndView;
    }

    //Get list of all products in the shopping cart
    @GetMapping("/cart/{id}")
    public ModelAndView getAllProducts(@PathVariable(value = "id") Long cart_id)
            throws ResourceNotFoundException {

        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", shoppingCartService.getAllProducts(cart_id));
        return modelAndView;
    }

    //Get the total price of products in the shopping cart
    @GetMapping("/total/{id}")
    public ModelAndView getTotalPrice(@PathVariable(value = "id") Long cart_id)
            throws ResourceNotFoundException {

        ModelAndView modelAndView = new ModelAndView("total");
        modelAndView.addObject("total", shoppingCartService.getTotalPrice(cart_id));
        return modelAndView;

    }

}

