package com.example.demo;

import com.example.demo.Service.HotelService;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class HotelApplication {
	public static void main(String[] args) {

		SpringApplication.run(HotelApplication.class, args);
	}

}
