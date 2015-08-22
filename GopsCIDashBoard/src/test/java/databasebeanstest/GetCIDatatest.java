package databasebeanstest;

import java.io.IOException;

import databasebeans.GetCIData;

public class GetCIDatatest {

	public static void main(String[] args) throws IOException {
		GetCIData getCIData = new GetCIData();
		System.out.println(getCIData.getLatestBuildID("AdminCITestSuite"));
		

	}

}
