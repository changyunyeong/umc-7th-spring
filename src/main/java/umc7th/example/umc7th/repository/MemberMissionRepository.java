package umc7th.example.umc7th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberAndMission(Member member, Mission mission);
}
