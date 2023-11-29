package com.example.umc.apiPayload.exception.handler;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
