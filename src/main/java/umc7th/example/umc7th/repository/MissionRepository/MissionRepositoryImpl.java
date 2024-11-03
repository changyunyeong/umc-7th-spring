package umc7th.example.umc7th.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7th.example.umc7th.domain.QMission;
import umc7th.example.umc7th.domain.enums.MissionStatus;
import umc7th.example.umc7th.domain.mapping.MemberMission;
import umc7th.example.umc7th.domain.mapping.QMemberMission;;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> getMissions() {

        return jpaQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.mission, mission)
                .where(
                        memberMission.status.eq(MissionStatus.CHALLENGING)
                                .or(memberMission.status.eq(MissionStatus.COMPLETE))
                )
                .limit(10)
                .fetch();
    }
}
