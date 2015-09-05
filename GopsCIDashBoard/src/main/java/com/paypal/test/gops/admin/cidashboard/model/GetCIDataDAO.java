package com.paypal.test.gops.admin.cidashboard.model;
//Generic interface that can be used across data bases for retrieving CI data
import java.util.List;

import org.bson.Document;

public interface GetCIDataDAO {

	public int getLatestBuildID(String suiteName);

	public List<Document> getMultipleRunsFailures(int numberOfRuns, String suiteName);

	public List<Document> getFailuresForBuildId(String suiteName, int buildID);

}