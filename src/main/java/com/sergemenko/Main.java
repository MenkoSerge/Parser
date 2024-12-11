package com.sergemenko;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Document getPage() throws IOException {
        String url = "https://www.conti.waw.pl/";

        Document page = Jsoup.parse(new URL(url),3000);
        return  page;
        
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element tableCurency = page.select("div[class=rrrcurrencies row]").first();
        Element date = page.select("time[datetime]").first();
//        System.out.println(date);
        Elements countryName = tableCurency.select("div[class=country-name]");
        Elements currency = tableCurency.select("div[class=col-md-4 col-6 center]");
        for (Element element : currency) {
            String buy = element.select("span").toString().;
            System.out.println(buy);
        }
//        System.out.println(currency);
//        System.out.println(getPage());
    }
}