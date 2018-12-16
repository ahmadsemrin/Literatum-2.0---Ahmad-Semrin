package web_app_design.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import web_app_design.action.*;
import web_app_design.controller.FrontControllerServlet;
import web_app_design.enums.Attribute;
import web_app_design.model.*;
import web_app_design.model.data_access_object.file.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public final class AccessControlUtil {
    private static IFileDAO fileDAO;
    private static List<UploadedFile> uploadedFiles;

    public static boolean isBasicUser(User user) {
        return StringUtil.areStringsEqual( "basic", user.getRole());
    }

    public static boolean isAdmin(User user) {
        return StringUtil.areStringsEqual( "admin", user.getRole());
    }

    public static boolean isSuperAdmin(User user) {
        return StringUtil.areStringsEqual( "super", user.getRole());
    }

    public static void uploadFile(User user, HttpServletRequest request) {
        if (isAdmin(user) || isSuperAdmin(user)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

            List<FileItem> multiFiles = null;
            try {
                multiFiles = servletFileUpload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            ActionContext actionContext = new ActionContext(new ActionUploadFile());
            actionContext.executeAction(multiFiles);


            fileDAO = FileDAO.getInstance();
            uploadedFiles = fileDAO.findAll();

            AttributeUtil.setAttribute(Attribute.UPLOADED_FILES_ATTRIBUTE.getAttribute(), uploadedFiles, request);
        }
    }

    public static void viewUploadedFiles(User user, HttpServletRequest request) {
        if (isAdmin(user) || isSuperAdmin(user)) {
            fileDAO = FileDAO.getInstance();
            uploadedFiles = fileDAO.findAll();

            AttributeUtil.setAttribute(Attribute.UPLOADED_FILES_ATTRIBUTE.getAttribute(), uploadedFiles, request);
        }
    }

    public static void viewArticles(User user, HttpServletRequest request) {
        if (isBasicUser(user)) {
            AttributeUtil.setAttribute(Attribute.ARTICLES_ATTRIBUTE.getAttribute(), FrontControllerServlet.articleList,
                    request);
        }
    }
}
