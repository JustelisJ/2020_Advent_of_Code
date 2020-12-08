package com.adventofcode.day8;

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
        }

        return acc;
    }

    public int changingOneOperation(List<Operation> operationList, int changeCount) {
        int acc = 0;
        boolean[] usedOperations = new boolean[operationList.size()];
        int i = 0;
        int changedPosition = 0;
        while (i < operationList.size()) {
            if (!usedOperations[i]) {
                if (changedPosition == changeCount && operationList.get(i).getOperation().equals("nop")) {
                    operationList.get(i).setOperation("jmp");
                }
                if (changedPosition == changeCount && operationList.get(i).getOperation().equals("jmp")) {
                    operationList.get(i).setOperation("nop");
                }
                switch (operationList.get(i).getOperation()) {
                    case "acc":
                        acc += operationList.get(i).getValue();
                        usedOperations[i] = true;
                        i++;
                        break;
                    case "jmp":
                        changedPosition++;
                        usedOperations[i] = true;
                        i += operationList.get(i).getValue();
                        break;
                    case "nop":
                        changedPosition++;
                        usedOperations[i] = true;
                        i++;
                        break;
                }
            } else {
                changingOneOperation(operationList, changeCount + 1);
                System.out.println("new");
            }
        }

        return acc;
    }
}
