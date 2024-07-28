package al.sda.demo.participant.mapper;
import al.sda.demo.participant.model.Participant;
import al.sda.demo.participant.model.ParticipantDto;


public class ParticipantMapper {
    public static ParticipantDto toDto(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setId(participant.getId());
        participantDto.setName(participant.getName());
        participantDto.setAge(participant.getAge());
        participantDto.setGender(participant.getGender());
        participantDto.setTour(participant.getTour());
        return participantDto;
    }
    public static Participant toEntity(ParticipantDto participantDto){
        Participant participant = new Participant();
        participant.setId(participantDto.getId());
        participant.setName(participantDto.getName());
        participant.setAge(participantDto.getAge());
        participant.setGender(participantDto.getGender());
        participant.setTour(participantDto.getTour());
        return participant;
    }
}
