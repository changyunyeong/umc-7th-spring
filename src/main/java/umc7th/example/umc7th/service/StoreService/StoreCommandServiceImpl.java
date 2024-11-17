package umc7th.example.umc7th.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.example.umc7th.apiPayload.code.status.ErrorStatus;
import umc7th.example.umc7th.apiPayload.exception.handler.StoreHandler;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Region;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.repository.MemberRepository;
import umc7th.example.umc7th.repository.MissionRepository;
import umc7th.example.umc7th.repository.RegionRepository;
import umc7th.example.umc7th.repository.ReviewRepository;
import umc7th.example.umc7th.repository.StoreRepository.StoreRepository;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.StoreDTO request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElseGet(() -> {
                    Region newRegion = Region.builder().name(request.getRegion()).build();
                    return regionRepository.save(newRegion);
                });

        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Review createReview(StoreRequestDTO.ReviewDTO request, Long storeId, Long memberId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = StoreConverter.toReview(request);
        review.setStore(store);
        review.setMember(memberRepository.findById(memberId).get());

        return reviewRepository.save(review);
    }

    @Override
    @Transactional
    public Mission createMission(StoreRequestDTO.MissionDTO request, Long storeId) {
        Mission mission = StoreConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
}
