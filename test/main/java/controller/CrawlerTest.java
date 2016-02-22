package main.java.controller;

import controller.Crawler;
import edu.uci.ics.crawler4j.url.WebURL;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CrawlerTest {

    private Crawler crawler;
    private WebURL url;
    @Before
    public void setUp() throws IOException {
        crawler = new Crawler();
        url = new WebURL();

    }
    @Test
    public void shouldTestThatTheUrlShouldVisitWhenUrlIsCorrectWihtoutAnyPattern(){
        url.setURL("something@example.com");
        assertTrue(crawler.shouldVisit(url));
    }

    @Test
    public void shouldTestThatTheUrlWillNotBeVisitedWhenUrlContainsJpg(){
        url.setURL("https://something@example.com/profiles/image.jpg");
        assertFalse(crawler.shouldVisit(url));
    }

    @Test
    public void shouldTestThatTheUrlWillNotBeVisitedWhenUrlContainsjs(){
        url.setURL("https://something@example.com/profiles/image.js");
        assertFalse(crawler.shouldVisit(url));
    }

}
