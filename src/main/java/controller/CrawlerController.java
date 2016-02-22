package controller;

public class CrawlerController {
    public static void main(String[] args) throws Exception {
        /*
            Max depth upto which we can crawl the pages and max page is
            the maximum number of pages we can fetch after the crawling
            is started
         */
        int maxDepth = 3;
        int maxPages = 10;
        String urlToFetch = "http://localhost:63342/WebCrawler/pageToCrawl.html";
        CrawlerStarter crawlerStarter = new CrawlerStarter(maxDepth, maxPages, urlToFetch);
        crawlerStarter.startCrawling();

    }
}
