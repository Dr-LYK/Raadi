package Raadi.application;

import Raadi.domain.Crawler;
import Raadi.domain.Manager;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) {
        Manager manager = Manager.getInstance();
        manager.execute("https://news.ycombinator.com", 10);

        System.out.println( "Hello World!" );
    }
}
