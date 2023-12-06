package com.example.umc.validation.validator;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.service.RegionService.RegionCommandService;
import com.example.umc.validation.annotation.ExistRegions;
import com.example.umc.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class RegionsExistValidator implements ConstraintValidator<ExistRegions, String> {

    private final RegionCommandService regionCommandService;

    @Override
    public void initialize(ExistRegions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = regionCommandService.existRegionByName(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }

}
