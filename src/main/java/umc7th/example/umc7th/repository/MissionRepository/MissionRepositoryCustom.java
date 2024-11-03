package umc7th.example.umc7th.repository.MissionRepository;

import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MemberMission> getMissions();
}
