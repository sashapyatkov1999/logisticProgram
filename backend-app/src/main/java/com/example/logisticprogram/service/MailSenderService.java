package com.example.logisticprogram.service;

import com.example.logisticprogram.config.MailFactory;
import com.example.logisticprogram.dto.request.EmailSendRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {


    @Value("${spring.mail.from}")
    private String from;

    private final MailFactory mailFactory;

    public void sendMail(EmailSendRequest request){

        var sender = mailFactory.getJavaMailSender();

        var msg = sender.createMimeMessage();
        try {
            var helper = new MimeMessageHelper(msg, true, "UTF-8");

            helper.setFrom(from);

            helper.setSubject(request.getSubject());
            helper.setText(request.getText());

            helper.setTo(request.getTo().toArray(new String[0]));
            helper.setCc(request.getCc().toArray(new String[0]));
            helper.setBcc(request.getBcc().toArray(new String[0]));


            request.getAttachments().forEach(attach -> {

                try {
                    helper.addAttachment(attach.getL(), attach.getR());
                } catch (MessagingException e) {
                    throw new RuntimeException("Не удалось добавить файл к письму: " + e.getMessage());
                }

                sender.send(msg);

            });

        } catch (MessagingException e) {
            throw new RuntimeException("Произошла ошибка при отправке письма: " + e.getMessage());
        }

    }
}
