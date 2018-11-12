package Repository;

import Model.MyADTs.MyException;
import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Repo implements IRepo {
    PrgState state;
    String logFilePath;

    public Repo(PrgState state, String lfp) {
        this.state = state;
        this.logFilePath = lfp;
    }

    @Override
    public PrgState getCrtProg() {
        return this.state;
    }

    @Override
    public void logPrgStateExec() throws MyException {
        try {
            BufferedWriter logFile = new BufferedWriter(new FileWriter(logFilePath, true));
            logFile.append("STACK: " + state.getExeStack().toString());
            logFile.newLine();
            logFile.append("SYM TB: " + state.getSymTable().toString());
            logFile.newLine();
            logFile.append("OUTPUT: " + state.getOut().toString());
            logFile.newLine();
            logFile.append("FILE TB: " + state.getFileTable().toString());
            logFile.newLine();
            logFile.append("-----------------------------------------------------");
            logFile.newLine();
            logFile.close();
        }
        catch (java.io.IOException e) {
            throw new MyException(e.getMessage());
        }
    }

}
