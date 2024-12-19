package finalproject.finalproject.repository;


import finalproject.finalproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // Custom query to find a category by its name
    Category findByCategoryname(String categoryname);

    // You can add more custom queries as needed
}


