package com.interview.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private MobileService mobileService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private PaymentMapper mapper;

    public void executePayment(PaymentDto request) {
        if (request.amount() < 0) {
            throw new RuntimeException();
        }
        mobileService.sendToOperatorApi(request);
        notificationService.sendNotification(request.userId());
        Payment entity = mapper.toEntity(request);
        paymentRepository.save(entity);

        log.info("Processed payment ID: {}, total payments: {}",
                entity.getId(),
                paymentRepository.count());
    }
}
