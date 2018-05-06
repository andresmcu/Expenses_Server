package com.andresmc.expenses.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class BDAgent {

	private final static String _HOST = "127.0.0.1";
	private final static int _PORT = 3306;
	private final static String _DATABASE = "expenses_db";
	private final static String _USER = "root";
	private final static String _PASS = "root";
	
	private static Connection connection = null;

    public BDAgent() {
    	if (connection == null)
    		BDAgent.connect();
    }
    
    private static void connect() {
    	try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://" + _HOST + ":" + _PORT + "/" + _DATABASE + "?user=" + _USER + "&password=" + _PASS + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
    	} catch (ClassNotFoundException e) {
    		System.out.println("DBAgent.connect() ClassNotFoundException: " + e.getMessage());
    	} catch (SQLException e) {
    		System.out.println("DBAgent.connect() SQLException: " + e.getMessage());
    	}
    }
    
    public CachedRowSet select(String query) throws SQLException {
    	CachedRowSet crs = null;
    	
    	try {
	    	PreparedStatement ps = connection.prepareStatement(query);
	    	ResultSet rs = ps.executeQuery(query);
	    	
			// create CachedRowSet and populate
	    	crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			
	    	rs.close();
    	} catch (SQLException e) {
    		System.out.println("DBAgent.select() SQLException: " + e.getMessage());
    	} finally {
        	if(connection != null) {
        		connection.close();
        		connection = null;
        	} 
        }
    	
    	return crs;
    }
    
    public int insert(String query) throws SQLException {
        int id = -2;

		try {
        	PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        	ps.execute();
        	
        	ResultSet rs = ps.getGeneratedKeys();
        	if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (Exception e) {
        	System.out.println("DBAgent.insert() SQLException: " + e.getMessage());
        } finally {
        	if(connection != null) {
        		connection.close();
        		connection = null;
        	}
        }
    	
    	return id;
    }
	
}
