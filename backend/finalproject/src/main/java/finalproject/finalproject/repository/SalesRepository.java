package finalproject.finalproject.repository;

import finalproject.finalproject.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

    // Custom query to find sales by product
    List<Sales> findByProduct_Productname(String productname);

    // Custom query to find sales by date range
    List<Sales> findBySaledateBetween(Date startDate, Date endDate);

    // Custom query to find sales by total price greater than a specified value
    List<Sales> findByTotalpriceGreaterThan(double price);

    // You can add more custom queries as needed
}
