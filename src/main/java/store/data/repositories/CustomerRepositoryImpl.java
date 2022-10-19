package store.data.repositories;

import store.data.models.Customer;
import store.exceptions.StoreException;

import java.util.ArrayList;
import java.util.List;


public class CustomerRepositoryImpl implements CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        int newId = generateId();
        customer.setId(newId);
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if(customer.getId()==id) return customer;
        }
        throw new StoreException("user not found");
    }

    @Override
    public Customer findByEmail(String email) {
        for (Customer customer:customers) {
            if (customer.getEmail().equals(email)) return customer;
        }
        throw new StoreException("customer not found");
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void deleteAll() {
       customers.clear();
    }

    private int generateId(){
        int numberOfBuyersInDb = customers.size();
        return numberOfBuyersInDb+1;
    }
}
