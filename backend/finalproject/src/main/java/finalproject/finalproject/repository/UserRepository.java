package finalproject.finalproject.repository;



import finalproject.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query to find a user by email
    User findByEmail(String email);

    // Custom query to find a user by email and password
    User findByEmailAndPassword(String email, String password);

    // You can add more custom queries as needed
}


