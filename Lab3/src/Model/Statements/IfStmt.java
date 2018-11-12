package Model.Statements;

import Model.Expressions.Exp;
import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyADTs.MyIStack;
import Model.PrgState;

public class IfStmt implements IStmt {
    Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp exp, IStmt thenS, IStmt elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public String toString() {
        return " IF(" + exp.toString() + ")  THEN(" + thenS.toString() + ")  ELSE(" + elseS.toString() + ")";
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String,Integer> table = state.getSymTable();
        MyIStack<IStmt> stk = state.getExeStack();
        try {
            if (exp.evaluate(table) != 0)
                stk.push(thenS);
            else
                stk.push(elseS);
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return state;
    }
}
