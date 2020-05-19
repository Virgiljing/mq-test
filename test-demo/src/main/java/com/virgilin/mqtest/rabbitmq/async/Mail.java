package com.virgilin.mqtest.rabbitmq.async;

public class Mail {
    private String from;//发件人
    private String to;//收件人
    private String subject;//邮件标题
    private String content;//邮件内容

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    //用户注册
    public void userRegister(){
        Mail mail = new Mail();
        mail.setTo("1234567890@qq.com");
        mail.setSubject("我是一封邮件");
        mail.setContent("我的邮件内容");
        sendMail(mail);
    }

    private void sendMail(Mail mail) {
        //调用JavaMail API发送邮件
    }
}
