package store.data.dto;

import lombok.Data;

@Data
public class CustomerRegistrationResponse {
    private int userId;
    private String message;
    private int statusCode;
}
