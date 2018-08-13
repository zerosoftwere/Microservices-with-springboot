package me.xerosoft.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xero on 8/6/18.
 */
public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();

    public Restaurant(String name, String id, List<Table> tableList) {
        super(id, name);
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, tables: %s", getId(), getName(), getTables());
    }
}
