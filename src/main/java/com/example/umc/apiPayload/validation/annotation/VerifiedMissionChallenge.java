package com.example.umc.apiPayload.validation.annotation;

import com.example.umc.apiPayload.validation.validator.MissionChallengeVerifiedValidator;
import com.example.umc.apiPayload.validation.validator.StoreExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengeVerifiedValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifiedMissionChallenge {
    String message() default "해당 미션은 이미 도전 중입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
