import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPcon {
	
	public String getOutputValue(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		System.out.println("Sending request to: " + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String out = response.toString();
		System.out.println("Received answer: \n" + out);
		String outputValue = out.substring(out.indexOf("<outputValue>") + 13, out.indexOf("</outputValue>"));
		System.out.println("Attribute <outputValue> is: \n" + outputValue);
		return outputValue;
	}


}
