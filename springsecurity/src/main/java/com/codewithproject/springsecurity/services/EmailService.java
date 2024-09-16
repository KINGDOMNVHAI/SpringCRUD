package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.EmailDto;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDto details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDto details);
}
