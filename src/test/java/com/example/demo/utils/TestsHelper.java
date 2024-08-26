package com.example.demo.utils;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;

public class TestsHelper {
    public static Hotel createHotelHelper(){
        Hotel hotel = new Hotel();
        hotel.setName("Nas test hotel");
        hotel.setCity("Skoplje");
        hotel.setCountry("Macedonia");
        hotel.setNumberOfStars(3);
        return hotel;
    }
    public static Room createRoomHelper(){
        Room room = new Room();
        room.setRoomNumber(8);
        room.setType(2);
        room.setPrice(100);
        return room;
    }
}
