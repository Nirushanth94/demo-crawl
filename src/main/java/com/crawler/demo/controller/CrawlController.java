package com.crawler.demo.controller;

import com.crawler.demo.dto.request.SearchRequest;
import com.crawler.demo.dto.response.SearchResponse;
import com.crawler.demo.service.CrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nirushanth.CN
 * 27/09/2022
 */

@RestController
@RequestMapping("api/crawl")
@Slf4j
public class CrawlController {
    @Autowired
    CrawlService crawlService;

    @PostMapping("/search")
    ResponseEntity<SearchResponse> search(final @RequestBody SearchRequest request) {
        log.info("Incomming POST Request : api/crawl/search");
        return crawlService.findText(request.getUrl(), request.getKey());
    }
}