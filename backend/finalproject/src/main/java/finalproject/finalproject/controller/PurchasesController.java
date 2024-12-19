package finalproject.finalproject.controller;



import finalproject.finalproject.model.Purchases;
import finalproject.finalproject.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {

    @Autowired
    private PurchasesService purchasesService;

    // Get purchases by product name
    @GetMapping("/product/{productname}")
    public ResponseEntity<List<Purchases>> getPurchasesByProductName(@PathVariable String productname) {
        List<Purchases> purchases = purchasesService.findPurchasesByProductName(productname);
        if (purchases != null && !purchases.isEmpty()) {
            return new ResponseEntity<>(purchases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get purchases by supplier name
    @GetMapping("/supplier/{suppliername}")
    public ResponseEntity<List<Purchases>> getPurchasesBySupplierName(@PathVariable String suppliername) {
        List<Purchases> purchases = purchasesService.findPurchasesBySupplierName(suppliername);
        if (purchases != null && !purchases.isEmpty()) {
            return new ResponseEntity<>(purchases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get purchases by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Purchases>> getPurchasesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<Purchases> purchases = purchasesService.findPurchasesByDateRange(startDate, endDate);
        if (purchases != null && !purchases.isEmpty()) {
            return new ResponseEntity<>(purchases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create or update a purchase
    @PostMapping
    public ResponseEntity<Purchases> createOrUpdatePurchase(@RequestBody Purchases purchases) {
        Purchases savedPurchase = purchasesService.savePurchase(purchases);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    // Get purchase by ID
    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchases> getPurchaseById(@PathVariable int purchaseId) {
        Optional<Purchases> purchase = purchasesService.findPurchaseById(purchaseId);
        if (purchase.isPresent()) {
            return new ResponseEntity<>(purchase.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete purchase by ID
    @DeleteMapping("/{purchaseId}")
    public ResponseEntity<Void> deletePurchase(@PathVariable int purchaseId) {
        Optional<Purchases> purchase = purchasesService.findPurchaseById(purchaseId);
        if (purchase.isPresent()) {
            purchasesService.deletePurchaseById(purchaseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
