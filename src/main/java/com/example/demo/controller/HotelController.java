package com.example.demo.controller;

import com.example.demo.Exception.NotFoundInDatabaseException;
import com.example.demo.Service.HotelService;
import com.example.demo.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    HotelService hotelService;
    //umjesto Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }
    @GetMapping()
    public List<Hotel> findAllHotels(){
        return hotelService.findAll();
    }

    @PostMapping()
    public String createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @GetMapping("/rating-greater-then/{rating}")
    public List<Hotel> findAllByRatingGreaterThen(@PathVariable Integer rating){
        return hotelService.findAllByRatingGreaterThen(rating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws NotFoundInDatabaseException {
        try{
            return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("There is no hotel with id "+ id + " in our database", HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            hotelService.delete(id);
            return new ResponseEntity<>("Hotel deleted!", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("There is no hotel with id "+ id + " in our database", HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Hotel hotel){
        try {
            hotelService.update(hotel, id);
            return new ResponseEntity<>("Hotel updated!", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("There is no hotel with id "+ id + " in our database", HttpStatus.NOT_FOUND);
        }

    }
}
