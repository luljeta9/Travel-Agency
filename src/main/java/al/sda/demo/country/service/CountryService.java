package al.sda.demo.country.service;

import al.sda.demo.country.model.Country;
import al.sda.demo.country.model.CountryDto;
import al.sda.demo.country.repository.CountryRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
    private final CountryRepository repository;
    
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }
    
    public Page<Country> getCountryList(int page, int size) {
        Pageable pageable = Pageable.ofSize(size)
                                    .withPage(page);
        return repository.findAll(pageable);
    }


    public CountryDto getCountryById(Long id) {
       Country country = repository.findById(id)
                      .orElseThrow(() -> new EntityNotFoundException("Country not found"));
       
       return new CountryDto(country.getId(), country.getName(), country.getContinent());
    }

    @Transactional
    public Long createCountry(CountryDto countryDto) {
        repository.findByName(countryDto.getName())
                  .ifPresent(c -> {
                      throw new EntityExistsException("Country already exists");
                  });
        
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        
        return repository.save(country)
                       .getId();
    }
    
    @Transactional
    public void updateCountry(Long id, CountryDto countryDto) {
        Country country = repository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Country not found"));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        
        repository.save(country);
    }
    
    @Transactional
    public void deleteCountry(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Country not found");
        }
        
        repository.deleteById(id);
    }
}
