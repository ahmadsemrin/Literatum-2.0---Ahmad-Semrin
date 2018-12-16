package web_app_design.action;

import web_app_design.util.FileUtil;

public class ActionValidateFileWithDTDUsingDOM implements IAction {
    @Override
    public Object doAction(Object object) {
        String xml = (String) object;

        return FileUtil.isValidJATS(xml);
    }
}
