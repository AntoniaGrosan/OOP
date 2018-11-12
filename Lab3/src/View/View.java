package View;

import Controller.Control;
import Model.MyADTs.MyException;

public class View {
    private Control ctrl;

    public View(Control ctrl) {
        this.ctrl = ctrl;
    }

    public void startApp(){
        try {
            System.out.println(ctrl.allSteps_First());
            //System.out.println(ctrl.allSteps());
        } catch (MyException e) {System.out.println(e.getMessage()); }
    }
}
