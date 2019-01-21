package Raadi.domain.model;

import java.util.HashSet;

public class DocumentRaw {

    /**
     * DocumentRaw attributes.
     */
    private String content;
    private String URL;
    private String srcURL;
    private HashSet<String> childrenURL;

    /**
     * DocumentRaw content getter.
     * @return the document content.
     */
    public String getContent() {
        return content;
    }

    /**
     * DocumentRaw content setter.
     * @param content is the document content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * DocumentRaw URL getter.
     * @return the document URL.
     */
    public String getURL() {
        return URL;
    }

    /**
     * DocumentRaw URL setter.
     * @param URL is the document URL.
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * DocumentRaw source URL getter.
     * @return the document URL where it comes from.
     */
    public String getSrcURL() {
        return srcURL;
    }

    /**
     * DocumentRaw source URL setter.
     * @param srcURL is the document URL where it comes from.
     */
    public void setSrcURL(String srcURL) {
        this.srcURL = srcURL;
    }

    /**
     * DocumentRaw URL children getter.
     * @return the document's list of URL children.
     */
    public HashSet<String> getChildrenURL() {
        return childrenURL;
    }

    /**
     * DocumentRaw URL   setter
     * @param childrenURL is list of URL children
     */
    public void setChildrenURL(HashSet<String> childrenURL) {
        this.childrenURL = childrenURL;
    }

    /**
     * DocumentRaw constructor.
     */
    public DocumentRaw() {
    }
}
