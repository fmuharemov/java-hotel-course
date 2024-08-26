package com.example.demo.Service;

import com.example.demo.Exception.NotFoundInDatabaseException;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public String createHotel(Hotel hotel){
        hotelRepository.save(hotel);
        return "Hotel is saved!";
    }
    public List<Hotel> findAllByRatingGreaterThen(Integer rating){
        return hotelRepository.findAllByRatingGreaterThen(rating);
    }

    public Hotel findById(Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.get();
    }

    public void delete(Long id) {
        hotelRepository.findById(id).get();
        hotelRepository.deleteById(id);
    }

    public Hotel update(Hotel hotel, Long id) {
        hotelRepository.findById(id).get();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }
}
