package com.paypal.test.gops.admin.cidashboard.model;

import java.util.List;

import org.bson.Document;

public class OracleGetCIDataDAO implements GetCIDataDAO {

	@Override
	public int getLatestBuildID(String suiteName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Document> getMultipleRunsFailures(int numberOfRuns, String suiteName) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Document> getFailuresForBuildId(String suiteName, int buildID) {

		return null;
	}

}
