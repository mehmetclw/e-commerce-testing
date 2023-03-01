package com.ecommerce.utility;

import java.sql.*;
import java.util.List;

public class Database {
    private Connection conn;

    // Method for connecting to the database
    public void connect(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method for disconnecting from the database
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method for executing a SELECT statement
    public ResultSet select(String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    // Method for executing a SELECT prepared statement
    public ResultSet select(String sql, List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i) instanceof String) {
                pstmt.setString(i + 1, (String) params.get(i));
            } else if (params.get(i) instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) params.get(i));
            }
        }
        return pstmt.executeQuery();
    }

    // Method for executing an INSERT, UPDATE, or DELETE statement
    public int execute(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }

    // Method for executing an INSERT, UPDATE, or DELETE prepared statement
    public int execute(String sql, List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i) instanceof String) {
                pstmt.setString(i + 1, (String) params.get(i));
            } else if (params.get(i) instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) params.get(i));
            }
        }
        return pstmt.executeUpdate();
    }
}
