package umc7th.example.umc7th.service.StoreService;

import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store createStore(StoreRequestDTO.StoreDTO request);

    Review createReview(StoreRequestDTO.ReviewDTO request, Long storeId, Long memberId);
}
