package com.example.demo.controllers;

import com.example.demo.models.ProductModel;
import com.example.demo.services.serviceInterfaces.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    private IProductService _productService;
    private List<ProductModel> listProduct = null;

    public HomeController(IProductService _productService){
        this._productService = _productService;
    }
    @CrossOrigin
    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    public List<ProductModel> getAllProduct(){
        listProduct = _productService.getAllProduct();
        return listProduct;
    }


    @CrossOrigin
    @RequestMapping(value = "/getProductById", method = RequestMethod.GET)
    public ProductModel getProductById(@RequestParam String productId){
        ProductModel model = _productService.getProductById(Integer.parseInt(productId));

        return model;
    }
//    @CrossOrigin
//    @RequestMapping
//    public List<ProductModel> getProductByListId(){
//        listProduct = new ArrayList<>();
//
//        return listProduct;
//    }
    @CrossOrigin
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductModel product){
        _productService.createProduct(product);
    }
//
//    @CrossOrigin
//    @RequestMapping
//    public boolean deleteProduct(){
//
//
//        return false;
//    }


}
