package com.example.umc.apiPayload.validation.annotation;

import com.example.umc.apiPayload.validation.validator.RegionsExistValidator;
import com.example.umc.apiPayload.validation.validator.StoreExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "해당 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
