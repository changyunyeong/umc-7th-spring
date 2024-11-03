package umc7th.example.umc7th.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.example.umc7th.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public void createReview(Float score, String title, String body, Long memberId, Long storeId) {
        reviewRepository.saveReview(score, title, body, memberId, storeId);
    }
}
