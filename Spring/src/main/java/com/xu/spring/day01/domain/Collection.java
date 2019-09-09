package com.xu.spring.day01.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 集合属性的注入
 */
public class Collection {
    private String[] arr;
    private List<User> list;
    private Map<String, User> map;

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
