package Raadi.domain.model;

import java.util.HashSet;

public class DocumentRaw {

    protected String content;
    protected String URL;
    protected String srcURL;
    protected HashSet<String> childrenURL;

    public DocumentRaw() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSrcURL() {
        return srcURL;
    }

    public void setSrcURL(String srcURL) {
        this.srcURL = srcURL;
    }

    public HashSet<String> getChildrenURL() {
        return childrenURL;
    }

    public void setChildrenURL(HashSet<String> childrenURL) {
        this.childrenURL = childrenURL;
    }
}
