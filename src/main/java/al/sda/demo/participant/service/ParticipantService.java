package al.sda.demo.participant.service;

import al.sda.demo.airport.mapper.AirportMapper;
import al.sda.demo.airport.model.Airport;
import al.sda.demo.airport.model.AirportDto;
import al.sda.demo.airport.repository.AirportRepository;
import al.sda.demo.participant.mapper.ParticipantMapper;
import al.sda.demo.participant.model.Participant;
import al.sda.demo.participant.model.ParticipantDto;
import al.sda.demo.participant.repository.ParticipantRepository;
import al.sda.demo.tour.model.Tour;
import al.sda.demo.tour.repository.TourRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private static final String PARTICIPANT_NOT_FOUND = "participant not found";
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.repository = participantRepository;
    }

    public Long saveParticipant(ParticipantDto participant) {
        if (repository.findById(participant.getId())
                .isPresent()) {
            throw new EntityExistsException("An participant with the same Id already exists");
        }

        Participant entity = ParticipantMapper.toEntity(participant);
        return repository.save(entity).getId();
    }

    public void updateParticipant(Long id, ParticipantDto participant) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException();

        }
        participant.setId(id);

        repository.save(ParticipantMapper.toEntity(participant));
    }

    public void deleteParticipant(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(PARTICIPANT_NOT_FOUND);
        }
        repository.deleteById(id);
    }

    public ParticipantDto getParticipantById(Long id) {
        Participant existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PARTICIPANT_NOT_FOUND));
        return ParticipantMapper.toDto(existing);
    }

    public List<ParticipantDto> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent()
                .stream()
                .map(ParticipantMapper::toDto)
                .toList();

    }
}