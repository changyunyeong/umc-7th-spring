package umc7th.example.umc7th.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.example.umc7th.apiPayload.code.status.ErrorStatus;
import umc7th.example.umc7th.apiPayload.exception.handler.FoodCategoryHandler;
import umc7th.example.umc7th.converter.MemberConverter;
import umc7th.example.umc7th.converter.MemberPreferConverter;
import umc7th.example.umc7th.domain.FoodCategory;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.mapping.MemberPrefer;
import umc7th.example.umc7th.repository.FoodCategoryRepository;
import umc7th.example.umc7th.repository.MemberRepository;
import umc7th.example.umc7th.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joindMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
