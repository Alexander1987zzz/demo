package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
public class AuthController {


//    @PostMapping()
//    public ResponseEntity<String> getToken(@RequestBody Dto dto) {
//        if ("client_credentials".equals(dto.getClientCredentials()) &&
//                "dbo_dso@tech.b2c.vtb.ru".equals(dto.getClientId()) &&
//                "xR3z5[zvs/Dkzp".equals(dto.getClientSecret())) {
//            return ResponseEntity.ok("Access Token: yourAccessToken"); // Верните токен
//        } else {
//            return ResponseEntity.status(401).body("Invalid credentials"); // Обработка ошибок
//        }
//    }

    @GetMapping("rest")
    public void update(@RequestParam Long id, @RequestParam Integer quantity) {
        RestTemplate restTemplate = new RestTemplate();
        // Создаем поток для первого запроса на первый порт
        Thread thread1 = new Thread(() -> {
            String url1 = "http://localhost:8080/update?id=" + id + "&quantity=" + quantity;
            restTemplate.getForEntity(url1, Void.class);
        });

        // Создаем поток для второго запроса на второй порт
        Thread thread2 = new Thread(() -> {
            String url2 = "http://localhost:8081/update?id=" + id + "&quantity=" + quantity;
            restTemplate.getForEntity(url2, Void.class);
        });

        // Запускаем потоки
        thread1.start();
        thread2.start();}
}
