package tour;

import java.util.List;

public interface ParticipantService {

    Participant addParticipant(Long tourId, Participant participant);

    void removeParticipant(Long participantId);

    List<Participant> getParticipantsByTourId(Long tourId);


}

