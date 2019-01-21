package Raadi.application;

import Raadi.domain.Crawler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Crawler.crawl("https://fr.wikipedia.org/wiki/Wikipédia:Accueil_principal");
        System.out.println( "Hello World!" );
    }
}
