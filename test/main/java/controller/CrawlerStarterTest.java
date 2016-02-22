package main.java.controller;

import controller.Crawler;
import controller.CrawlerStarter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CrawlerStarterTest {
    @Before
    public void setUp(){
        int maxDepthOfCrawling = 1;
        int maxPagesToFetch = 4;
        Crawler.urlFetched.clear();
        String urlToFetch = "http://localhost:63342/WebCrawler/pageToCrawl.html";
        CrawlerStarter crawlerStarter = new CrawlerStarter(maxDepthOfCrawling, maxPagesToFetch, urlToFetch);
        crawlerStarter.startCrawling();

    }

    @Test
    public void shouldGiveTheCorrectNumberOfOutputUrlsForCrawlingAUrl() {
        assertEquals(3, Crawler.urlFetched.size());
    }


    @Test
    public void shouldGiveCorrectDataForTheOutputUrlsForCrawlingAUrl() {
        ArrayList<String> output = new ArrayList<String>();
        output.add("http://localhost:63342/WebCrawler/pageToCrawl.html");
        output.add("https://www.thoughtworks.com/about-us");
        output.add("https://info.thoughtworks.com/graduates");
        assertEquals(output, Crawler.urlFetched);
    }

}
