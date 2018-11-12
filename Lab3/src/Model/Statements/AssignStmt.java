package Model.Statements;

import Model.Expressions.Exp;
import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyADTs.MyIStack;
import Model.PrgState;


public class AssignStmt implements IStmt {
    String id;
    Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return " " + id + " = " + exp.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk = state.getExeStack();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        int val = exp.evaluate(symTbl);

        if(symTbl.isDefined(id))
            symTbl.update(id,val);
        else
            symTbl.put(id,val);

        return state;
    }
}
