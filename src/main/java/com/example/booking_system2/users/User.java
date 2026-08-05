package com.example.booking_system2.users;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    UUID userId;
    @Column(name = "email")
    String email;
    @Column(name = "countBooking")
    int countBooking;
    @Column(name = "balance")
    int balance;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountBooking(int countBooking) {
        this.countBooking = countBooking;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCountBooking() {
        return countBooking;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return balance;
    }

    public UUID getId() {
        return userId;
    }
       public abstract int privilege(int priceOfTicket);
}
