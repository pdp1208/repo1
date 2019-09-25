package googleApis;

public class resources {

	public static String placePostData(){
		String res="/maps/api/place/add/json";
		return res;
	}


	public static String getLocation() {
		// TODO Auto-generated method stub
		String res="/maps/api/place/nearbysearch/json";
		return res;
	}


	public static String deleteLocation() {
		// TODO Auto-generated method stub
		String res="/maps/api/place/delete/json";
		return res;
	}
	

	public static String AddLocationUsingXML() {
		// TODO Auto-generated method stub
		String res="/maps/api/place/add/xml";
		return res;
	}


	public static String addBook() {
		// TODO Auto-generated method stub
		String res="Library/Addbook.php";
		return res;
	}
	
	public static String getBook() {
		// TODO Auto-generated method stub
		String res="Library/Addbook.php";
		return res;
	}
	
	public static String deleteBook() {
		// TODO Auto-generated method stub
		String res="/Library/DeleteBook.php";
		return res;
	}
}
