package org.fasttrackit.onlineshopapi.transfer;

import org.fasttrackit.onlineshopapi.domain.Product;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateProductRequest {

    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private int quantity;
    @NotNull
    private double price;
    private String imagePath;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public Product updateProduyct(long id, UpdateProductRequest){
        LOGGER.info("Updating product {} with {}", id, request);
        Product product = getProduct(id);

        BeanUtils.copyProperties(request, product);
        return productRepository.save(product);
    }

    public void deleteProduct(long id){
        LOGGER.info("Deleting product {}", id);
        product.Repository.deteleById(id);
        LOGGER.info("Detleting product {}", id);

    }
}
