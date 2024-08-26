package com.example.demo.service;

import com.example.demo.Service.HotelService;
import com.example.demo.model.Hotel;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class HotelServiceTest {
    @Autowired
    private HotelService hotelService;

    @Test
    public void findAllTest(){
        //Act
        List<Hotel> hotels = hotelService.findAll();

        //Assert
        assertNotNull(hotels);
        assertTrue(hotels.size()>0);
    }
}
