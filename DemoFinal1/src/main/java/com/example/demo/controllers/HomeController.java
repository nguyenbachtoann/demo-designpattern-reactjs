package com.example.demo.controllers;

import com.example.demo.models.ProductModel;
import com.example.demo.services.serviceInterfaces.IProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private IProductService _productService;

    public HomeController(IProductService _productService){
        this._productService = _productService;
    }
    @CrossOrigin
    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    public List<ProductModel> getAllProduct(){
        List<ProductModel> listProduct = _productService.getAllProduct();
        return listProduct;
    }
}
