package com.example.umc.validation.validator;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.service.MemberService.MemberCommandService;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember,Long> {

    private final MemberCommandService memberCommandService;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = memberCommandService.existMember(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
