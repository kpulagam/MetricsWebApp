package com.paypal.test.gops.admin.cidashboard.model;

public class OracleDAOFactory extends DashBoardDAOFactory {

	@Override
	public OracleGetCIDataDAO getCIDataDAO() {
		// TODO Auto-generated method stub
		
		return new OracleGetCIDataDAO();
	}

	@Override
	public OracleRegistrationDAO getRegistrationDAO() {
		// TODO Auto-generated method stub
		return new OracleRegistrationDAO();
	}

}
