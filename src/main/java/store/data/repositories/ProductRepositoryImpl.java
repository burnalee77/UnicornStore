package store.data.repositories;

import store.data.models.Product;
import store.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    private final List<Product> products = new ArrayList<>();

    @Override
    public Product save(Product product) {
        int newId = generateId();
        product.setId(newId);
        products.add(product);
        return product;
    }

    private int generateId(){
        int listSize = products.size();
        int newId = listSize+1;
        return newId;
    }

    @Override
    public Product findById(int id) {
        for (Product product:products) {
            if (product.getId()==id) return product;
        }
        throw new ProductNotFoundException(
                String.format("product with id %d doesn't exist", id)
        );
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}
