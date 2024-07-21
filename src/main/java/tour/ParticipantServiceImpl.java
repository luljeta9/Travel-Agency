package tour;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final TourRepository tourRepository;
    private final ParticipantRepository participantRepository;

    public ParticipantServiceImpl(TourRepository tourRepository, ParticipantRepository participantRepository) {
        this.tourRepository = tourRepository;
        this.participantRepository = participantRepository;
    }

    public Participant addParticipant(Long tourId, Participant participant) {
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        participant.setTour(tour);
        return participantRepository.save(participant);
    }

    public void removeParticipant(Long participantId) {
        participantRepository.deleteById(participantId);
    }

    public List<Participant> getParticipantsByTourId(Long tourId) {
        return participantRepository.findByTourId(tourId);
    }

}
