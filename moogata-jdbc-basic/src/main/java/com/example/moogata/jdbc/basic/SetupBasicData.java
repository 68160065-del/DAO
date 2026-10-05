/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata.jdbc.basic;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupBasicData {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-basic.db";
        
        String createTableSql = "CREATE TABLE IF NOT EXISTS menu_category ("
                + "category_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "category_name TEXT NOT NULL UNIQUE)";

        String insertSql = "INSERT OR IGNORE INTO menu_category (category_id, category_name) VALUES "
                + "(1, 'บุฟเฟต์'), "
                + "(2, 'ทานเล่น'), "
                + "(3, 'เครื่องดื่ม'), "
                + "(4, 'ของหวาน')";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(createTableSql);
            stmt.executeUpdate(insertSql);
            System.out.println("Setup moogata-basic.db completed!");

        } catch (SQLException ex) {
            System.err.println("Setup failed: " + ex.getMessage());
        }
    }
}
