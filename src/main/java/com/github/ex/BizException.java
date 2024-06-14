package com.github.ex;

import com.feiniaojin.gracefulresponse.api.ExceptionMapper;
import lombok.experimental.StandardException;

@StandardException
@ExceptionMapper(code = "500", msgReplaceable = true)
public class BizException extends RuntimeException {

}