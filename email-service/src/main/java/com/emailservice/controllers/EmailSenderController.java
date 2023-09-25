package com.emailservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailservice.application.EmailSenderService;
import com.emailservice.core.EmailRequest;
import com.emailservice.core.exceptions.EmailServiceException;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

	private final EmailSenderService service;
	
	@Autowired
	public EmailSenderController(EmailSenderService emailService) {
		this.service = emailService;
	}
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
		try {
			this.service.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
			return ResponseEntity.ok("email send success");
		} catch (EmailServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error while sending email");
		}
	}
}