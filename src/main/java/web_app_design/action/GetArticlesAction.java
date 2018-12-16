package web_app_design.action;

import web_app_design.enums.Directory;

import java.io.File;
import java.util.Arrays;

public class GetArticlesAction implements IAction {
    @Override
    public Object doAction(Object object) {
        File articlesFile = new File(Directory.ARTICLES_PATH.getDirectory());
        File[] articles = articlesFile.listFiles();

        return Arrays.asList(articles);
    }
}
