package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;
import Raadi.util.Converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Manager
{
    private HashSet<String> stopWords;
    private HashSet<String> linksTodo;
    private HashSet<String> linksDone;
    private ArrayList<DocumentRaw> documentRawList;
    private ArrayList<DocumentClean> documentCleanList;

    HashMap<String, ArrayList<DocumentClean>> retroIndex;


    private Manager() {
        this.linksTodo = new HashSet<>();
        this.linksDone = new HashSet<>();
        this.documentRawList = new ArrayList<>();
        this.documentCleanList = new ArrayList<>();
        this.stopWords = Converter.StopWordsJsonToHashSet();
    }

    public HashSet<String> getStopWords() {
        return stopWords;
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

    public void fillRetroIndex() {
        for (DocumentClean dc : documentCleanList) {
            for (String key : dc.getVector().keySet()) {
                ArrayList<DocumentClean> value = new ArrayList<>();
                if (retroIndex.containsKey(key))
                    value = retroIndex.get(key);
                value.add(dc);
                retroIndex.put(key, value);
            }
        }
    }
}
