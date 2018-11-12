package Model.Expressions;

import Model.MyADTs.MyIDictionary;

public class ConstExp extends Exp {
    int number;

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public ConstExp(int number) {
        this.number = number;
    }

    @Override
    public int evaluate(MyIDictionary<String, Integer> table) {
        return number;
    }
}
