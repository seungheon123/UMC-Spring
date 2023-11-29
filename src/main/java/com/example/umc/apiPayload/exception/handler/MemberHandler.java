package com.example.umc.apiPayload.exception.handler;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
