package al.sda.demo.participant.controller;

import al.sda.demo.airport.model.AirportDto;
import al.sda.demo.airport.service.AirportService;
import al.sda.demo.participant.model.ParticipantDto;
import al.sda.demo.participant.service.ParticipantService;
import al.sda.demo.util.RestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/participants")

public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDto> getParticipantById(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> getList(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(participantService.getList(page, size));
    }

    @PostMapping
    public ResponseEntity<Void> saveParticipant(ParticipantDto participant) {
        Long id = participantService.saveParticipant(participant);
        URI location = RestUtil.locationBuilder(id.toString());

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParticipant(@PathVariable Long id, ParticipantDto participant) {
        participantService.updateParticipant(id, participant);
        return ResponseEntity.noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.noContent()
                .build();
    }
}
