package Model.Statements;

import Model.MyADTs.MyException;
import Model.PrgState;

public interface IStmt {
    @Override
    String toString();

    PrgState execute(PrgState state) throws MyException;
}
