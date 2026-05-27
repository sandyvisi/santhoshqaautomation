package testPages;

import java.util.HashMap;
import java.util.Map;

public class MapLong {

	public static void main(String[] args) {

		Map<String, String> mobileNumber = new HashMap<>();

		mobileNumber.put("2321213213213212", "santhoshkumar");
		mobileNumber.put("234234", "cat");
		mobileNumber.put("423323", "dog");
		mobileNumber.put("34324", "horse");
		 
		mobileNumber.get("2321213213213212");
		
		
	}

}
