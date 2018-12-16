package web_app_design.action;

public class ActionContext {
    private IAction action;

    public ActionContext(IAction action) {
        this.action = action;
    }

    public Object executeAction(Object object) {
        return action.doAction(object);
    }
}
