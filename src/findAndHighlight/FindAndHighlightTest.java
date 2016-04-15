/**
 * 
 */
package findAndHighlight;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;



/**
 * @author Erin
 *
 */
public class FindAndHighlightTest {

	@Test
	public void testPath1Method() {
		String path = UtilsFAH.getPath1(); 
		File f = new File(path);
		
		Assert.assertEquals(true, f.isFile());
	}
	
	@Test
	public void testPath2Method() {
		String path = UtilsFAH.getPath2(); 
		File f = new File(path);
		
		Assert.assertEquals(true, f.isFile());
	}
	
	@Test
	public void testPath3Method() {
		int x = 0;
		String path = UtilsFAH.getPath3(x); 
		File f = new File(path);
		
		Assert.assertEquals(true, f.isFile());
	}
	
	

}
