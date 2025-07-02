package com.interview.async;

import com.interview.payment.Payment;
import com.interview.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AsyncService {
    PaymentRepository repository;

    @Transactional
    public void executeOperation(Long id) {
        doSomething(id);
        doAsyncOperation(id);
    }

    @Async
    public void doAsyncOperation(Long id) {
        Payment payment = repository.findById(id).orElseThrow(RuntimeException::new);
        doSomethingElse(payment);
        repository.save(payment);
    }

    public void doSomething(Long id) {
    }

    public void doSomethingElse(Payment payment) {
    }

}
