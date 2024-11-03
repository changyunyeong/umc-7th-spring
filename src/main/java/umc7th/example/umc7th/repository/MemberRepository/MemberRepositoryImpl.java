package umc7th.example.umc7th.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.QMember;
import umc7th.example.umc7th.repository.ReviewRepository.ReviewRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<Member> getMember(String name) {
        return jpaQueryFactory
                .selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}
