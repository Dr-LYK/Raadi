package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;
import Raadi.util.Converter;

import java.io.IOException;
import java.util.*;

public class Manager
{

    private final int max_size = 50;
    private Queue<String> linksTodo;
    private HashSet<String> stopWords;
    private HashSet<String> linksDone;
    private ArrayList<DocumentRaw> documentRawList;
    private ArrayList<DocumentClean> documentCleanList;

    HashMap<String, ArrayList<DocumentClean>> retroIndex;


    private Manager() {
        this.linksTodo = new LinkedList<>();
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

    private void crawl(String firstURL) {
        linksTodo.add(firstURL);

        while (linksDone.size() < max_size && !linksTodo.isEmpty()) {
            String url = linksTodo.poll();

            if (!linksDone.contains(url)) {
                DocumentRaw dr = Crawler.crawl(url);
                documentRawList.add(dr);
                linksDone.add(url);

                for (String childUrl : dr.getChildrenURL()) {
                    linksTodo.add(childUrl);
                }
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
