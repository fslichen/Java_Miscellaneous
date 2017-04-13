package evolution;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class ResourceUtilTest {
	@Test
	public void testProperties() throws IOException {
		Map<String, String> map = ResourceUtil.properties("application", String.class, String.class);
		System.out.println(map);
	}
}
