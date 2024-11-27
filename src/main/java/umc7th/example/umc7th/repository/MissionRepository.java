package umc7th.example.umc7th.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.domain.Mission;
import umc7th.example.umc7th.domain.Review;
import umc7th.example.umc7th.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
    Page<Mission> findAllByMember(Member member, PageRequest pageRequest);
}
