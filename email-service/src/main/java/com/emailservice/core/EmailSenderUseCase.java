package com.emailservice.core;


//contrato de comportamento
public interface EmailSenderUseCase {
	void sendEmail(String to, String subject, String body);
}
