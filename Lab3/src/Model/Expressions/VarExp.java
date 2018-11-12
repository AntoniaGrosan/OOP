package Model.Expressions;

import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;

public class VarExp extends Exp {
    String id;

    @Override
    public String toString() {
        return id;
    }

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public int evaluate(MyIDictionary<String, Integer> table) throws MyException {
        if(table.lookup(id) == null)
            throw new MyException("Variable " + id + " not defined");
        else
            return table.lookup(id);
    }
}
