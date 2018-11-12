package Model.Statements;

import Model.Expressions.Exp;
import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyPair;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStmt {
    Exp exp_file_id;

    public closeRFile(Exp exp_file_id) {
        this.exp_file_id = exp_file_id;
    }

    @Override
    public String toString(){
        return "closeRFile(" + exp_file_id.toString() + ")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        MyIDictionary<Integer, MyPair<String, BufferedReader>> flTable = state.getFileTable();

        int value;
        try{
            value = exp_file_id.evaluate(symTable); }
        catch (MyException e){
            throw e;  }

        if (!(flTable.isDefined(value))) {
            throw new MyException("There is no file with such a file descriptor");
        }

        BufferedReader br = (flTable.lookup(value)).getValue();
        try{
            br.close();
        }catch (IOException e){
            throw new MyException("Couldn't close the file, error: " + e.getMessage());
        }

        flTable.remove(value);

        return state;
    }
}
