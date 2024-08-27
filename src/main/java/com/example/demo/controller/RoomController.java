package com.example.demo.controller;

import com.example.demo.Exception.RoomNotFoundException;
import com.example.demo.Service.RoomService;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }
    @GetMapping
    public List<Room> findAllRooms(){
        return roomService.findAll();
    }
    @PostMapping
    public String createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("There is no room with id "+ id + " in our database", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> findRoomsByBedCount(@RequestParam int bedCount) throws RoomNotFoundException {
        List<Room> rooms = roomService.findRoomByBedCount(bedCount);
        return ResponseEntity.ok(rooms);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            roomService.delete(id);
            return new ResponseEntity<>("Room deleted!", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Room with id "+ id + " is not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Room room){
        try {
            roomService .update(room, id);
            return new ResponseEntity<>("Room updated!", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Room with id "+ id + " is not found", HttpStatus.NOT_FOUND);
        }
    }
}
