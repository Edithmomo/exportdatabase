package com.gogbuy.readandexport.entity;

/**
 * @author edith
 * @Description 数据库列实体
 * @date 2020/1/3 16:05
 */
public class ColumnEntity {
    /**
     * 字段名
     */
    private String name;
    /**
     * 字段类型 包括长度
     */
    private String type;
    /**
     * 是否为主键
     */
    private String primaryKey;
    /**
     * 字段说明
     */
    private String description;

    public ColumnEntity() {}

    public ColumnEntity(String name, String type, String primaryKey, String description) {
        this.name = name;
        this.type = type;
        this.primaryKey = primaryKey;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ColumnEntity{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", primaryKey='" + primaryKey + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
