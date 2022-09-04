package StackCalc;

public enum Operation {

    PLUS('+'),
    MINUS('-'),
    DIVISION('/'),
    MULTIPLY('*');

    private char operationSymbol;

    public char getOperationSymbol() {
        return operationSymbol;
    }

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;

    }

    public static Operation getOperationBySymbol(char operationSymbol) {
        for (Operation operation : values()) {
            if (operation.operationSymbol == operationSymbol) {
                return operation;
            }
        }
        return null;
    }
}

