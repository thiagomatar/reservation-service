package com.github.thiagomatar.reservation.service;

import com.github.thiagomatar.reservation.model.Reservation;
import com.github.thiagomatar.reservation.model.status.ReservationStatus;
import com.github.thiagomatar.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Reservation findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation Not Found"));
    }

    public Reservation updateStatus(Long id, ReservationStatus status) {
        Reservation reservation = this.findById(id);

        switch (status) {
            case NEW:
                reservation.available();
                break;
            case PAID:
                reservation.charge();
                break;
            case ACCEPTED:
                reservation.accept();
                break;
            case MAINTENANCE:
                reservation.maintenance();
                break;
            case CANCELLED:
                reservation.cancel();
                break;
        }

        return this.repository.save(reservation);
    }

}
