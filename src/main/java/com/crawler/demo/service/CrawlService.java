package com.crawler.demo.service;

import com.crawler.demo.dto.response.SearchResponse;
import com.crawler.demo.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nirushanth.CN
 * 27/09/2022
 */

@Service
@Slf4j
public class CrawlService {

    public ResponseEntity<SearchResponse> findText(ArrayList<String> urlList, String key) {

        ArrayList<Result> res = new ArrayList<>();
        if (urlList.isEmpty() || key.isEmpty()) {
            log.info("Invalid Search Data!");
            return ResponseEntity.ok(new SearchResponse("Invalid Search Data", null));
        } else {
            for (String url : urlList) {
                res.add(searchInPage(url, key));
            }
        }
        return ResponseEntity.ok(new SearchResponse("SUCCESS", res));
    }

    Result searchInPage(String url, String key) {
        Set<String> recordSet = new HashSet<>();
        ArrayList<String> textFound = new ArrayList<>();
        int resultCount = 0;
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.body().select("*");
            for (Element element : elements) {
                String text = element.ownText();
                if (!text.isEmpty() && !recordSet.contains(text)) {
                    recordSet.add(text);
                    if (text.contains(key)) {
                        log.info("Text Found : {}", text);
                        textFound.add(text);
                        resultCount++;
                    }
                }
            }
            return new Result(url, resultCount, textFound);
        } catch (Exception e) {
            log.info("Error Occurred : {}", e.getMessage());
            return null;
        }
    }
}