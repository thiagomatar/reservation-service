package com.github.thiagomatar.reservation.model.status;

import com.github.thiagomatar.reservation.model.Reservation;

public enum ReservationStatus implements ReservationStatusOperations {
    NEW(new New()),
    ACCEPTED(new Accepted()),
    PAID(new Paid()),
    MAINTENANCE(new Maintenance()),
    CANCELLED(new Cancelled());

    private final ReservationStatusOperations operations;

    ReservationStatus(ReservationStatusOperations operations) {
        this.operations = operations;
    }

    @Override
    public ReservationStatus available(Reservation reservation) {
        return operations.available(reservation);
    }

    @Override
    public ReservationStatus accept(Reservation reservation) {
        return operations.accept(reservation);
    }

    @Override
    public ReservationStatus charge(Reservation reservation) {
        return operations.charge(reservation);
    }

    @Override
    public ReservationStatus maintenance(Reservation reservation) {
        return operations.maintenance(reservation);
    }

    @Override
    public ReservationStatus cancel(Reservation reservation) {
        return operations.cancel(reservation);
    }
}
