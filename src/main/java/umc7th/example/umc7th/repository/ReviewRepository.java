package umc7th.example.umc7th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
