package me.xerosoft.models;

import java.util.List;

/**
 * Created by xero on 8/10/18.
 */
public class Restaurant {
    private String id;
    private String name;
    private List<Table> tableList;

    public Restaurant() {

    }

    public Restaurant(String id, String name, List<Table> tableList) {
        this.id = id;
        this.name = name;
        this.tableList = tableList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }
}
