package store.data.dto;

import lombok.Data;

@Data
public class ProductPurchaseRequest {
    private int customerId;
    private int productId;
    private int quantity;

}
