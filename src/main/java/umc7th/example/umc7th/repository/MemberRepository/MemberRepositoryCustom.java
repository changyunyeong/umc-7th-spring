package umc7th.example.umc7th.repository.MemberRepository;

import umc7th.example.umc7th.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> getMember(String name);
}
