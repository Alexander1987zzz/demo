package com.interview.lostupdate;

import com.interview.feign.TestFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final OrderService orderService;
    private final TestFeign testFeign;

    @GetMapping({"order"})
    public void order(@RequestParam Long id, @RequestParam Integer quantity) {
        Thread thread1 = new Thread(() -> {
            this.orderService.update(id, quantity);
        });
        Thread thread2 = new Thread(() -> {
            this.orderService.update(id, quantity);
        });
        thread1.start();
        thread2.start();
    }


    @GetMapping({"update"})
    public void update(@RequestParam Long id, @RequestParam Integer quantity) {
            this.orderService.update(id, quantity);
    }

    @GetMapping({"feign"})
    public void testFeign() {
       testFeign.getUnits(null);
    }
}