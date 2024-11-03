package umc7th.example.umc7th.service.MissionService;

import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.mapping.MemberMission;

import java.util.List;

public interface MissionQueryService {
    List<MemberMission> getMissionLists();
}
