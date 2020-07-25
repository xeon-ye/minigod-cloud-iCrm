package com.minigod.mail.model;

import com.minigod.mail.exception.ContentException;

public interface Content {
	public boolean useTemplate();

	public boolean validate() throws ContentException;
}