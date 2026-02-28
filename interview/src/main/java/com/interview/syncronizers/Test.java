////package com.interview.syncronizers;
////
////public class Test {
////}
//@Slf4j
//@RequiredArgsConstrucor
//public class KafkaSender {
//    private final KafkaTemplate kafkaTemplate;
//
//    @Value("${kafka.topic}")
//    private String topic;
//
//    public void send(Message message) {
//        try {
//            log.info("Attempt to send message {}", message);
//            kafkaTemplate.send(topic, message);
//            log.info("Message succesfully sent");
//        } catch(RuntimeException e) {
//            log.error("Error while sending message", e)
//        }
//    }
//}
//
//==========================
//
//@RequiredArgsConstrucor
//public class KafkaConsumer {
//
//    private final UserService userService;
//
//    @KafkaListener(concurrency = 5, topic = "topic")
//    public void consume(Message message) {
//        userService.register(message);
//    }
//}
//
//@RequiredArgsConstrucor
//public class UserService {
//
//    private final UserRegFeignClient userRegisterFeignClient;
//    private final CardRegFeignClient cardRegisterFeignClient;
//
//
//    public void register(Message message) {
//        //logic
//        var userResponce = userRegisterFeignClient.registerUser();
//        //logic
//        if (userResponse.getStatusCode.is2xx) {
//            cardRegisterFeignClient.registerCard();
//        }
//    }
//}
//
//@Entity
//@Data
//public class Client {
//
//    @Id
//    @Column(name = "id")
//    private Integer id;
//
//    private String name;
//
//    private String surname;
//
//    private Integer balance;
//
//    @OneToMany
//    private List<Cow> cows;
//}
//
//========================
//
//@Entity
//@Data
//public class Cow {
//
//    @Id
//    @Column(columnDefinition = "UUID")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    private String name;
//
//    private Boolean bell;
//
//    @CreationTimestamp
//    private LocalDateTime createDate;
//
//    @UpdateTimestamp
//    private LocalDateTime updateDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Client client;
//}
//
//==========================
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class Service {
//
//    private ClientRepository clientRepository;
//
//    @Transactional
//    public void update(ClientDto clientDto) {
//        clientRepository.findClientById(clientDto.getId())
//                .ifPresent(c -> {
//                    log.info("Found client in DB: {}", c);
//                    c.setBalance(c.getBalance() + clientDto.getBalance());
//                });
//    }
//}
//
//@RestControllers
//public Controller {
//    private Service myService;
//
//    @PostMapping("/update")
//    public void updateUser(ClientDto dto) {
//        myService.update(dto);
//    }
//}
//
//==========================
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class ClientDto {
//
//    private Integer id;
//    private Integer balance;
//}