package com.example.demo.controllers;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

////Controller for testing backend functionality
//@RestController
//@Controller
//@RequestMapping("/api/v1")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/products")
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//      }
//}



//Controller for backend + frontend
@Controller
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products",productService.getAllProducts());
        return modelAndView;
    }
}
