package Raadi.application;

import Raadi.domain.Crawler;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Crawler.crawl("https://fr.wikipedia.org/wiki/Wikipédia:Accueil_principal");
        System.out.println( "Hello World!" );
    }
}
