package student_managment_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student_managment_project.models.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p")
    List<ProductEntity> getAllProducts();

    @Query("SELECT p FROM ProductEntity p WHERE p.id = :id")
    Optional<ProductEntity> getProduct(
            @Param("id") Long id
    );

}
