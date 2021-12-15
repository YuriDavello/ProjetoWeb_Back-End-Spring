package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.interfaces.Confirmation;
import com.ifsp.pwe_projetofinal.model.Details;
import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/email")
@CrossOrigin("*")
@RestController
public class EmailSender {

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Confirmation confirmation;

    @PostMapping("confirm")
    public Object confirmEmail(@RequestBody User user) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", user.getUsersData().getNome());
        model.put("email", user.getUsername());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("confirmation", context);

        try {
            helper.setTo(user.getUsername());
            helper.setText(html, true);
            helper.setSubject("Welcome to pwe project");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return confirmation.confirmEmail(user);
    }
}
