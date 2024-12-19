package finalproject.finalproject.service;



import finalproject.finalproject.model.Purchases;
import finalproject.finalproject.repository.PurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchasesService {

    @Autowired
    private PurchasesRepository purchasesRepository;

    // Find purchases by product name
    public List<Purchases> findPurchasesByProductName(String productName) {
        return purchasesRepository.findByProduct_Productname(productName);
    }

    // Find purchases by supplier name
    public List<Purchases> findPurchasesBySupplierName(String supplierName) {
        return purchasesRepository.findBySupplier_Suppliername(supplierName);
    }

    // Find purchases by date range
    public List<Purchases> findPurchasesByDateRange(Date startDate, Date endDate) {
        return purchasesRepository.findByPurchasedateBetween(startDate, endDate);
    }

    // Save a new purchase or update an existing purchase
    public Purchases savePurchase(Purchases purchase) {
        return purchasesRepository.save(purchase);
    }

    // Get purchase by ID
    public Optional<Purchases> findPurchaseById(int purchaseId) {
        return purchasesRepository.findById(purchaseId);
    }

    // Delete purchase by ID
    public void deletePurchaseById(int purchaseId) {
        purchasesRepository.deleteById(purchaseId);
    }
}
