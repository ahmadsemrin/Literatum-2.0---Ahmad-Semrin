package web_app_design.action;

import web_app_design.enums.Directory;
import web_app_design.model.Article;
import web_app_design.util.FileUtil;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.*;

public class ActionTransformFileToXSLT implements IAction {
    @Override
    public Object doAction(Object object) {
        String fileName = (String) object;

        Source xslt = new StreamSource(new File(Directory.JATS_XSLT_PATH.getDirectory()));

        List<File> files = FileUtil.getFilesFromFolder(new File(
                Directory.UPLOADED_FILES_PATH.getDirectory() + File.separator + fileName));

        File xml = FileUtil.findJATS(files);
        Source text = new StreamSource(Objects.requireNonNull(xml));

        File newFile = FileUtil.toXSLT(xslt, xml, text);

        System.out.println("Transformed!");

        String title = FileUtil.getArticleTitle(xml);

        Article article = new Article();
        article.setArticleName(newFile.getName());
        article.setTitle(title);
        article.setPublishDate(new Date());
        article.setPrice(0);

        return article;
    }
}
