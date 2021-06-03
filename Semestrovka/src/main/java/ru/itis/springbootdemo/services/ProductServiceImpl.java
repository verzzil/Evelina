package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.ProductDto;
import ru.itis.springbootdemo.models.Product;
import ru.itis.springbootdemo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductBySizeAndPrice(String size, int price) {
        List<Product> product = productRepository.findAllByPriceBeforeAndSize(price, size);
        return ProductDto.from(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return ProductDto.from(productRepository.findAll());
    }

    @Override
    public List<ProductDto> getProductsLikeName(String q) {
        return ProductDto.from(productRepository.findAllByNameLike("%" + q + "%"));
    }
}
