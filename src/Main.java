public class Main {

	public static void main(String[] args) throws Exception {
		URLmaker urlMaker = new URLmaker();
		String url = urlMaker.getURL();
		HTTPcon con = new HTTPcon();
		OutputParser parser = new OutputParser();
		String outputValue = con.getOutputValue(url);
		parser.getResults(outputValue);
	}

}
	