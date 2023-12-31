package com.example.umc.apiPayload.code.status;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    //지역 관련 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION4001","지역이 없습니다"),

    //가게 관련 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE4001","가게가 없습니다"),

    //미션 관련 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION4001","미션이 없습니다"),
    MISSION_STATE_CHALLENGE(HttpStatus.BAD_REQUEST, "MISSION4002","미션이 이미 진행 중입니다"),

    INVALID_PAGE_NUMBER(HttpStatus.NOT_FOUND,"PAGE4001","페이지 번호는 음수일 수 없습니다"),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason(){
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus(){
        return ErrorReasonDto.builder()
                .httpStatus(httpStatus)
                .isSuccess(false)
                .message(message)
                .code(code)
                .build();
    }

}
