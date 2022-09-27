package com.crawler.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author Nirushanth.CN
 * 27/09/2022
 */

@Getter
@Setter
public class SearchRequest {
    private String key;
    private ArrayList<String> url;
}