package com.example.umc.apiPayload.code.status;

import com.example.umc.apiPayload.code.BaseCode;
import com.example.umc.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK,"COMMON200","성공입니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason(){
        return ReasonDto.builder()
                .isSuccess(true)
                .message(message)
                .code(code)
                .build();

    }

    @Override
    public ReasonDto getReasonHttpStatus(){
        return ReasonDto.builder()
                .isSuccess(true)
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
