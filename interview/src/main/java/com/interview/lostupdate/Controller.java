package com.interview.lostupdate;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;


    @GetMapping({"product"})
    public void product(@RequestParam Long id, @RequestParam Integer quantity) {
        Thread thread1 = new Thread(() -> {
            this.productService.update(id, quantity);
        });
        Thread thread2 = new Thread(() -> {
            this.productService.update(id, quantity);
        });
        thread1.start();
        thread2.start();
    }


    @GetMapping({"update"})
    public void update(@RequestParam Long id, @RequestParam Integer quantity) {
            this.productService.update(id, quantity);
    }

}