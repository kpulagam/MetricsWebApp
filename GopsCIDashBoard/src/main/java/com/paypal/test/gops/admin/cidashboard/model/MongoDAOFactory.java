package com.paypal.test.gops.admin.cidashboard.model;

import java.io.IOException;

//MOngo DAO Factroy
public class MongoDAOFactory extends DashBoardDAOFactory {
	
	/* (non-Javadoc)
	 * @see com.paypal.test.gops.admin.cidashboard.model.DashBoardDAOFactory#getCIDataDAO()
	 */
	@Override
	public MongoGetCIDataDAO getCIDataDAO(){
		try {
			return new MongoGetCIDataDAO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.paypal.test.gops.admin.cidashboard.model.DashBoardDAOFactory#getRegistrationDAO()
	 */
	@Override
	public MongoRegistrationDAO getRegistrationDAO(){
		return new MongoRegistrationDAO();
	}

}
