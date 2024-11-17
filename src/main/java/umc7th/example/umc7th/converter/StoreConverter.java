package umc7th.example.umc7th.converter;

import umc7th.example.umc7th.domain.*;
import umc7th.example.umc7th.domain.enums.MissionStatus;
import umc7th.example.umc7th.domain.mapping.MemberMission;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreDTO request, Region region) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.ReviewDTO request) {
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request) {
        return Mission.builder()
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .build();
    }

    public static StoreResponseDTO.CreateChallengingMissionResultDTO toCreateMemberMissionResultDTO(MemberMission memberMission) {
        return StoreResponseDTO.CreateChallengingMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(StoreRequestDTO.ChallengingMissionDTO request) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
