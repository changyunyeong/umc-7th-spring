package umc7th.example.umc7th.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final EntityManager entityManager;

    @Override
    public void saveReview(Float score, String title, String body, Long memberId, Long storeId) {

        Member member = entityManager.getReference(Member.class, memberId);
        Store store = entityManager.getReference(Store.class, storeId);

        Review review = Review.builder()
                .score(score)
                .title(title)
                .body(body)
                .member(member)
                .store(store)
                .build();

        entityManager.persist(review);
    }
}
