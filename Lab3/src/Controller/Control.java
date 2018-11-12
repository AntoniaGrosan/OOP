package Controller;

import Model.MyADTs.MyException;
import Model.MyADTs.MyIStack;
import Model.PrgState;
import Model.Statements.IStmt;
import Repository.IRepo;

public class Control {
    private IRepo repo;

    public Control(IRepo repo) {
        this.repo = repo;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        MyIStack<IStmt> stack = state.getExeStack();
        if (stack.isEmpty())
            throw new MyException("Empty stack");
        IStmt crtStmt = stack.pop();
        return crtStmt.execute(state);
    }

    public String allSteps_First() throws MyException{
        PrgState progr = repo.getCrtProg();
        String result = "";
        try {
            while (true) {
                oneStep(progr);
                result = result + progr.toString() + "\n";
            }
        } catch (MyException e) {
            result = result + e.getMessage() + "\n";
        }
        return result;
    }

    public void allSteps() throws MyException{
        PrgState progr = repo.getCrtProg();
        while (true) {
            oneStep(progr);
            repo.logPrgStateExec();
        }
    }
}
