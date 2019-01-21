package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;
import Raadi.util.Converter;
import java.util.*;

public class Manager
{
    private Queue<String> linksTodo;
    private HashSet<String> stopWords;
    private HashSet<String> linksDone;
    private ArrayList<DocumentRaw> documentRawList;
    private ArrayList<DocumentClean> documentCleanList;
    private HashMap<String, String> synonymes;

    HashMap<String, ArrayList<DocumentClean>> retroIndex;


    private Manager() {
        this.linksTodo = new LinkedList<>();
        this.linksDone = new HashSet<>();
        this.documentRawList = new ArrayList<>();
        this.documentCleanList = new ArrayList<>();
        this.stopWords = Converter.StopWordsJsonToHashSet();
        this.synonymes = Converter.SynonymsCSVToHashMap();
    }

    private static class ManagerHolder {
        private final static Manager instance = new Manager();
    }

    public static Manager getInstance() {
        return ManagerHolder.instance;
    }

    /**
     * Manager stop words getter.
     * @return the stop words.
     */
    public HashSet<String> getStopWords() {
        return stopWords;
    }

    /**
     * Manager synonymes getter.
     * @return the synonymes.
     */
    public HashMap<String, String> getSynonymes() {
        return synonymes;
    }

    /**
     * Manager crawl function to fill the documentRawList.
     * @param firstURL is the entry url.
     * @param max_size is the maximun url number wanted.
     */
    public void crawl(String firstURL, int max_size) {
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

    /**
     * documentCleanList content setter.
     */
    private void cleanup() {
        for (DocumentRaw documentRaw : documentRawList) {
            documentCleanList.add(CleanUp.cleanup(documentRaw));
            documentRawList.remove(documentRaw);
        }
    }

    /**
     * retroIndex content setter.
     */
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
