package com.gogbuy.readandexport.export;

import com.gogbuy.readandexport.entity.ColumnEntity;
import com.gogbuy.readandexport.entity.TableEntity;
import com.gogbuy.readandexport.util.DBManager;
import com.gogbuy.readandexport.util.LoadProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangjiameng
 * @Description 导出类
 * @date 2020/1/3 16:15
 */
public class ExportToFile {

    /**
     * 从数据库获取所有的表及其属性
     *
     * @return
     */
    public static List<TableEntity> getTables() {
        ArrayList<TableEntity> tableEntities = new ArrayList<TableEntity>();
        Connection conn = DBManager.getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            HashMap<String, String> map = LoadProperties.getInstance().getMap();
            String database = map.get("jdbc.databasename");
            //查询表的信息
            ResultSet tables = metaData.getTables(database, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                TableEntity tableEntity = new TableEntity();
                tableEntity.setName(tables.getString(3));
                tableEntity.setDescription(tables.getString(5));
                //查询列的信息
                ResultSet columns = metaData.getColumns(database, null, tableEntity.getName(), null);
                ArrayList<ColumnEntity> columnEntities = new ArrayList<ColumnEntity>();
                while (columns.next()) {
                    ColumnEntity col = new ColumnEntity();
                    col.setName(columns.getString(4));
                    col.setType(columns.getString(6).toLowerCase() + "(" + columns.getString(7) + ")");
                    col.setDescription(columns.getString(12));
                    col.setPrimaryKey("no");
                    columnEntities.add(col);
                }
                tableEntity.setColumnes(columnEntities);
                tableEntities.add(tableEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.release(conn);
        }
        return tableEntities;
    }

    /**
     * 将数据表信息写入文件中
     *
     * @param tbs 数据表信息
     * @return
     */
    public static Boolean writeFile(List<TableEntity> tbs) {
        String fileName = LoadProperties.getInstance().getMap().get("file.path");
        StringBuffer sb = new StringBuffer();
        String s = "| Name | Type | Description | PrimaryKey |\n| - | - | - | - | - |\n";
        String s1 = " | ";
        int size = tbs.size();
        for (int i = 0; i < size; i++) {
            TableEntity t = tbs.get(i);
            sb.append("#### " + (i+1) + "." + t.getDescription() + "(" + t.getName() + ")\n");
            sb.append(s);
            for (ColumnEntity c : t.getColumnes()) {
                sb.append(s1);
                sb.append(c.getName());
                sb.append(s1);
                sb.append(c.getType());
                sb.append(s1);
                sb.append(c.getDescription());
                sb.append(s1);
                sb.append(c.getPrimaryKey());
                sb.append(s1+"\n");
            }
        }
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write(sb.toString());
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件写入出错！");
        }
        return false;
    }

    public static void main(String[] args) {
        List<TableEntity> tables = ExportToFile.getTables();
        Boolean flag = ExportToFile.writeFile(tables);
        if (flag) {
            System.out.println("写入成功。。。。");
        }
    }
}
