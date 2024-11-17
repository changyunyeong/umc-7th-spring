package umc7th.example.umc7th.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.domain.common.BaseEntity;
import umc7th.example.umc7th.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private MissionStatus status;

    public void setMember(Member member) {
        if (this.member != null)
            member.getMemberMissionList().remove(this);
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission) {
        if (this.mission != null)
            mission.getMemberMissionList().remove(this);
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }
}
