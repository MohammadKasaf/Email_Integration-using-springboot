package com.springboot.email;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public String sendSimpleEmail(User user){

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(user.getSenderEmail());
            message.setTo(user.getRecieverEmail());
            message.setSubject(user.getSubject());
            message.setText(user.getBody());

            mailSender.send(message);

            return "email send successfully";
        }
        catch(Exception e){

            return "Error sending email: " + e.getMessage();
        }
    }

    public String sendEmailWithAttachment(){

        try {
            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper  helper=new MimeMessageHelper(message,true);
            helper.setFrom("kaashifchishti611@gmail");
            helper.setTo("kaashifchishti611@gmail.com");
            helper.setSubject("Test Email with Attachment");
            helper.setText("This is a test email with an attachment.");

            //add attachment
            helper.addAttachment("resume.pptx",new File("D:\\download\\resume.pptx.pdf"));
            helper.addAttachment("newResume.pdf",new File("D:\\download\\newResume.pdf"));
            mailSender.send(message);
            return "email is send successfully";
        }
        catch(Exception e){

            return "Error sending email"+ e.getMessage();
        }

    }

    public String sendHtmlEmail() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("kaashifchishti611@gmail.com");
            helper.setTo("kaashifchishti611@gmail.com");
            helper.setSubject("professional profile of Mohammad kasaf");

            try (var inputStream = Objects.requireNonNull(EmailController.class.getResourceAsStream("/templates/professional-profile.html"))) {
                helper.setText(
                        new String(inputStream.readAllBytes(), StandardCharsets.UTF_8),
                        true
                );
            }
            mailSender.send(message);
            return "Email send successfully";

        } catch (Exception e) {
            return "Error sending email"+e.getMessage();
        }
    }





}
