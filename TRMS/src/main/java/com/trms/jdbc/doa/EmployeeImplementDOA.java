package com.trms.jdbc.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trms.jdbc.util.ConnectionFactory;

public class EmployeeImplementDOA implements EmployeeDOA {

	/*establishing a connection with the database using the Connection Factory*/
	Connection conn = null;
	private void setup(){
		conn = ConnectionFactory.getInstance().getConnection();
	}
	public EmployeeImplementDOA(){
		setup();
	}
	
	
	/**
	 * Gets the current Reimbursement balance of the Employee associated with employeeID.
	 * @return Returns the amount in a double
	 */
	public double getReimbursementBalance(int employeeID) throws SQLException {
		
		//prepare sql statement
		String sql = "select firstname, lastname, employeeid, reimbursement_total from employee where employeeid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, employeeID);
		
		//store result set into a variable of type ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		double balance = 0;
		
		//store the balance into a double
		if(rs.next()){
			
			balance = rs.getDouble("REIMBURSEMENT_TOTAL");
			System.out.println(balance);
		}
		else{
			throw new SQLException();
		}
		
		//return the balance 
		return balance;
	}
	
	/**
	 * Cancels the pending reimbursement request associated with the 
	 * @return void.
	 */
	public void cancelRequest(int requestID) throws SQLException {
		
		if(requestID < 0){
			throw new SQLException();
		}
		else{
		//prepare sql statement						
			String sql = "update form_submissions set status = -1 where formid = ? and status != 5";
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, requestID);
		
			pstmt.executeQuery();
		}
	}
	
	public int getEmployeeIDOnLoginInfo(String username, String password) throws SQLException{
		int myEmpID = -1;
		String sql = "SELECT EmployeeID FROM Employee WHERE Username = ? AND Pass = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			myEmpID = rs.getInt(1);
		}
		
		return myEmpID;
	}

}
