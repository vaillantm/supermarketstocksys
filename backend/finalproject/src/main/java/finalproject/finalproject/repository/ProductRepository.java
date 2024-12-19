package finalproject.finalproject.repository;

import finalproject.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Custom query to find products by category
    List<Product> findByCategory_Categoryname(String categoryname);

    // Custom query to find products by stock status
    List<Product> findByStockstatus(String stockstatus);

    // Custom query to find products by product name
    List<Product> findByProductname(String productname);

    // You can add more custom queries as needed
}
