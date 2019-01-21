package Raadi.domain.model;

import java.util.HashSet;

public class DocumentRaw {

    protected String content;
    protected String URL;
    protected String srcURL;
    protected HashSet<String> childrenURL;

    public DocumentRaw() {
    }
}
