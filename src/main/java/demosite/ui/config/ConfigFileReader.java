package demosite.ui.config;



import demosite.ui.enums.DriverType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static Properties properties;
    private static final String propertiesPath = System.getProperty("user.dir") + "//src//test//resources//cucumber.properties";

    public  ConfigFileReader() {
        BufferedReader bufferedReader;// TO be updatedas
        try {

            InputStream inputStream = new FileInputStream(propertiesPath);
            properties = new Properties();
            try {
                properties.load(inputStream);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to read properties file at" + propertiesPath);
        }
    }

    public static String getApplicationURL() {
        String applicationURL = properties.getProperty("URL");
        if (applicationURL != null) {
            return applicationURL;
        } else {
            throw new RuntimeException("No URL specified in properties file at: " + propertiesPath + ". Please specify the correct URL");
        }
    }

    public DriverType getBrowserType() {
        String browser = properties.getProperty("browserName");
        if (browser != null || browser.equalsIgnoreCase("chrome")) {
            return DriverType.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else if (browser.equalsIgnoreCase("edge")) {

            return DriverType.EDGE;
        } else {
            throw new RuntimeException("No browser name specified in properties file at: " + propertiesPath + ". Please specify the correct Browser name");
        }
    }

    public static String getExtentReportPath()
    {
        String extentReportPath = System.getProperty("user.dir")+"//extent-config.xml";
        if(extentReportPath!=null)
        {
            return  extentReportPath;

        }
        else
        {
            throw new RuntimeException("Extent Report path is not specified properly in the properties file for the key: extentReportConfigPath. Please specify the same!");
        }

    }
}
