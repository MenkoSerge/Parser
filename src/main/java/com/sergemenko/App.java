package com.sergemenko;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
             String path = "/Users/nordnexsp.zo.o.nippl9522215738/Downloads/1.html";
        List<String> dataBase = new ArrayList<>();

        try {
            Document site = Jsoup.parse(new File(path));
            Elements data = site.getElementsByTag("details");

            for (Element element : data) {
                Element company = element.getElementsByTag("summary").first();
                Element email = element.getElementsByTag("p").first();

                dataBase.add(company.text()+" "+email.text());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            BufferedWriter bw =new BufferedWriter(new FileWriter("database.txt"));
            for (String s : dataBase) {
                s.trim().replaceAll("Contact","");

                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
