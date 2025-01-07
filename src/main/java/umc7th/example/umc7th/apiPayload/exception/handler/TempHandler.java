package umc7th.example.umc7th.apiPayload.exception.handler;

import umc7th.example.umc7th.apiPayload.code.BaseErrorCode;
import umc7th.example.umc7th.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}