package finalproject.finalproject.service;


import finalproject.finalproject.model.Sales;
import finalproject.finalproject.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    // Find sales by product name
    public List<Sales> findSalesByProductName(String productName) {
        return salesRepository.findByProduct_Productname(productName);
    }

    // Find sales by date range
    public List<Sales> findSalesByDateRange(Date startDate, Date endDate) {
        return salesRepository.findBySaledateBetween(startDate, endDate);
    }

    // Find sales by total price greater than a specified value
    public List<Sales> findSalesByTotalPriceGreaterThan(double price) {
        return salesRepository.findByTotalpriceGreaterThan(price);
    }

    // Save a new sale or update an existing sale
    public Sales saveSale(Sales sales) {
        return salesRepository.save(sales);
    }

    // Get sale by ID
    public Optional<Sales> findSaleById(int saleId) {
        return salesRepository.findById(saleId);
    }

    // Delete sale by ID
    public void deleteSaleById(int saleId) {
        salesRepository.deleteById(saleId);
    }
}

