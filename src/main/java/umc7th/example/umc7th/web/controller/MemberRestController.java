package umc7th.example.umc7th.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc7th.example.umc7th.apiPayload.ApiResponse;
import umc7th.example.umc7th.converter.MemberConverter;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.service.MemberService.MemberCommandService;
import umc7th.example.umc7th.service.MemberService.MemberQueryService;
import umc7th.example.umc7th.web.dto.MemberRequestDTO;
import umc7th.example.umc7th.web.dto.MemberResponseDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joindMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/reviews")
    @Operation(summary = "리뷰 목록 조회", description = "해당 유저의 리뷰 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreviewListDTO> getMemberReviewList(@PathVariable("memberId") Long memberId, @RequestParam("page") Integer page) {
        Page<Review> reviewList = memberQueryService.getMemberReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.reviewPreviewListDTO(reviewList));
    }
}
