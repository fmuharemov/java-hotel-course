package com.example.demo.repository;

import com.example.demo.model.Hotel;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.demo.utils.TestsHelper.createHotelHelper;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class HotelRepositoryTest {
    @Autowired
    private HotelRepository hotelRepository;

    @Test
    public void saveTest(){
        //Arange
        Hotel hotel = createHotelHelper();

        //Act
        Hotel saveHotel= hotelRepository.save(hotel);

        //Asert
        assertNotNull(saveHotel);
        assertEquals("Nas test hotel", saveHotel.getName());
    }
    @Test
    public void findAllByRatingGreaterThenTest(){
        //Arange
        hotelRepository.save(createHotelHelper());
        //Act
        List<Hotel> hotels= hotelRepository.findAllByRatingGreaterThen(2);
        //Asert
        assertFalse(hotels.isEmpty());
    }
}
