package ru.goodvard.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.goodvard.controller.dto.RequestData;

import static ru.goodvard.utils.FileUtils.readFromResource;

@Component
public class GoodVardHtmlBuilder implements HtmlBuilder {

    @Value("classpath:htmlTemplates/CustomerResponse.html")
    private Resource customerTemplateResource;

    @Value("classpath:htmlTemplates/AdminResponse.html")
    private Resource adminTemplateResource;

    @Override
    public String customerResponseHtml(String customerName) {
        String text = "Ваше обращение в GoodVard зарегистрировано. Мы постараемся связаться с Вами в ближайшее время";
        String htmlTemplate = readFromResource(customerTemplateResource);
        htmlTemplate = htmlTemplate.replace("${NAME}", customerName);
        htmlTemplate = htmlTemplate.replace("${TEXT}", text);
        return htmlTemplate;
    }

    @Override
    public String adminResponseHtml(RequestData request) {
        var status = request.getStatus() == null ? "" : request.getStatus().getDescription();
        String htmlTemplate = readFromResource(adminTemplateResource);
        htmlTemplate = htmlTemplate.replace("${TEXT}", "Зарегистрировано обращение на обратную связь." + status);
        htmlTemplate = htmlTemplate.replace("${NAME}", "Уважаемый администратор школы");
        htmlTemplate = htmlTemplate.replace("${CUSTOMER_NAME}", request.getName());
        htmlTemplate = htmlTemplate.replace("${PHONE}", request.getPhone());
        htmlTemplate = htmlTemplate.replace("${EMAIL}", request.getEmail());
        htmlTemplate = htmlTemplate.replace("${MESSAGE}", request.getMessage());
        return htmlTemplate;
    }
}
