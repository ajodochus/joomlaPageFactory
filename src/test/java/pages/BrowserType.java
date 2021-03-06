package pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.StringUtils;

import utils.UnknownBrowserException;

public enum BrowserType {
    FIREFOX,
    IE,
    GC,
    OPERA,
    HTMLUNIT;

    private static Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

    static {
        browsersMap.put("firefox", BrowserType.FIREFOX);
        browsersMap.put("ie", BrowserType.IE);
        browsersMap.put("gc", BrowserType.GC);
        browsersMap.put("opera", BrowserType.OPERA);
        browsersMap.put("htmlunit", BrowserType.HTMLUNIT);
    }

    public static BrowserType Browser(String name) {
        BrowserType browserType = browsersMap.get(name.toLowerCase().trim());
        if (browserType == null) {
            throw new UnknownBrowserException("Unknown browser [" + name + "]. Use one of following: "
                    + StringUtils.join(browsersMap.keySet().toArray(), ", "));
        }
        return browserType;
    }
}
