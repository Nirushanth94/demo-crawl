package com.crawler.demo.model;

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
public class Result {
    private String url;
    private int count;
    private ArrayList<String> text;
}