package jiraApis;

public class payLoad {


	public static String addBugBody(){
		
		String payLoad="{" + "\"fields\": {" + "\"project\":" + "{" + "\"key\": \"BLACKPEARL\"" + "},"
				+ "\"summary\": \" All -in - One - 1 \"," + "\"description\": \"All -in - One - 1 \","
				+ "\"issuetype\": {" + "\"name\": \"Bug\"" + "}" + "}" + "}";
		return payLoad;
	}

	public static String addCommentForBugBody() {
		// TODO Auto-generated method stub
		String payLoad="{" + "\"body\": \"Added Comment -  All -in - One - 1 \"," + "\"visibility\": {"
				+ "\"type\": \"role\"," + "\"value\": \"Administrators\"" + "}" + "}";
		return payLoad;
	}

	public static String updateCommentInBugPayload() {
		// TODO Auto-generated method stub
		String payLoad="{" + "\"body\": \"Updated Comment -  All -in - One - 1 " + "\"," + "\"visibility\": {"
				+ "\"type\": \"role\"," + "\"value\": \"Administrators\"" + "}" + "}";
		return payLoad;
	}
	
	
}
