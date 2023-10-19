package org.example.model.entities;

import org.example.model.exceptions.DomainException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        this.roomNumber = roomNumber;
        this.updateDates(checkIn, checkOut);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }


    public long duration() {
        long diff =  this.checkOut.getTime() - this.checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("The days of reservation need to be a future reservation");
        }
        if(checkOut.before(checkIn)) {
            throw new DomainException("The check-out date need to be after check-in");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: Room " + this.roomNumber +
                ", Check-in: " + dateFormat.format(this.checkIn) +
                ", Check-out: " + dateFormat.format(this.checkOut) +
                ", " + this.duration() + " night(s)";
    }
}

