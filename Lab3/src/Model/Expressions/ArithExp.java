package Model.Expressions;

import Model.MyADTs.MyException;
import Model.MyADTs.MyIDictionary;

public class ArithExp extends Exp {
    Exp e1;
    Exp e2;
    int oper;

    public ArithExp( int oper, Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.oper = oper;
    }

    @Override
    public String toString() {
        String op;
        switch (oper){
            case 1:
                op = "+";
                break;
            case 2:
                op = "-";
                break;
            case 3:
                op = "*";
                break;
            case 4:
                op = "/";
                break;
            default:
                op = "?";
                break;
        }
        return e1.toString() + op + e2.toString();
    }

    public int evaluate(MyIDictionary<String, Integer> syTable) throws MyException {
        switch (oper){
            case 1:
                return (e1.evaluate(syTable) + e2.evaluate(syTable));
            case 2:
                return (e1.evaluate(syTable) - e2.evaluate(syTable));
            case 3:
                return (e1.evaluate(syTable) * e2.evaluate(syTable));
            case 4:
                if(e2.evaluate(syTable) == 0)
                    throw new MyException("Division by zero");
                return (e1.evaluate(syTable) / e2.evaluate(syTable));
        }

        return 0;
    }
}
