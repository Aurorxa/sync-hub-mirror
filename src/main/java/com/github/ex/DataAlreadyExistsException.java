package com.github.ex;

import com.feiniaojin.gracefulresponse.api.ExceptionMapper;
import com.github.utils.Constant;
import lombok.experimental.StandardException;

@StandardException
@ExceptionMapper(code = "500", msgReplaceable = true, msg = Constant.DATA_ALREADY_EXISTS)
public class DataAlreadyExistsException extends RuntimeException {
}
