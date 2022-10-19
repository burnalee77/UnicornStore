package store.service;

import store.data.dto.*;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registrationRequest);
    LoginResponse login(LoginRequest loginRequest);
    String orderProduct(ProductPurchaseRequest productPurchaseRequest);

}
