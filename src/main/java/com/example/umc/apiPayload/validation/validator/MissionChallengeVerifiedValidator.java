package com.example.umc.apiPayload.validation.validator;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.validation.annotation.VerifiedMissionChallenge;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionChallengeVerifiedValidator implements ConstraintValidator<VerifiedMissionChallenge,Long> {

    private final MemberMissionRepository memberMissionRepository;
    //private final MissionRepository missionRepository;

    @Override
    public void initialize(VerifiedMissionChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = true;
        Optional<MemberMission> memberMission = memberMissionRepository.findById(value);
        if(memberMission.isPresent()){
            MemberMission memberMission1 = memberMission.get();
            if(memberMission1.getMissionStatus()==MissionStatus.CHALLENGING) isValid= false;
        }
        return isValid;
    }

//    @Override
//    public boolean isValid(Long value, ConstraintValidatorContext context) {
//        boolean isValid = missionRepository.existsById(value);
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
//            return isValid;
//        }else{
//            isValid = memberMissionRepository.existsByIdAndMissionStatusNot(value,MissionStatus.CHALLENGING);
//            if(isValid){
//                context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATE_CHALLENGE.toString()).addConstraintViolation();
//            }
//        }
//        return isValid;
//    }


}
