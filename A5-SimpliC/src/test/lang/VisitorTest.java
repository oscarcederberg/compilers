package lang;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import beaver.Parser.Exception;

public class VisitorTest {
	private static final File TEST_DIRECTORY = new File("testfiles/visitor");
    

	@Test public void msn_01() throws IOException, Exception{
        testMSN("msn_01.in", 1);
	}
	@Test public void msn_02() throws IOException, Exception{
		testMSN("msn_02.in", 5);
	}
	@Test public void msn_03() throws IOException, Exception{
		testMSN("msn_03.in", 3);
	}
    
    private void testMSN(String file, int msn) throws IOException, Exception{
		Util.testValidSyntax(TEST_DIRECTORY, file);
        Assert.assertEquals(msn, MSNVisitor.result(Util.getProgram(new File(TEST_DIRECTORY, file))));
    }

}
