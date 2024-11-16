package umc7th.example.umc7th.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7th.example.umc7th.apiPayload.ApiResponse;
import umc7th.example.umc7th.converter.StoreConverter;
import umc7th.example.umc7th.domain.Store;
import umc7th.example.umc7th.service.StoreService.StoreCommandService;
import umc7th.example.umc7th.web.dto.StoreRequestDTO;
import umc7th.example.umc7th.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.StoreDTO request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }
}
