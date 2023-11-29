package com.example.umc.apiPayload.exception.handler;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException{
    public StoreHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
