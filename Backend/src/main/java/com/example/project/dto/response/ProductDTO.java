package com.example.project.dto.response;

import com.example.project.entity.Image;
import com.example.project.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDTO {
    private int id;

    private String title;

    private ImageDTO image;

    private String description;

    private BigDecimal price;

    @JsonProperty("discount_price")
    private BigDecimal discountPrice;

    @JsonProperty("quantity_available")
    private Integer quantityAvailable;

    private String unit;

    @JsonProperty("delivery_days")

    private Integer deliveryDays;

//    private CategoryProduct categories;

    public ProductDTO(Product product) {
        id = product.getProduct_id();
        title = product.getTitle();
        image = new ImageDTO(
                product.getProduct_image().getImage_id(),
                product.getProduct_image().getImage(),
                product.getProduct_image().getAlt()
        );
        description = product.getDescription();
        price = product.getPrice();
        discountPrice = product.getDiscountPrice();
        quantityAvailable = product.getQuantity_of_available();
        unit = product.getUnit();
        deliveryDays = product.getDeliveryDays();
    }
}
