package umc7th.example.umc7th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc7th.example.umc7th.apiPayload.code.status.ErrorStatus;
import umc7th.example.umc7th.repository.FoodCategoryRepository;
import umc7th.example.umc7th.service.FoodCategoryService.FoodCategoryQueryService;
import umc7th.example.umc7th.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryQueryService foodCategoryQueryService; // Repository 대신 Service 사용

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryQueryService.existsAllByIds(values); // Service 통해 존재 여부 확인

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
