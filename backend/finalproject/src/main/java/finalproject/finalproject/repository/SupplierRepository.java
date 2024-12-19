package finalproject.finalproject.repository;



import finalproject.finalproject.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    // Custom query to find a supplier by supplier name
    Supplier findBySuppliername(String suppliername);

    // Custom query to find a supplier by email
    Supplier findByEmail(String email);

    // You can add more custom queries as needed
}

