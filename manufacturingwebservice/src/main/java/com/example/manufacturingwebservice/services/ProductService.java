package com.example.manufacturingwebservice.services;

import com.example.manufacturingwebservice.dto.ProductDTO;
import com.example.manufacturingwebservice.entities.Product;
import com.example.manufacturingwebservice.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<Product> getProductById(int productId) {
        return productRepository.findByProductId(productId);
    }

    public ProductDTO create(ProductDTO productDTO) {
        
        try {
            Product product = modelMapper.map(productDTO, Product.class);
            Product savedProduct = productRepository.save(product);
            return convertToDto(savedProduct);
        } catch (Exception e) {
            System.out.println("Objeto Nulo");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(int productId) {
        productRepository.deleteById(productId);
    }

    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
