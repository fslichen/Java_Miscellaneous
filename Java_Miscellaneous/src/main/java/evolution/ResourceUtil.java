package evolution;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ResourceUtil {
	@SuppressWarnings("unchecked")
	public static <T, V> Map<T, V> properties(String location, Class<T> t, Class<V> v) throws IOException {
		if (location.charAt(0) != '/') {// Add the missing leading /.
			location = '/' + location;
		}
		int length = location.length();// Add the missing properties extension.
		if (!".properties".equals(location.substring(length - ".properties".length(), length))) {
			location += ".properties";
		}
		InputStream inputStream = ResourceUtil.class.getResourceAsStream(location);
		Properties properties = new Properties();
		properties.load(inputStream);
		Map<T, V> propertyMap = new LinkedHashMap<>();
		for (Entry<Object, Object> entry : properties.entrySet()) {
			propertyMap.put((T) entry.getKey(), (V) entry.getValue());
		}
		return propertyMap;
	}
}
