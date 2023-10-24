package com.rbp.radeg.utils.exceptions;


import com.rbp.radeg.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NoContentException extends RadegException {
	private static final long serialVersionUID = -6870732210014274010L;

	public NoContentException(final String message) {
		super(HttpStatus.NO_CONTENT.value(), message);
	}

	public NoContentException(final String message, final ErrorDto data) {
		super(HttpStatus.NO_CONTENT.value(), message, Arrays.asList(data));
	}
}
