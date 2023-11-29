package com.example.umc.apiPayload.validation.validator;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.validation.annotation.ExistRegions;
import com.example.umc.domain.Region;
import com.example.umc.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegionsExistValidator implements ConstraintValidator<ExistRegions, String> {

    private final RegionRepository regionRepository;

    @Override
    public void initialize(ExistRegions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = regionRepository.existsRegionByName(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }

}
