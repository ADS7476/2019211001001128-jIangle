package com.jiangle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category implements java.io.Serializable{

    private  int categoryId;
    private  String categoryName;
    private  String description;
    private  boolean action;



    public Category(){

    }
    public Category(int categoryId, String categoryName, String description, boolean action) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.action = action;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Catagory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", action=" + action +
                '}';
    }
    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from Category";
        List<Category>  list= new ArrayList<>();
        PreparedStatement pt=con.prepareStatement(sql);
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            Category c=new Category();
            c.setCategoryId(rs.getInt("categoryId"));
            c.setCategoryName(rs.getString("categoryName"));
            c.setDescription(rs.getString("description"));
            list.add(c);

        }
        return list;
    }
    public  static  String findByCategoryId(Connection con, int categoryId) throws SQLException {
        String sql="select * from Category where categoryId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        String categoryName=null;
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            categoryName=rs.getString("categoryName");

        }
        return  categoryName;
    }
}