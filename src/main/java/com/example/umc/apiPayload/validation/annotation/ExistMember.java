package com.example.umc.apiPayload.validation.annotation;

import com.example.umc.apiPayload.validation.validator.MemberExistValidator;
import com.example.umc.apiPayload.validation.validator.RegionsExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
    String message() default "해당 회원이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
