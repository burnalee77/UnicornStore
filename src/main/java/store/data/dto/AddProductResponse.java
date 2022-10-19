package store.data.dto;

import lombok.Data;

@Data
public class AddProductResponse {
    private String message;
    private int statusCode;
    private int productId;
}
