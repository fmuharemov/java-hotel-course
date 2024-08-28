package com.example.demo.Service;

import com.example.demo.Exception.RoomNotFoundException;
import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelService hotelService;
    public List<Room> findAll(){ return roomRepository.findAll();}

    public String createRoom(RoomDTO dto){
        Hotel hotel = hotelService.findById(dto.getHotelId());
        Room room = new Room();
        room.setId(dto.getId());
        room.setType(dto.getType());
        room.setRoomNumber(dto.getRoomNumber());
        room.setPrice(dto.getPrice());
        roomRepository.save(room);
        return "Room created successfully!";
    }
    public Room findRoomById(Long id) throws RoomNotFoundException { return roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException("Room not found with id: "+ id));}
    public List<Room> findRoomByBedCount(int bedCount){
        return roomRepository.findRoomByBedCount(bedCount);
    }

    public void delete(Long id) {
        roomRepository.findById(id).get();
        roomRepository.deleteById(id);
    }

    public Room update(Room room, Long id) {
        roomRepository.findById(id).get();
        room.setId(id);
        return roomRepository.save(room);
    }

    public Room findById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.get();
    }
}
