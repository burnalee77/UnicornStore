package store.data.repositories;

import store.data.models.Vendor;
import store.exceptions.VendorNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class VendorRepositoryImpl implements VendorRepository{
    private final List<Vendor> vendorDb = new ArrayList<>();
    @Override
    public Vendor save(Vendor vendor) {
        int newId = generateId();
        vendor.setId(newId);
        vendorDb.add(vendor);
        return vendor;
    }

    @Override
    public Vendor findById(int id) {
        for (Vendor vendor:vendorDb) {
            if (vendor.getId()==id) return vendor;
        }
        throw new
                VendorNotFoundException("vendor with id " +id +" not found");
    }

    @Override
    public List<Vendor> findAll() {
        return vendorDb;
    }

    @Override
    public void delete(Vendor vendor) {
        vendorDb.remove(vendor);
    }

    private int generateId(){
        int numberOfVendorsInDb = vendorDb.size();
        return numberOfVendorsInDb+1;
    }
}
