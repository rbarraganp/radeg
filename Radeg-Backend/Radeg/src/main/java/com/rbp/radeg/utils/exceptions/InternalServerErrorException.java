package com.rbp.radeg.utils.exceptions;


import com.rbp.radeg.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends RadegException {
	private static final long serialVersionUID = -6870732210014274010L;

	public InternalServerErrorException(final String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public InternalServerErrorException(final String message, final ErrorDto data) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
