package store.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.models.Customer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerRepositoryImplTest {
    private final CustomerRepository customerRepository
            = new CustomerRepositoryImpl();
    private Customer customer;
    private Customer secondCustomer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setFirstname("Godman");
        customer.setLastname("Buhari");
        customer.setEmail("emilokan2022@gmail.com");
        customer.setPassword("IloveNaija2022");

        secondCustomer = new Customer();
        secondCustomer.setFirstname("Jennifer");
        secondCustomer.setLastname("Emilokan");
        secondCustomer.setEmail("jenny123@gmail.com");
        secondCustomer.setPassword("jenny1234@");
    }

//

    @Test
    void saveTest() {
        //before save
        List<Customer> buyersList = customerRepository.findAll();
        assertEquals(0, customer.getId());
        assertEquals(0, buyersList.size());
        //save buyer
        Customer savedCustomer = customerRepository.save(customer);
        //buyer has id
        assertEquals(1, savedCustomer.getId());
        //there is one user in db
        buyersList= customerRepository.findAll();
        assertEquals(1, buyersList.size());

        //save second buyer
        Customer savedSecondCustomer =
                customerRepository.save(secondCustomer);
       //second buyer's id is 2
        assertEquals(2, savedSecondCustomer.getId());
        //there are two buyers in the db
        buyersList = customerRepository.findAll();
        assertEquals(2, buyersList.size());
    }

    @Test
    void findByIdTest() {
        Customer firstSavedCustomer = customerRepository.save(customer);
        Customer secondSavedCustomer = customerRepository.save(secondCustomer);

        Customer foundCustomer =
                customerRepository.findById(secondSavedCustomer.getId());
        assertEquals(foundCustomer, secondSavedCustomer);
    }

    @Test
    void findAllTest() {
        customerRepository.save(customer);
        var listOfAllBuyersInDb =
                customerRepository.findAll();
        assertEquals(1, listOfAllBuyersInDb.size());
        ;
    }

    @Test
    void deleteTest() {
        Customer savedCustomer = customerRepository.save(customer);
        customerRepository.delete(savedCustomer);
        assertFalse(customerRepository.findAll().contains(savedCustomer));

    }

    @Test
    void deleteAllTest(){
        customerRepository.save(customer);
        assertEquals(1, customerRepository.findAll().size());
        customerRepository.deleteAll();
        assertEquals(0, customerRepository.findAll().size());
    }
}