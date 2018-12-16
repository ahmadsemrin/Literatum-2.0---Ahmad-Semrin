package web_app_design.model.data_access_object.file;

import web_app_design.model.UploadedFile;

import java.util.List;

public interface IFileDAO {
    List<UploadedFile> findAll();
    void insertFile(UploadedFile file);
    void deleteFile(UploadedFile file);
}
