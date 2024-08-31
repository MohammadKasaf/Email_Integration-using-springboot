package com.springboot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    //send simple mail message
    @PostMapping("/send-simple-email")
    public String sendSimpleEmail(@RequestBody User user){

         try{

             String message=emailService.sendSimpleEmail(user);
             return message;
         }
         catch (Exception e){

             return "Error sending email: " + e.getMessage();
         }
    }

    @GetMapping("/send-email-with-attachment")
    public String sendEmailWithAttachment(){

        try{

            String result=emailService.sendEmailWithAttachment();
            return result;
        }
        catch(Exception e){

            return "Error sending email " +e.getMessage();
        }
    }

    //send email with template
    @GetMapping("/send-email-with-template")
    public String sendEmailWithTemplate(){

        try{

            String result=emailService.sendHtmlEmail();
            return result;
        }
        catch(Exception e){

            return "Error sending email " +e.getMessage();
        }

    }



}
