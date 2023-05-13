package model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Operation implements Comparable<Operation>{

    private double amount;
    private LocalDate date;

    public Operation(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString(){
        return String.format("amount = %.2f$ - date = %s",
                this.amount, this.date);
    }

    @Override
    public int compareTo(Operation o) {
        return o.getDate().compareTo(getDate());
    }
}
