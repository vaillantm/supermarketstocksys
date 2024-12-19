package finalproject.finalproject.service;




import finalproject.finalproject.model.Supplier;
import finalproject.finalproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Find supplier by name
    public Supplier findBySuppliername(String suppliername) {
        return supplierRepository.findBySuppliername(suppliername);
    }

    // Find supplier by email
    public Supplier findByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    // Get all suppliers
    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Save or update supplier
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Find supplier by ID
    public Optional<Supplier> findById(int supplierId) {
        return supplierRepository.findById(supplierId);
    }

    // Delete supplier by ID
    public void deleteSupplierById(int supplierId) {
        supplierRepository.deleteById(supplierId);
    }
}
