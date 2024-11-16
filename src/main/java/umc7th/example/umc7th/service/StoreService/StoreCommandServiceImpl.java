package umc7th.example.umc7th.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Region;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.repository.RegionRepository;
import umc7th.example.umc7th.repository.StoreRepository.StoreRepository;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.StoreDTO request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElseGet(() -> {
                    Region newRegion = Region.builder().name(request.getRegion()).build();
                    return regionRepository.save(newRegion);
                });

        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }
}
