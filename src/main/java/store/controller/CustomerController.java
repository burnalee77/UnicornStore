package store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.data.dto.CustomerRegistrationRequest;
import store.data.dto.CustomerRegistrationResponse;
import store.service.CustomerService;
import store.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    @PostMapping("/register")
    public CustomerRegistrationResponse register(@RequestBody CustomerRegistrationRequest
                                                             customerRegistrationRequest){
        CustomerRegistrationResponse response =
                customerService.register(customerRegistrationRequest);
        return response;
    }
}
