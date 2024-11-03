package umc7th.example.umc7th.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
