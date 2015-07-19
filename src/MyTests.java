
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MyTests {

	@Test
	public void verifyStartTimeStamp() throws Exception {
		HTTPcon tester = new HTTPcon();
		assertEquals(
				"17070B49DBF3BA12BEA427CB6651ECF7860FDC3792268031B77711D63A8610F4CDA551B7FB331103889A62E2CB23C0F85362BBA49B9E0086D1DA0830E4389AB1",
				tester.getOutputValue("https://beacon.nist.gov/rest/record/1378395540"));
	}
	
	@Test
	public void verifyBeforeStartTimeStamp() throws Exception {
		HTTPcon tester = new HTTPcon();
		assertEquals(
				"17070B49DBF3BA12BEA427CB6651ECF7860FDC3792268031B77711D63A8610F4CDA551B7FB331103889A62E2CB23C0F85362BBA49B9E0086D1DA0830E4389AB1",
				tester.getOutputValue("https://beacon.nist.gov/rest/record/1378395539"));
	}
	
	@Test
	public void verifyLastTimeStamp() throws Exception {
		HTTPcon tester = new HTTPcon();
		assertEquals(
				"0577A4EFAEB70BB977552BBA810AC88166B5A3126DE6DB4577D9FB72C0A5051686625726986D7924028C2AA51F52BA460912AA5081C5D963DE50D0EF962F82FE",
				tester.getOutputValue("https://beacon.nist.gov/rest/record/1437326760"));
	}
	
	@Test
	public void verifyOutputParserOne() throws Exception {
		OutputParser tester = new OutputParser();
		List<String> expected = new ArrayList<String>(Arrays.asList("0,1", "1,1", "2,1", "3,1", "4,1", "5,1", "6,1",
				"7,1", "8,1", "9,1", "A,1", "B,1", "C,1", "D,1", "E,1", "F,1"));
		assertEquals(expected, tester.getResults("0123456789ABCDEF"));
	}
	
	@Test
	public void verifyOutputParserEmptyString() throws Exception {
		OutputParser tester = new OutputParser();
		List<String> expected = new ArrayList<String>();
		assertEquals(expected, tester.getResults(""));
	}
	

}
