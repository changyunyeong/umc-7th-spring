package umc7th.example.umc7th.repository.ReviewRepository;

import java.time.LocalDate;

public interface ReviewRepositoryCustom {

    void saveReview(Float score, String title, String body, Long memberId, Long storeId);
}
