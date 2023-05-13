package model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class Account {
    private final ArrayList<Operation> operations;
    private double balance;


    public Account(){
        operations = new ArrayList<>();
        balance = 0.0;
    }

    public void deposit(Operation operation) {
        operations.add(operation);
        increaseAmount(operation.getAmount());
    }
    private void increaseAmount(Double amount){
        balance += amount;
    }

    public List<Operation> getOperationsBySpecificDate(LocalDate date) {
        return getOperationsByFilter(operation -> operation.getDate().equals(date));
    }

    public List<Operation> getOperationsBeforeDate(LocalDate date) {
        return getOperationsByFilter(operation -> operation.getDate().isBefore(date));
    }

    public List<Operation> getOperationsAfterDate(LocalDate date) {
        return getOperationsByFilter(operation -> operation.getDate().isAfter(date));
    }

    private List<Operation> getOperationsByFilter(Predicate<Operation> predicate){
        return operations
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public String showHistory(){
        TreeMap<Operation, Double> history = generateHistory();
        return history
                .entrySet()
                .stream()
                .map(operationDoubleEntry -> String.format("%s - balance = %.2f$\n", operationDoubleEntry.getKey(), operationDoubleEntry.getValue()))
                .collect(Collectors.joining(","));
    }

    private TreeMap<Operation, Double> generateHistory(){
        operations.sort(Collections.reverseOrder());
        TreeMap<Operation, Double> history = new TreeMap<>();
        double balance = 0.0;
        for(Operation operation: operations) {
            balance += operation.getAmount();
            history.put(operation, balance);
        }
        return history;
    }
}
