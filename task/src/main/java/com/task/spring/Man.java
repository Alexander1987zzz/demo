package com.task.spring;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "man", fetch = FetchType.EAGER)
    List<Cat> cats;
    @OneToMany(mappedBy = "man",fetch = FetchType.EAGER)
    List<Pet> pets;}


