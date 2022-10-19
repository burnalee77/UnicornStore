package store.data.dto;

import lombok.Data;


@Data
public class AddProductRequest {
    private String name;
    private double price;
    private String category;
}
