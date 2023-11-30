package com.example.umc.validation.annotation;

import com.example.umc.validation.validator.MemberExistValidator;
import com.example.umc.validation.validator.MissionExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "해당 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
