package Model.Statements;

import Model.Expressions.Exp;
import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyADTs.MyIList;
import Model.PrgState;


public class PrintStmt implements IStmt {
    Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return " print(" + exp.toString() + ")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIList<Integer> out = state.getOut();
        MyIDictionary<String,Integer> table = state.getSymTable();
        out.add(exp.evaluate(table));
        return state;
    }
}
