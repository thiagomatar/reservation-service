package com.github.thiagomatar.reservation.resource;

import com.github.thiagomatar.reservation.model.Reservation;
import com.github.thiagomatar.reservation.model.status.ReservationStatus;
import com.github.thiagomatar.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationResource {

    private final ReservationService service;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reservation findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PutMapping("/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public Reservation update(@PathVariable Long id, @PathVariable ReservationStatus status) {
        return this.service.updateStatus(id, status);
    }
}
