package com.paypal.test.gops.admin.cidashboard.model;

public abstract class DashBoardDAOFactory {
	
	public static final int MONGO = 0;
	public static final int ORACLE = 1;
	

	public abstract GetCIDataDAO getCIDataDAO();

	public abstract RegestrationDetailsDAO getRegistrationDAO();
	
	public static DashBoardDAOFactory getDAOFactroy(int type){
		switch(type){
		case MONGO:
			return new MongoDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		default:
			
			return null;
			
		}
	}

}