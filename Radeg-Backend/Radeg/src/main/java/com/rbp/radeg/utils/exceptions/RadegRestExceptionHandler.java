package com.rbp.radeg.utils.exceptions;

import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.responses.RadegResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RadegRestExceptionHandler {

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public RadegResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new RadegResponse(ExceptionConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
	}

	@ExceptionHandler({ RadegException.class })
	@ResponseBody
	public RadegResponse handleLmException(final HttpServletRequest request, final HttpServletResponse response,
										   final RadegException ex) {
		response.setStatus(ex.getCode());
		return new RadegResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()), ex.getMessage(),
				ex.getErrorList());
	}
}
