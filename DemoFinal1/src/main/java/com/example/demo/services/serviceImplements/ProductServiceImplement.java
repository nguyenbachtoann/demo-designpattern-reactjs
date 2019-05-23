package com.example.demo.services.serviceImplements;


import com.example.demo.entities.ProductEntity;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.services.serviceInterfaces.IProductService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;

@Service
public class ProductServiceImplement implements IProductService {

    private IProductRepository _productRepository;
    private DozerBeanMapper mapper;

    public ProductServiceImplement(IProductRepository _productRepository, DozerBeanMapper mapper) {
        this._productRepository = _productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductModel> getAllProduct() {
        List<ProductModel> listProduct =
                _productRepository.findAll().stream()
                .map(productEntity -> mapper.map(productEntity, ProductModel.class)).collect(Collectors.toList());



        return listProduct;
    }

    @Override
    public ProductModel getProductById(int productId) {
        Optional<ProductEntity> product = _productRepository.findById(productId);
        ProductModel model = new ProductModel();
        model.setProductName(product.get().getProductName());
        return model;
    }

    @Override
    public void createProduct(ProductModel product) {
        ProductEntity productEntity = mapper.map(product, ProductEntity.class);
        _productRepository.save(productEntity);
    }


}
