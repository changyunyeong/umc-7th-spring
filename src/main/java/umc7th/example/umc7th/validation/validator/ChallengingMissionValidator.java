package umc7th.example.umc7th.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc7th.example.umc7th.validation.annotation.ExistChallengingMission;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChallengingMissionValidator implements ConstraintValidator<ExistChallengingMission, List<Long>> {

    @Override
    public void initialize(ExistChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> longs, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
