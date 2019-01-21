package Raadi.domain.model;

import java.util.HashSet;

public class DocumentClean {

    /**
     * DocumentClean attributes.
     */
    private String content;
    private String URL;
    private String srcURL;
    private HashSet<String> childrenURL;

    /**
     * DocumentClean content getter.
     * @return the document content.
     */
    public String getContent() {
        return content;
    }

    /**
     * DocumentClean content setter.
     * @param content is the document content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * DocumentClean URL getter.
     * @return the document URL.
     */
    public String getURL() {
        return URL;
    }

    /**
     * DocumentClean URL setter.
     * @param URL is the document URL.
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * DocumentClean source URL getter.
     * @return the document URL where it comes from.
     */
    public String getSrcURL() {
        return srcURL;
    }

    /**
     * DocumentClean source URL setter.
     * @param srcURL is the document URL where it comes from.
     */
    public void setSrcURL(String srcURL) {
        this.srcURL = srcURL;
    }

    /**
     * DocumentClean URL children getter.
     * @return the document's list of URL children.
     */
    public HashSet<String> getChildrenURL() {
        return childrenURL;
    }

    /**
     * DocumentClean URL   setter
     * @param childrenURL is list of URL children
     */
    public void setChildrenURL(HashSet<String> childrenURL) {
        this.childrenURL = childrenURL;
    }

    /**
     * DocumentClean constructor.
     */
    public DocumentClean() {
    }
}
