package com.rbp.radeg.utils.exceptions;

import com.rbp.radeg.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class ConflictException extends RadegException {
	private static final long serialVersionUID = 1L;

	public ConflictException(final String message) {
		super(HttpStatus.CONFLICT.value(), message);
	}

	public ConflictException(final String message, final ErrorDto data) {
		super(HttpStatus.CONFLICT.value(), message, Arrays.asList(data));
	}
}
