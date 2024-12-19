package finalproject.finalproject.controller;



import finalproject.finalproject.model.Sales;
import finalproject.finalproject.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    // Get sales by product name
    @GetMapping("/product/{productname}")
    public ResponseEntity<List<Sales>> getSalesByProductName(@PathVariable String productname) {
        List<Sales> sales = salesService.findSalesByProductName(productname);
        if (sales != null && !sales.isEmpty()) {
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get sales by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Sales>> getSalesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<Sales> sales = salesService.findSalesByDateRange(startDate, endDate);
        if (sales != null && !sales.isEmpty()) {
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get sales by total price greater than a specified value
    @GetMapping("/total-price/{price}")
    public ResponseEntity<List<Sales>> getSalesByTotalPriceGreaterThan(@PathVariable double price) {
        List<Sales> sales = salesService.findSalesByTotalPriceGreaterThan(price);
        if (sales != null && !sales.isEmpty()) {
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create or update a sale
    @PostMapping
    public ResponseEntity<Sales> createOrUpdateSale(@RequestBody Sales sales) {
        Sales savedSale = salesService.saveSale(sales);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    // Get sale by ID
    @GetMapping("/{saleId}")
    public ResponseEntity<Sales> getSaleById(@PathVariable int saleId) {
        Optional<Sales> sale = salesService.findSaleById(saleId);
        if (sale.isPresent()) {
            return new ResponseEntity<>(sale.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete sale by ID
    @DeleteMapping("/{saleId}")
    public ResponseEntity<Void> deleteSale(@PathVariable int saleId) {
        Optional<Sales> sale = salesService.findSaleById(saleId);
        if (sale.isPresent()) {
            salesService.deleteSaleById(saleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
