package umc7th.example.umc7th.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
