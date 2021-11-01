package com.github.thiagomatar.reservation.model.status;


import com.github.thiagomatar.reservation.model.Reservation;
import com.github.thiagomatar.reservation.service.exception.UnsupportedStatusTransitionException;

public class Paid implements ReservationStatusOperations{

    @Override
    public ReservationStatus available(Reservation reservation) {
        throw new UnsupportedStatusTransitionException(ReservationStatus.NEW);
    }

    @Override
    public ReservationStatus accept(Reservation reservation) {
        throw new UnsupportedStatusTransitionException(ReservationStatus.ACCEPTED);
    }

    @Override
    public ReservationStatus charge(Reservation reservation) {
        throw new UnsupportedStatusTransitionException(ReservationStatus.PAID);
    }

    @Override
    public ReservationStatus maintenance(Reservation reservation) {
        throw new UnsupportedStatusTransitionException(ReservationStatus.MAINTENANCE);
    }

    @Override
    public ReservationStatus cancel(Reservation reservation) {
        return ReservationStatus.CANCELLED;
    }
}
