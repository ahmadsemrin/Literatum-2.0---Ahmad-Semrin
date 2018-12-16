package web_app_design.action;

import org.apache.commons.fileupload.FileItem;
import web_app_design.util.FileUtil;

import java.util.List;

public class ActionUploadFile implements IAction {
    @Override
    public Object doAction(Object object) {
        List<FileItem> files = (List<FileItem>) object;

        FileUtil.uploadFiles(files);

        System.out.println("File uploaded");

        return null;
    }
}
