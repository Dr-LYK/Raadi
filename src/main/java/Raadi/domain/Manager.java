package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Manager
{
    private HashSet<String> linksTodo;
    private HashSet<String> linksDone;
    private ArrayList<DocumentRaw> documentRawList;
    private ArrayList<DocumentClean> documentCleanList;

    private Manager() {
        this.linksTodo = new HashSet<>();
        this.linksDone = new HashSet<>();
        this.documentRawList = new ArrayList<>();
        this.documentCleanList = new ArrayList<>();
    }

    private static class ManagerHolder {
        private final static Manager instance = new Manager();
    }

    public static Manager getInstance() {
        return ManagerHolder.instance;
    }

    private void crawl() {
        for (String url : linksTodo) {
            if (!linksDone.contains(url)) {
                documentRawList.add(Crawler.crawl(url));
                linksTodo.remove(url);
                linksDone.add(url);
            }
        }
    }

    private void cleanup() {
        for (DocumentRaw documentRaw : documentRawList) {
            documentCleanList.add(CleanUp.cleanup(documentRaw));
            documentRawList.remove(documentRaw);
        }
    }
}
