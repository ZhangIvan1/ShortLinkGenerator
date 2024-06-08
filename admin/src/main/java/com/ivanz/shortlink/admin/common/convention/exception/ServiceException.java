package com.ivanz.shortlink.admin.common.convention.exception;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.ivanz.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.ivanz.shortlink.admin.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * 远程调用服务异常
 */
public class ServiceException extends AbstractException {

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "errorCode='" + errorCode + '\'' +
                ", errMessage='" + errorMessage + '\'' +
                '}';
    }
}
