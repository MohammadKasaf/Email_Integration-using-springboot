package com.springboot.email;

public class User {

    private String senderEmail;
    private String recieverEmail;
    private String subject;
    private String body;

    public User(String senderEmail, String recieverEmail, String subject, String body) {
        this.senderEmail = senderEmail;
        this.recieverEmail = recieverEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecieverEmail() {
        return recieverEmail;
    }

    public void setRecieverEmail(String recieverEmail) {
        this.recieverEmail = recieverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
