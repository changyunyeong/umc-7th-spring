package umc7th.example.umc7th.web.controller;

import com.mysql.cj.log.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc7th.example.umc7th.apiPayload.ApiResponse;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.domain.mapping.MemberMission;
import umc7th.example.umc7th.service.StoreService.StoreCommandService;
import umc7th.example.umc7th.service.StoreService.StoreQueryService;
import umc7th.example.umc7th.service.StoreService.StoreQueryServiceImpl;
import umc7th.example.umc7th.validation.annotation.ExistStores;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/stores")
public class  StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

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

    @PostMapping("/{storeId}/reviews")
    @Operation(summary = "리뷰 목록 조회", description = "해당 가게의 리뷰 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable("storeId") Long storeId, @RequestParam("page") Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        log.info("reviewList: " + reviewList);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

}
