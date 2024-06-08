package com.ivanz.shortlink.admin.common.convention.exception;

import com.ivanz.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.ivanz.shortlink.admin.common.convention.errorcode.IErrorCode;

import java.util.Optional;

public class RemoteException extends AbstractException {

    public RemoteException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "errorCode='" + errorCode + '\'' +
                ", errMessage='" + errorMessage + '\'' +
                '}';
    }
}
