package Raadi.domain;

import Raadi.domain.model.DocumentClean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Manager
{
    HashSet<String> linksTodo;
    HashSet<String> linksDone;
    List<DocumentClean> documents;

    HashMap<String, ArrayList<DocumentClean>> retroIndex;

    public void fillRetroIndex() {
        for (DocumentClean dc : documents) {
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
