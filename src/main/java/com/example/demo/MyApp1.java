package com.example.demo;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import model.Gender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;


@SpringBootApplication
public class MyApp1 {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MyApp1.class, args);


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String s = reader.readLine();




	}
}