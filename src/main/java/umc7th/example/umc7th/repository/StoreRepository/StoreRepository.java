package umc7th.example.umc7th.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.example.umc7th.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
