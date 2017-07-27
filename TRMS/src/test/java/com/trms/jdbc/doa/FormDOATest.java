package com.trms.jdbc.doa;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trms.jdbc.util.ConnectionFactory;



public class FormDOATest {
	Logger logTest = Logger.getRootLogger();
	static Connection conn = null;
	static FormImplementDOA formDOA = new FormImplementDOA();
	
	@BeforeClass
	public static void connSetup(){
		conn = ConnectionFactory.getInstance().getConnection();
	}
	@Test
	public void testConnection() throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		logTest.debug(conn.isClosed());
		assertFalse(conn.isClosed());
	}
	
	
	
	//Test the form cost set methods (2 methods)
	@Test
	public void testGetCostOnFormIDMethods() throws SQLException{
	

		
	}
	
	@Test
	public void testSetCostOnFormIDMethods() throws SQLException{
	//Test the form cost get methods (2 methods)
	assertTrue("Ensure output is 0 on negative input", formDOA.setFullCostOnFormID(1, -200.00) == 0.0);
	assertTrue("Ensure output is 0 on 0 input", formDOA.setFullCostOnFormID(1, 00.00) == 0.0);
	
	
	
	}
//	public double getReimbursementCostOnFormID(Integer formID)throws SQLException;
//	public double getFullCostOnFormID(Integer formID)throws SQLException;
//	public double setFullCostOnFormID(Integer formID, Double newCost) throws SQLException;
//	public double setReimbursementCostOnFormID(Integer formID, Double newCost) throws SQLException;
}
