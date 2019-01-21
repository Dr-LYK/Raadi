package Raadi.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public final class Crawler
{
    public static RaadiDocument crawl(String URL)
    {
        RaadiDocument raadiDocument = new RaadiDocument();

        try {
            // Get the content of the page
            Document doc = Jsoup.connect(URL).get();
            Element content = doc.body();

            // Get all the url linked in the page
            Elements links = doc.select("a[href]");
            ArrayList<String> childUrl = new ArrayList<>();
            for (Element link : links) {
                childUrl.add(link.attr("abs:href"));
            }

            // raadiDocument.content = body;
            // raadiDocument.url = URL
            // raadiDocument.childrenUrl = childUrl

        } catch (Exception ex) {
            System.err.print(ex);
        }

        return raadiDocument;
    };
}
