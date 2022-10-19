package store.data.repositories;

import store.data.models.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(int id);

    Customer findByEmail(String email);
    List<Customer> findAll();
    void delete(Customer customer);
    void deleteAll();
}
