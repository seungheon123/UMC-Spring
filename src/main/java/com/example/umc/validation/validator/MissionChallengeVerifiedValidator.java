package com.example.umc.validation.validator;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.validation.annotation.VerifiedMissionChallenge;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.web.dto.MemberMissionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionChallengeVerifiedValidator implements ConstraintValidator<VerifiedMissionChallenge, Long> {

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
        if (memberMission.isPresent()) {
            MemberMission exist = memberMission.get();
            if (exist.getMissionStatus() == MissionStatus.CHALLENGING){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATE_CHALLENGE.toString()).addConstraintViolation();
                isValid = false;
            }
        }
        return isValid;
    }


}
