package com.ivanz.shortlink.admin.common.convention.exception;


import com.ivanz.shortlink.admin.common.convention.errorcode.IErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 抽象项目中三类异常体系的基类
 * <p>
 * 客户端异常：ClientException
 * 服务端异常：ServiceException
 * 远程调用异常：RemoteException
 */

@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
