package com.minigod.mail.model;

import com.minigod.mail.exception.ReceiverException;

public interface Receiver {
	public boolean useAddressList();
	
	public boolean validate() throws ReceiverException;
	
	public String toString();
}