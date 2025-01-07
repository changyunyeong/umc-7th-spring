package umc7th.example.umc7th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Region;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByName(String name);
}
