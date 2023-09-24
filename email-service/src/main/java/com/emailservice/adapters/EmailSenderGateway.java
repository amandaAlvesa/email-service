package com.emailservice.adapters;

//contrato com o provedor de servicos
public interface EmailSenderGateway {
	void sendEmail(String to, String subject, String body);
}
