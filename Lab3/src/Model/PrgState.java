package Model;

import Model.MyADTs.MyIDictionary;
import Model.MyADTs.MyIList;
import Model.MyADTs.MyIStack;
import Model.Statements.IStmt;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String,Integer> symTable;
    private MyIList<Integer> out;
    private IStmt originalProgram;
    private MyIDictionary<Integer, MyPair<String, BufferedReader>> fileTable;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Integer> symtbl, MyIList<Integer> ot, IStmt prg, MyIDictionary<Integer, MyPair<String, BufferedReader>> filetbl){
        exeStack = stk;
        symTable = symtbl;
        out = ot;
        originalProgram = prg;
        //originalProgram = deepCopy(prg);
        fileTable = filetbl;
        stk.push(prg);
    }

    @Override
    public String toString() {
        return  "STACK: " + exeStack.toString() + "\n" +
                "SYM TB: " + symTable.toString() + "\n" +
                "OUTPUT: " + out.toString() + "\n" +
                "FILE TB: " + fileTable.toString() + "\n";
                //", originalProgram=" + originalProgram;
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }

    public MyIDictionary<Integer, MyPair<String, BufferedReader>> getFileTable() { return fileTable; }

    public void setFileTable(MyIDictionary<Integer, MyPair<String, BufferedReader>> fileTable) { this.fileTable = fileTable; }
}
