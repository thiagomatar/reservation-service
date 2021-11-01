package com.github.thiagomatar.reservation.model.status;


import com.github.thiagomatar.reservation.model.Reservation;

public interface ReservationStatusOperations {
    ReservationStatus available(Reservation reservation);
    ReservationStatus accept(Reservation reservation);
    ReservationStatus charge(Reservation reservation);
    ReservationStatus maintenance(Reservation reservation);
    ReservationStatus cancel(Reservation reservation);
}
