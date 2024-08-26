package com.example.demo.repository;

import com.example.demo.model.Room;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.demo.utils.TestsHelper.createRoomHelper;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Transactional
public class RoomRepositoryTest {
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void findRoomByBedCountTest(){
        //Arange
        roomRepository.save(createRoomHelper());
        //Act
        List<Room> rooms= roomRepository.findRoomByBedCount(1);
        //Assert
        assertFalse(rooms.isEmpty());
    }
}
