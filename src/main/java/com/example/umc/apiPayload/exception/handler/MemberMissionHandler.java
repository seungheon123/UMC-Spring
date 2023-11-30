package com.example.umc.apiPayload.exception.handler;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
