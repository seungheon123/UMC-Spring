package com.example.umc.validation.annotation;



import com.example.umc.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "해당 페이지 번호가 음수입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
