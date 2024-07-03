package com.lawProject.SSL.domain.user.exception;

import com.lawProject.SSL.global.common.code.ErrorCode;
import com.lawProject.SSL.global.error.exception.BusinessException;

public class UserException extends BusinessException {
    public UserException(ErrorCode code) {
        super(code);
    }
}

