package Repository;

import Model.MyADTs.MyException;
import Model.PrgState;

public interface IRepo {
    PrgState getCrtProg();
    void logPrgStateExec() throws MyException;
}
