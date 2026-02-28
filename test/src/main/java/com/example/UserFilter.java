package com.example;

import java.time.LocalDate;

public record UserFilter  (String name,
                           String email,
                           LocalDate createdAfter
) {}
