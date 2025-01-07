package umc7th.example.umc7th.repository.StoreRepository;

import umc7th.example.umc7th.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
