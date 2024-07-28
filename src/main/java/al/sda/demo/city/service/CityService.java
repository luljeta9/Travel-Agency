package al.sda.demo.city.service;

import al.sda.demo.city.mapper.CityMapper;
import al.sda.demo.city.model.City;
import al.sda.demo.city.model.CityDto;
import al.sda.demo.city.repository.CityRepository;
import al.sda.demo.country.model.Country;
import al.sda.demo.country.model.CountryDto;
import al.sda.demo.country.repository.CountryRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CityService {


    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<CityDto> getCityList(int page, int size) {
        Pageable pageable = Pageable.ofSize(size)
                .withPage(page);

        return repository.findAll(pageable).getContent()
                .stream()
                .map(CityMapper::toDto)
                .toList();
    }


    public CityDto getCityById(Long id) {
        return repository.findById(id)
                .map(CityMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));
    }

    @Transactional
    public Long createCity(CityDto cityDto) {
        repository.findByName(cityDto.getName())
                .ifPresent(c -> {
                    throw new EntityExistsException("City already exists");
                });

        City city = CityMapper.toEntity(cityDto);
        return repository.save(city)
                .getId();
    }

    @Transactional
    public void updateCity(Long id, CityDto cityDto) {
        cityDto.setId(id);
        City city = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cityy not found"));
        city = CityMapper.toEntity(cityDto);

        repository.save(city);
    }

    @Transactional
    public void deleteCity(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("City not found");
        }

        repository.deleteById(id);
    }
}

