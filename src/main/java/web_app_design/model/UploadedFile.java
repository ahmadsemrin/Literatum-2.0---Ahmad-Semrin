package web_app_design.model;

import java.io.Serializable;

public class UploadedFile implements Serializable {
    private String name;
    private String email;
    private String file;
    private String date;
    private String status;
    private String extractedFile;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFile() {
        return file;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getExtractedFile() {
        return extractedFile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExtractedFile(String extractedFile) {
        this.extractedFile = extractedFile;
    }
}
