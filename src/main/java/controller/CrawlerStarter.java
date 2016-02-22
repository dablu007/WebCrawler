package controller;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlerStarter {
    private int maxDepthOfCrawling;
    private int maxPagesToFetch;
    private String urlToFetch;

    public CrawlerStarter(int maxDepthOfCrawling, int maxPagesToFetch, String urlToFetch) {
        this.maxDepthOfCrawling = maxDepthOfCrawling;
        this.maxPagesToFetch = maxPagesToFetch;
        this.urlToFetch = urlToFetch;
    }


    public void startCrawling() {
        /*
            This is the folder where the crawling of the url is stored
         */


        String crawlStorageFolder = "/data/crawl/root";
        int numberOfCrawlers = 1;

        /*
            Instantaniate the crawler
         */
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = null;
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* This is used for the crwaler to start and the seed is the first few url to be
            added to start the crawling
         */
        controller.addSeed(urlToFetch);
        config.setMaxDepthOfCrawling(maxDepthOfCrawling);
        config.setMaxPagesToFetch(maxPagesToFetch);


        controller.start(Crawler.class, numberOfCrawlers);
        appendOutput();
    }
    /*
        This function is used for the purpose of appending the url
        into a output file
     */
    public void appendOutput(){
        ArrayList<String> outputUrl = Crawler.urlFetched;
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            for (int i = 0; i < outputUrl.size(); i++) {
                fileWriter.write(outputUrl.get(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
