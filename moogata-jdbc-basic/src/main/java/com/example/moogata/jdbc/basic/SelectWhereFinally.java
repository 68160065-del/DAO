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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectWhereFinally {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-basic.db";
        String sql = "SELECT category_id, category_name FROM menu_category WHERE category_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("--- Search: เครื่องดื่ม ---");
            stmt.setString(1, "เครื่องดื่ม");
            
            try (ResultSet rs = stmt.executeQuery()) {
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    System.out.println(rs.getInt("category_id") + " | " + rs.getString("category_name"));
                }
                if (!hasData) {
                    System.out.println("ไม่พบข้อมูล");
                }
            }

            System.out.println("\n--- Search: ไม่มีในระบบ ---");
            stmt.setString(1, "ไม่มีในระบบ");
            
            try (ResultSet rs = stmt.executeQuery()) {
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    System.out.println(rs.getInt("category_id") + " | " + rs.getString("category_name"));
                }
                if (!hasData) {
                    System.out.println("ไม่พบข้อมูล");
                }
            }

        } catch (SQLException ex) {
            System.err.println("Query failed: " + ex.getMessage());
        }
    }
}
