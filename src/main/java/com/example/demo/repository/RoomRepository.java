package com.example.demo.repository;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    @Query("SELECT h FROM Room h WHERE h.type > :type")
    List<Room> findRoomByBedCount(@Param("type") Integer type);
}
