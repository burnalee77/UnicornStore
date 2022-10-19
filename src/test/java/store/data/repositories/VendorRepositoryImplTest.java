package store.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.models.Vendor;
import store.exceptions.StoreException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendorRepositoryImplTest {

    private final VendorRepository vendorRepository
            = new VendorRepositoryImpl();


    private Vendor vendor;

    @BeforeEach
    void setUp(){
        vendor = Vendor.builder()
                .storeName("sabo-express")
                .storeAddresses(new HashSet<>())
                .build();
        vendor
                .getStoreAddresses()
                .add("312 Herbert Macaulay way, Sabo");
    }

    @Test
    void saveBuyerTest() {
        Vendor savedVendor =
                vendorRepository.save(vendor);
        assertNotNull(savedVendor);
        assertEquals(savedVendor.getId(), 1);
    }

    @Test
    void findByIdTest() {
        Vendor savedVendor =
                vendorRepository.save(vendor);
            Vendor foundVendor =
                    vendorRepository.findById(savedVendor.getId());
            System.out.println("found vendor:saved vendor\n"+foundVendor+" "+ savedVendor);
            assertEquals(savedVendor, foundVendor);
    }

    @Test
    void findAllBuyersTest() {
        List<Vendor> vendorsList = vendorRepository.findAll();
        vendorRepository.save(vendor);
        assertEquals(1, vendorsList.size());
    }

    @Test
    void deleteBuyerFromRepositoryTest() {
        Vendor savedVendor =
                vendorRepository.save(vendor);
        vendorRepository.delete(savedVendor);
        List<Vendor> vendorsList = vendorRepository.findAll();
        assertFalse(vendorsList
                .contains(savedVendor));
    }
}