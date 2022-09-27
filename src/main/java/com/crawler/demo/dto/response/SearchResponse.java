package com.crawler.demo.dto.response;

import com.crawler.demo.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author Nirushanth.CN
 * 27/09/2022
 */

@Getter
@Setter
@AllArgsConstructor
public class SearchResponse {
    String message;
    ArrayList<Result> resultList;
}