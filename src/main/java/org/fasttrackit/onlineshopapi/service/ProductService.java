package org.fasttrackit.onlineshopapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineshopapi.domain.Product;
import org.fasttrackit.onlineshopapi.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshopapi.repository.ProductRepository;
import org.fasttrackit.onlineshopapi.transfer.CreateProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;


    @Autowired
    public ProductService(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    public Product createProduct(CreateProductRequest request){

        LOGGER.info("Creating product {} ", request);

        Product product = objectMapper.convertValue(request, Product.class);

//        Product product = new Product();
//        product.setName(request.getName());
//        product.setPrice(request.getPrice());
//        product.setQuantity(request.getQuantity());
//        product.setImagePath(request.getImagePath());

        return productRepository.save(product);

    }

    public Product getProduct(long id) throws ResourceNotFoundException{
        LOGGER.info ("Retriving product {} ", id);
        //using Optional with orElseThrow
        return productRepository.findById(id)
                //usic Lambda expressions
                .orElseThrow(()->new ResourceNotFoundException(
                        "Product " + id + " does not exist"));
    }
}
