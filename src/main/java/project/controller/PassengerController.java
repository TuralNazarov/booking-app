package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.dto.PassengersDto;
import project.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengerController")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<PassengersDto>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengersDto> getPassengerById(@PathVariable long id) {
        return ResponseEntity.ok(passengerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PassengersDto> createPassenger(@RequestBody PassengersDto passengersDto) {
        passengerService.save(passengersDto);
        return ResponseEntity.ok(passengersDto);
    }

    @PutMapping
    public ResponseEntity<PassengersDto> updatePassenger(@RequestBody PassengersDto passengersDto) {
        return ResponseEntity.ok(passengerService.update(passengersDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable long id) {
        passengerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PassengersDto>> searchPassengers(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long id) {
        return ResponseEntity.ok(passengerService.search(firstName, lastName, id));
    }
}