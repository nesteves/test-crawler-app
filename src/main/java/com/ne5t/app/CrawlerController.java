package com.ne5t.app;

import com.ne5t.app.crawler.Crawler;
import com.ne5t.app.pagefetcher.PageFetcher;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class CrawlerController {
    
    private int maxPagesToVisit;
    private Set<String> pagesVisited;
    private List<String> pagesToVisit;
    private Crawler crawler;
    
    /**
     * Initialize the basic instance variables
     *  the maximum number of pages to visit
     *  a list of the unique urls already visited
     *  a list of urls found by the crawler and not yet
     * visited
     * @param maxPagesToVisit - the maximum number of pages to be visited
     *  by the crawler
     * @param startingPageUlr - the url at which the crawler begins
     */
    public CrawlerController(int maxPagesToVisit, String startingPageUrl) {
        this.maxPagesToVisit = maxPagesToVisit;
        pagesVisited = new HashSet<String>();
        pagesToVisit = new LinkedList<String>();

        pagesToVisit.add(startingPageUrl);

        this.crawler = new Crawler();
    }

    /**
     * Method that calls the Crawler and PageFetcher classes
     * while there are pages to visit or the maximum number
     * of pages has not been reached
     */
    private void runCrawler() {
        String nextPage;

        while (pagesVisited.size() < maxPagesToVisit && !pagesToVisit.isEmpty()) {
            nextPage = pagesToVisit.remove(0);
            
            if (!pagesVisited.contains(nextPage)) {
                
                pagesVisited.add(nextPage);
            }
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
