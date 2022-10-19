package store.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
public class Customer extends User{
    private int id;
    private String firstname;
    private String lastname;
    private Set<String> deliveryAddresses=new TreeSet<>();
    private List<Product> orders = new ArrayList<>();
}
