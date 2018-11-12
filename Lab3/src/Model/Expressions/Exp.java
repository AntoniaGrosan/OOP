package Model.Expressions;

import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;

public abstract class Exp {
    public abstract int evaluate(MyIDictionary<String,Integer> syTable) throws MyException;
}