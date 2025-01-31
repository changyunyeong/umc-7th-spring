package umc7th.example.umc7th.service.StoreService;

import org.springframework.data.domain.Page;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    boolean existsAllByIds(List<Long> ids);

    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long StoreId, Integer page);
}
