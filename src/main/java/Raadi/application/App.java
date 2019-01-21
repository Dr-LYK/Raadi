package Raadi.application;

import Raadi.domain.Crawler;
import Raadi.domain.Manager;
import Raadi.domain.Query;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) {
        Manager manager = Manager.getInstance();
        manager.execute("https://news.ycombinator.com", 10);

        Query query = new Query("moored");
        query.tokenisation();

        for (String url : query.getQueryDocuments().keySet())
        {
            System.out.println(url);
        }

        System.out.println( "Hello World!" );
    }
}
