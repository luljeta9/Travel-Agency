package al.sda.demo.hotel.service;

import al.sda.demo.hotel.mapper.HotelMapper;
import al.sda.demo.hotel.model.Hotel;
import al.sda.demo.hotel.model.HotelDto;
import al.sda.demo.hotel.repository.HotelRepository;
import al.sda.demo.hotel.repository.HotelRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.getName;
import static org.springframework.data.repository.util.ClassUtils.ifPresent;


@Service
public class HotelService {
    private final HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<HotelDto> getHotelList(int page, int size) {
        Pageable pageable = Pageable.ofSize(size)
                .withPage(page);

        return repository.findAll(pageable).get()
                .map(HotelMapper::toDto)
                .toList();
    }




    public HotelDto getHotelById(Long id) {
        return repository.findById(id)
                .map(HotelMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
    }

    @Transactional
    public Long createHotel(HotelDto hotelDto) {
        if (repository.existsByName(hotelDto.getName())) {
            throw new EntityExistsException("Hotel already exists");
        }

        Hotel hotel = HotelMapper.toEntity(hotelDto);
        return repository.save(hotel)
                .getId();
    }

    @Transactional
    public void updateHotel(Long id, HotelDto hotelDto) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" Hotel not found"));

        repository.save(hotel);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(" Hotel not found");
        }

        repository.deleteById(id);
    }
}
