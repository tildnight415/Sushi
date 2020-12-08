/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Article;
import Model.Information;
import Model.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bui Loc Xuan Truong - He130204
 */
public class SelectDao {

    //2. selecting all Article with special condition by excute sql command
    public List<Article> selectAllArticle() {
        List<Article> art = new ArrayList<>();
        String sql = "SELECT * FROM Article";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String imglink = rs.getString("imglink");
                String content = rs.getString("content");
                art.add(new Article(id, title, imglink, content));
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return art;
    }
    
        //2. selecting all Article with special condition by excute sql command
    public List<Menu> selectAllMenu() {
        List<Menu> menu = new ArrayList<>();
        String sql = "SELECT * FROM menu";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                String price = rs.getString("price");
                menu.add(new Menu(id, name, content, price));
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu;
    }

    //2. selecting address with special condition by excute sql command
    public Information selectAddress() {
        Information con = new Information();
        String sql = "SELECT * FROM information WHERE type = 'address'";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String key = rs.getString("key");
                String value = rs.getString("value");
                con = new Information(id, type, key, value);
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //2. selecting phone with special condition by excute sql command
    public Information selectPhone() {
        Information con = new Information();
        String sql = "SELECT * FROM information WHERE type = 'phone'";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String key = rs.getString("key");
                String value = rs.getString("value");
                con = new Information(id, type, key, value);
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //2. selecting email with special condition by excute sql command
    public Information selectEmail() {
        Information con = new Information();
        String sql = "SELECT * FROM information WHERE type = 'email'";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String key = rs.getString("key");
                String value = rs.getString("value");
                con = new Information(id, type, key, value);
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //2. selecting all Schedule with special condition by excute sql command
    public List<Information> selectSchedule() {
        List<Information> con = new ArrayList<>();
        String sql = "SELECT * FROM information WHERE type = 'schedule'";
        try (Connection conn = new DBContext().getConnection();
                ResultSet rs = conn.prepareStatement(sql).executeQuery()) {

            //it shifts the cursor to the next row of the result set from the database 
            //and returns true if there is any row, otherwise false and break loop. 
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String key = rs.getString("key");
                String value = rs.getString("value");
                con.add(new Information(id, type, key, value));
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    //get view from database
    public String[] getViewPage() throws Exception {
        String temp = "";
        String sql = "SELECT * FROM views";
        Connection conn =new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(sql).executeQuery();

        //get view  
        if (rs.next()) {
            temp = rs.getInt("viewpage") + "";
        }
        
        //compare views lenght with 6 
        if (temp.length() < 6) {
            int zero = 6 - temp.length();
            
            //add 0 before view
            for (int i = 0; i < zero; i++) {
                temp = "0" + temp;
            }
        }
        
        return temp.split("");
    }

////    //test query    
//    public static void main(String[] args) throws Exception {
//        SelectDao s = new SelectDao();
//
//        List<Menu> a = s.selectAllMenu();
//        for (Menu menu : a) {
//            System.out.println(menu.getName());
//        }
//    }
}
