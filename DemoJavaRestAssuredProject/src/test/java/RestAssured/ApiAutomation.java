package RestAssured;

import java.util.HashMap;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

public class ApiAutomation {
	
	public static void main(String args[]){

	 String a ="AAABBCCCC444444EEEEe";
			int intialLength =1;
			StringBuilder string = new StringBuilder();
			for(int i=1;i<a.length();i++){
				if(a.charAt(i)==a.charAt(i-1))
				{
					intialLength++;
				}
				else{
					string.append(a.charAt(i-1)).append(intialLength>=1?intialLength:"");
					intialLength=1;
				}	
				}
			string.append(a.charAt(a.length()-1)).append(intialLength>=1?intialLength:"");
			System.out.println(string.toString());
			}
}




			
