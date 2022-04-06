package sn.acodewriter.stockmanagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoryByCode(String code);
}
