package umc7th.example.umc7th.service.MemberService;

import umc7th.example.umc7th.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
}
