package umc7th.example.umc7th.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc7th.example.umc7th.apiPayload.ApiResponse;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.domain.mapping.MemberMission;
import umc7th.example.umc7th.service.StoreService.StoreCommandService;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.StoreDTO request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }

    @PostMapping("/{storeId}/review")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                            @PathVariable("storeId") Long storeId, @RequestParam("memberId") Long memberId) {
        Review review = storeCommandService.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                                              @PathVariable("storeId") Long storeId) {
        Mission mission = storeCommandService.createMission(request, storeId);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }

    @PostMapping("/challenging")
    public ApiResponse<StoreResponseDTO.CreateChallengingMissionResultDTO> createMemberMission(@RequestBody @Valid StoreRequestDTO.ChallengingMissionDTO request) {
        MemberMission memberMission = storeCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateMemberMissionResultDTO(memberMission));
    }
}
