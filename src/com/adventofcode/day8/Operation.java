package com.adventofcode.day8;

import java.util.ArrayList;
import java.util.List;

public class Operation {

    String operation;
    int value;

    public Operation(String operation, int value) {
        this.operation = operation;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public int getValue() {
        return value;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation='" + operation + '\'' +
                ", value=" + value +
                '}';
    }

    public int calculateTheAcc(List<Operation> operationList) {
        int acc = 0;
        boolean[] usedOperations = new boolean[operationList.size()];
        int i = 0;
        while (!usedOperations[i]) {
            switch (operationList.get(i).getOperation()) {
                case "acc":
                    acc += operationList.get(i).getValue();
                    usedOperations[i] = true;
                    i++;
                    break;
                case "jmp":
                    usedOperations[i] = true;
                    i += operationList.get(i).getValue();
                    break;
                case "nop":
                    usedOperations[i] = true;
                    i++;
                    break;
            }
            if (i >= operationList.size()) {
                return acc;
            }
        }

        return -1;
    }

    public int changingOneOperation(List<Operation> operationList) {
        int acc = 0;
        int i = 0;
        while (i < operationList.size()) {
            Operation currentOperational = operationList.get(i);
            String original = currentOperational.getOperation();
            if (currentOperational.getOperation().equals("nop")) {
                List<Operation> operationListCopied = new ArrayList<>(operationList);
                currentOperational.setOperation("jmp");
                int sum = calculateTheAcc(operationListCopied);
                if (sum != -1)
                    return sum;
            }
            if (currentOperational.getOperation().equals("jmp")) {
                List<Operation> operationListCopied = new ArrayList<>(operationList);
                currentOperational.setOperation("nop");
                int sum = calculateTheAcc(operationListCopied);
                if (sum != -1)
                    return sum;
            }
            i++;
            currentOperational.setOperation(original);
        }

        return acc;
    }
}
