package umc7th.example.umc7th.validation.annotation;

import jakarta.validation.Payload;

public @interface ExistChallengingMission {

    String message() default "도전 하려는 미션이 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
