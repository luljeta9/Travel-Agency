package tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public Participant addParticipant(Long tourId, Participant participant) {
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        participant.setTour(tour);
        return participantRepository.save(participant);
    }

    @Override
    public void removeParticipant(Long participantId) {
        participantRepository.deleteById(participantId);
    }

    @Override
    public List<Participant> getParticipantsByTourId(Long tourId) {
        return participantRepository.findByTourId(tourId);
    }


}

