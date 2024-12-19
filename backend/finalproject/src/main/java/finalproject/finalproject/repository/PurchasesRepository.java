package finalproject.finalproject.repository;

import finalproject.finalproject.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Integer> {

    // Custom query to find purchases by product
    List<Purchases> findByProduct_Productname(String productname);

    // Custom query to find purchases by supplier
    List<Purchases> findBySupplier_Suppliername(String suppliername);

    // Custom query to find purchases by date
    List<Purchases> findByPurchasedateBetween(Date startDate, Date endDate);

    // You can add more custom queries as needed
}
