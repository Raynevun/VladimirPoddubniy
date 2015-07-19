import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class URLmaker {
	static String BaseURL = "https://beacon.nist.gov/rest/record/";

	public String getURL() {
		return BaseURL + getTimeStamp();
	}

	// TODO finish
	private String getTimeStamp() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter record (current/previous/next/last/start-chain): ");
		String record = "";
		switch (in.nextLine()) {
		case "current":
			record = "current";
			break;
		case "previous":
			record = "previous";  //1378395540   -1437326760
			break;
		case "next":
			record = "next";
			break;
		case "last":
			record = "last";
			break;
		// case "start-chain": break;
		default:
			System.out.println("Invalid format");
			return null;
		}
		
		if (record.equals("last"))
				return record;
		else {
		System.out.println("Enter time in format (dd/MM/yyyy HH:mm): ");
		String time = in.nextLine();
		Date epoch = null;
		try {
			epoch = new java.text.SimpleDateFormat(time).parse("dd/MM/yyyy HH:mm");
		} catch (ParseException e) {
			System.out.println("Date was not entered");
		}
		System.out.println("epoch " + epoch);
		return record + "/" + epoch.getTime();
		}
	}

}
