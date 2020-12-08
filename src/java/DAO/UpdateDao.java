/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Bui Loc Xuan Truong - He130204
 */
public class UpdateDao {
    
    //update Views
    public void updateViews() throws Exception{
        String sql = "UPDATE views\n"
                + "SET viewpage = viewpage+1\n";
                
        try (Connection conn = new DBContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }
    
}
