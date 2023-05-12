package model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Operation {

    private double amount;
    private LocalDate date;
    private double balance;

    public Operation(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
        this.balance += amount;
    }

    @Override
    public String toString(){
        return String.format("amount = %.2f$ - date = %s - balance = %.2f$\n",
                this.amount, this.date, this.balance);
    }
}
