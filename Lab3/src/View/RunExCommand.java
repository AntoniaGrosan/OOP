package View;

import Controller.Control;
import Model.MyADTs.MyException;

public class RunExCommand extends Command {
    private Control ctrl;

    public RunExCommand(String key, String description, Control ctr) {
        super(key, description);
        this.ctrl = ctr;
    }

    @Override
    public void execute() {
        String result = "";
        try {
            ctrl.allSteps();
        } catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
