package umc7th.example.umc7th.service.ReviewService;

public interface ReviewQueryService {
    void createReview(Float score, String title, String body, Long memberId, Long storeId);
}
