package umc7th.example.umc7th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
