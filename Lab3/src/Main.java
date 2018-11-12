import Controller. *;
import Model.Expressions. *;
import Model.MyADTs. *;
import Model.MyPair;
import Model.Statements. *;
import Repository. *;
import View. *;
import Model.PrgState;

import java.io.BufferedReader;

public class Main {
    public static void main(String args[]){
        //v=2;Print(v)
        IStmt ex1 = new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new VarExp("v")));

        //a=2+3*5;b=a+1;Print(b)
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp(1, new ConstExp(2),
                new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b", new ArithExp(1,new VarExp("a"),new ConstExp(1))),
                        new PrintStmt(new VarExp("b"))));

        //a=2-2;(If a Then v=2 Else v=3);Print(v);
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp(2,new ConstExp(2), new ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));

        //a=2+3*5;b=c+1;Print(b) => exception
        IStmt ex4 = new CompStmt(new AssignStmt("a", new ArithExp(1, new ConstExp(2),
                new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b", new ArithExp(1,new VarExp("c"),new ConstExp(1))),
                        new PrintStmt(new VarExp("b"))));

        //a=2+3/0;b=a+1;Print(b) => exception
        IStmt ex5 = new CompStmt(new AssignStmt("a", new ArithExp(1, new ConstExp(2),
                new ArithExp(4,new ConstExp(3), new ConstExp(0)))),
                new CompStmt(new AssignStmt("b", new ArithExp(1,new VarExp("c"),new ConstExp(1))),
                        new PrintStmt(new VarExp("b"))));

        /*
        openRFile(var_f,"test.in");
        readFile(var_f,var_c);print(var_c);
        (if var_c then readFile(var_f,var_c);print(var_c)
        else print(0));
        closeRFile(var_f)
         */
        IStmt ex61 = new CompStmt(new openRFile("var_f","C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\test.txt"),
                    new CompStmt(new readFile(new VarExp("var_f"),"var_c"), new PrintStmt(new VarExp("var_c"))));

        IStmt ex62 = new CompStmt(
                new IfStmt(new VarExp("var_c"), new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),
                new closeRFile(new VarExp("var_f")));

        IStmt ex6 = new CompStmt(ex61,ex62);

        /*
        openRFile(var_f,"test.in");
        readFile(var_f+2,var_c);print(var_c);
        (if var_c then readFile(var_f,var_c);print(var_c)
        else print(0));
        closeRFile(var_f)
         */
        IStmt ex71 = new CompStmt(new openRFile("var_f","C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\test.txt"),
                new CompStmt(new readFile(new ArithExp(1,new VarExp("var_f"),new ConstExp(2)),"var_c"),
                        new PrintStmt(new VarExp("var_c"))));

        IStmt ex72 = new CompStmt(
                new IfStmt(new VarExp("var_c"), new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),
                new closeRFile(new VarExp("var_f")));

        IStmt ex7 = new CompStmt(ex71,ex72);

        MyStack<IStmt> stk = new MyStack<IStmt>();
        MyDictionary<String,Integer> syTbl = new MyDictionary<String,Integer>();
        MyList<Integer> list = new MyList<Integer>();
        MyDictionary<Integer, MyPair<String, BufferedReader>> flTbl = new MyDictionary<>();

        PrgState programState1 = new PrgState(stk,syTbl,list,ex1,flTbl);
        IRepo repo1 = new Repo(programState1,"C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\ex1.txt");
        Control controller1 = new Control(repo1);

        MyStack<IStmt> stk2 = new MyStack<IStmt>();
        MyDictionary<String,Integer> syTbl2 = new MyDictionary<String,Integer>();
        MyList<Integer> list2 = new MyList<Integer>();
        MyDictionary<Integer, MyPair<String, BufferedReader>> flTbl2 = new MyDictionary<>();

        PrgState programState2 = new PrgState(stk2,syTbl2,list2,ex2,flTbl2);
        IRepo repo2 = new Repo(programState2,"C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\ex2.txt");
        Control controller2 = new Control(repo2);

        MyStack<IStmt> stk3 = new MyStack<IStmt>();
        MyDictionary<String,Integer> syTbl3 = new MyDictionary<String,Integer>();
        MyList<Integer> list3 = new MyList<Integer>();
        MyDictionary<Integer, MyPair<String, BufferedReader>> flTbl3 = new MyDictionary<>();

        PrgState programState3 = new PrgState(stk3,syTbl3,list3,ex3,flTbl3);
        IRepo repo3 = new Repo(programState3,"C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\ex3.txt");
        Control controller3 = new Control(repo3);

        MyStack<IStmt> stk4 = new MyStack<IStmt>();
        MyDictionary<String,Integer> syTbl4 = new MyDictionary<String,Integer>();
        MyList<Integer> list4 = new MyList<Integer>();
        MyDictionary<Integer, MyPair<String, BufferedReader>> flTbl4 = new MyDictionary<>();

        PrgState programState6 = new PrgState(stk4,syTbl4,list4,ex6,flTbl4);
        IRepo repo6 = new Repo(programState6,"C:\\Users\\anton\\Desktop\\Tia\\Facultate\\An2 sem1\\MAP\\ex4.txt");
        Control controller6 = new Control(repo6);

        //View myApp = new View(controller);
        //myApp.startApp();

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExCommand("1",ex1.toString(),controller1));
        menu.addCommand(new RunExCommand("2",ex2.toString(),controller2));
        menu.addCommand(new RunExCommand("3",ex3.toString(),controller3));
        menu.addCommand(new RunExCommand("4",ex6.toString(),controller6));
        menu.show();

    }
}
