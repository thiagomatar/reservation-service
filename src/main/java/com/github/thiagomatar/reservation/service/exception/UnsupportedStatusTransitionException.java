package com.github.thiagomatar.reservation.service.exception;

import com.github.thiagomatar.reservation.model.status.ReservationStatus;

public class UnsupportedStatusTransitionException extends RuntimeException {
    public UnsupportedStatusTransitionException(ReservationStatus status) {
        super("Cannot update status to: " + status);
    }
}
