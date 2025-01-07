package umc7th.example.umc7th.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {

    boolean existsAllByIds(List<Long> ids);
}
