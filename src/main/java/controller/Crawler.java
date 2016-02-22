package controller;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

public class Crawler extends WebCrawler {
    public static ArrayList<String> urlFetched = new ArrayList<String>();
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp3|zip|gz))$");


    public boolean shouldVisit(WebURL url) {
        String href = url.getURL().toLowerCase();
        System.out.println("This is the url " + url);
        return !FILTERS.matcher(href).matches();
    }


    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        urlFetched.add(url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            System.out.println("Number of outgoing links: " + links.size());

        }
    }
}