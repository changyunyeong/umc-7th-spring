package umc7th.example.umc7th.converter;

import umc7th.example.umc7th.domain.Region;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreDTO request, Region region) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .build();
    }
}
