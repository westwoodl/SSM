package com.xu.mvc.pojo;

import java.util.List;

public class QueryItems {
    private Integer id;
    private List<Item> items;

    @Override
    public String toString() {
        return "QueryItems{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
