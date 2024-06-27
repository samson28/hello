package com.lundu.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Bienvenue</title>\n" +
                "    <style>\n" +
                "        /* Styles de base */\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            font-family: 'Arial', sans-serif;\n" +
                "            background-color: #f4f4f9;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            text-align: center;\n" +
                "            background-color: #fff;\n" +
                "            padding: 2rem;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            color: #333;\n" +
                "            margin-bottom: 1rem;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            color: #666;\n" +
                "            font-size: 1.1rem;\n" +
                "            margin-bottom: 2rem;\n" +
                "        }\n" +
                "\n" +
                "        .btn {\n" +
                "            background-color: #007bff;\n" +
                "            color: white;\n" +
                "            border: none;\n" +
                "            padding: 0.75rem 1.5rem;\n" +
                "            font-size: 1rem;\n" +
                "            border-radius: 5px;\n" +
                "            cursor: pointer;\n" +
                "            transition: background-color 0.3s ease;\n" +
                "        }\n" +
                "\n" +
                "        .btn:hover {\n" +
                "            background-color: #0056b3;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>Bienvenue sur mon site !</h1>\n" +
                "        <p>Nous sommes ravis de vous accueillir. Profitez de votre visite !</p>\n" +
                "        <button class=\"btn\">En savoir plus</button>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
