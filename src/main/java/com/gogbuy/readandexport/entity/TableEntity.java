package com.gogbuy.readandexport.entity;

import java.util.List;

/**
 * @author edith
 * @Description 数据表实体
 * @date 2020/1/3 16:04
 */
public class TableEntity {
    /**
     * 表名
     */
    private String name;
    /**
     * 列
     */
    private List<ColumnEntity> columnes;
    /**
     * 表说明
     */
    private String description;

    public TableEntity() {}

    public TableEntity(String name, List<ColumnEntity> columnes, String description) {
        this.name = name;
        this.columnes = columnes;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ColumnEntity> getColumnes() {
        return columnes;
    }

    public void setColumnes(List<ColumnEntity> columnes) {
        this.columnes = columnes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "name='" + name + '\'' +
                ", columnes=" + columnes +
                ", description='" + description + '\'' +
                '}';
    }
}
