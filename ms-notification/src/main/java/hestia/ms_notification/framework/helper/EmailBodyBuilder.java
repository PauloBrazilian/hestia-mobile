package hestia.ms_notification.framework.helper;

import org.springframework.stereotype.Component;

@Component
public class EmailBodyBuilder {

    public String buildWelcomeEmail(String imageUrl, String message) {
        return "<html>" +
                "<body style='text-align: center; font-family: Arial, sans-serif;'>" +
                "<h1>Welcome to Hestia</h1>" +
                "<p>" + message + "</p>" +
                "<img src='" + imageUrl + "' alt='Welcome Image' style='width: 100%; height: auto;'/>" +
                "</body>" +
                "</html>";
    }
}
