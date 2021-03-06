package databasebeans;

public class RegisterCIDetails {

	private String teamName = "";
	private String testSuiteName = "";
	private String contactPerson = "";
	private String contactEmailAddress = "";
	private String actionMessage = "";

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public RegisterCIDetails() {

	}

	public RegisterCIDetails(String teamName, String testSuiteName, String contactPerson, String contactEmailAddress) {
		setTeamName(teamName);
		setTestSuiteName(testSuiteName);
		setContactPerson(contactPerson);
		setContactEmailAddress(contactEmailAddress);

	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTestSuiteName() {
		return testSuiteName;
	}

	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public boolean validateDetails() {

		if (teamName.equals("")) {
			setActionMessage("Team Name Cannot Be Empty");
			
			return false;
		} else if (testSuiteName.equals("")) {
			setActionMessage("TestSuiteName Cannot Be Empty");
			return false;
		} else if (contactPerson.equals("")) {

			setActionMessage("Contact Person Cannot Be Empty");
			return false;
		} else if (contactEmailAddress.equals("")) {
			setActionMessage("Contact EmailAddress Cannot Be Empty");
			return false;
		} else if(!contactEmailAddress.contains("@")){
			setActionMessage("Please enter a valid contact EmailAddress Cannot Be Empty");
			return false;
			
		}
		
		else {
			return true;
		}

	}

}
