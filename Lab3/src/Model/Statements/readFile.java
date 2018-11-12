package Model.Statements;

import Model.Expressions.Exp;
import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;
import Model.MyPair;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.IOException;

public class readFile implements IStmt {
    Exp expression_file;
    String var_name;

    public readFile(Exp exp_file, String var_name) {
        this.expression_file = exp_file;
        this.var_name = var_name;
    }

    @Override
    public String toString(){
        return "readFile(" + expression_file.toString() + ", " + var_name + ")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        MyIDictionary<Integer, MyPair<String, BufferedReader>> flTable = state.getFileTable();

        int val_file_descr;
        try{
            val_file_descr = expression_file.evaluate(symTable);        }
        catch (MyException e){
            throw e;}

        if (!(flTable.isDefined(val_file_descr))) {
            throw new MyException("There is no file with such a file descriptor");
        }

        BufferedReader br = (flTable.lookup(val_file_descr)).getValue();
        String str;
        try {
            str = br.readLine();
        }
        catch (IOException e ) {throw new MyException("Couldn't read from file, error: " + e.getMessage());
        }

        int var_value;
        if(str == null)
            var_value = 0;
        else
            var_value = Integer.parseInt(str);

        if(symTable.isDefined(var_name))
            symTable.update(var_name,var_value);
        else
            symTable.put(var_name,var_value);

        return state;
    }
}

