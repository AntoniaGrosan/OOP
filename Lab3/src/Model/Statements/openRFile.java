package Model.Statements;

import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyPair;
import Model.PrgState;

import java.io.*;

public class openRFile implements IStmt {
    String var_file_id;
    String filename;
    int crtFD = 1;

    public openRFile(String var_file_id, String filename) {
        this.var_file_id = var_file_id;
        this.filename = filename;
    }

    @Override
    public String toString(){
        return "openRFile(" + var_file_id + ",' " + filename + "')";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<Integer, MyPair<String, BufferedReader>> fileTb = state.getFileTable();
        MyIDictionary<String, Integer> symTb = state.getSymTable();

        for (int i = 1; i <= crtFD; i++){
            if ( (fileTb.isDefined(i)) && (((fileTb.lookup(i)).getValue()).equals(filename)) )
                throw new MyException("The file is already opened");
        }

        BufferedReader tryopen = null;
        try {
            tryopen = new BufferedReader(new FileReader(filename));
        }
        catch (IOException e) {
            throw new MyException("Error at opening the file: " + e.getMessage());
        }

        crtFD = crtFD + 1;
        MyPair<String, BufferedReader> per = new MyPair<String,BufferedReader>(filename,tryopen);

        fileTb.put(crtFD, per);
        symTb.put(var_file_id, crtFD);

        return state;
    }
}
