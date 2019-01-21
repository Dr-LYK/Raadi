package Raadi.application;

import Raadi.domain.Crawler;
import Raadi.domain.Manager;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Manager manager = Manager.getInstance();
        manager.execute("https://fr.wikipedia.org/wiki/Wikipédia:Accueil_principal", 10);

        System.out.println( "Hello World!" );
    }
}
