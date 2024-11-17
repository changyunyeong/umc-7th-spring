package umc7th.example.umc7th.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc7th.example.umc7th.validation.annotation.ExistStores;

import java.time.LocalDate;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class StoreDTO {
        @NotBlank
        String region;
        @NotBlank
        String name;
        @NotBlank
        String address;
    }

    @Getter
    public static class ReviewDTO {
        @NotBlank
        String title;
        @NotBlank
        String body;
        @NotNull
        Float score;
    }

    @Getter
    public static class MissionDTO {
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }

    @Getter
    public static class ChallengingMissionDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
