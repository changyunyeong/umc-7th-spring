package umc7th.example.umc7th.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.mapping.MemberMission;
import umc7th.example.umc7th.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<MemberMission> getMissionLists() {

        List<MemberMission> missionList = missionRepository.getMissions();

        missionList.forEach(mission -> System.out.println("Mission: " + mission));

        return missionList;
    }
}
