package model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Account {
    private ArrayList<Operation> operations;
    private double balance;

    public Account(){
        operations = new ArrayList<>();
    }

    public void deposit(Operation operation) {
        operations.add(operation);
        balance += operation.getAmount();
    }


    public List<Operation> getOperationsBySpecificDate(LocalDate date) {
       return operations
                .stream()
                .filter(operation -> operation.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Operation> getOperationsBefore(LocalDate date) {
        return operations
                .stream()
                .filter(operation -> operation.getDate().isBefore(date))
                .collect(Collectors.toList());
    }

    public List<Operation> getOperationsAfter(LocalDate date) {
        return operations
                .stream()
                .filter(operation -> operation.getDate().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return "***** Account ***** \n" + "balance : " + this.getBalance()
                + "$\noperations : " + this.getOperations().toString() + "\n";
    }
}
