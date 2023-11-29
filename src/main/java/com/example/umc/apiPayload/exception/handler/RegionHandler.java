package com.example.umc.apiPayload.exception.handler;

import com.example.umc.apiPayload.code.BaseErrorCode;
import com.example.umc.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
