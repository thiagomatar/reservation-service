package com.github.thiagomatar.reservation.model;

import com.github.thiagomatar.reservation.model.status.ReservationStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Slf4j
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Column(name = "reservation_date")
    private LocalDate date;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status = ReservationStatus.NEW;

    public void available() {
        setStatus(status.available(this));
    }

    public void accept() {
        setStatus(status.accept(this));
    }

    public void charge() {
        setStatus(status.charge(this));
    }

    public void cancel() {
        setStatus(status.cancel(this));
    }

    public void maintenance() {
        setStatus(status.maintenance(this));
    }

    private void setStatus(ReservationStatus status) {
        if (status != null && status != this.status) {
            log.debug("Reservation#{}: changing status from {}  to {}", id, this.status, status);
            this.status = status;
        }
    }
}