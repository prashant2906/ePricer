package com.ibm.stax.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common_Functions {


    static String snappath = null;


    public String GetXMLTagValue(String xmlpath, String tagname) {
        String val = null;
        try {
            // Method to get the xml tag value from any given xml
            File f = new File(xmlpath);
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.parse(f);
            final NodeList elementsByTagName = doc.getElementsByTagName(tagname);
            if (elementsByTagName != null) {
                val = elementsByTagName.item(0).getTextContent();
            } else {
                Log.error(tagname + " doesn't exist in the path: " + xmlpath);
                return null;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return val;

    }

    public By locatorParser(String locator) {

        By loc = By.id(locator);

        if (locator.contains("id"))
            loc = By.id(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        else if (locator.contains("name"))
            loc = By.name(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));
        else if (locator.contains("cssSelector"))
            loc = By.cssSelector(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        if (locator.contains("xpath"))
            loc = By.xpath(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        return loc;

    }

    public static String captureScreenshot(WebDriver driver) {

        try {

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with name "screenshot.png"
            String name = scrFile.getName();

            //String snapshotsPath = scrFile.getAbsolutePath();

            String snapshotsPath = FrameConfig.getInstance().getConfig("SnapshotFolderPath");

            File f = new File(snapshotsPath);
            if (f.isDirectory()) {
                try {
                    FileUtils.cleanDirectory(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileUtils.copyFile(scrFile, new File(snapshotsPath + name));
            snappath = snapshotsPath + name;

        } catch (Exception e) {

            System.out.println("Issue with snapshot capture");

        }
        return snappath;
    }

    public static String captureScreenshot1(WebDriver driver, String StepName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //The below method will save the screen shot in d drive with name "screenshot.png"
            //String name = scrFile.getName();
            StepName = StepName.replace(" ", "_");
            String Resultfilename = "";
            String name = Resultfilename + StepName + ".png";
            name = name.replace(".html", "_");
            //  String snapshotsPath = scrFile.getAbsolutePath();
            String snapshotsPath = FrameConfig.getInstance().getConfig("SnapshotFolderPath");
            FileUtils.copyFile(scrFile, new File(snapshotsPath + name));
//            snappath = Constants.snapshotsPath+name;
            snappath = "../Snapshots/" + name;
        } catch (Exception e) {
            System.out.println("Issue with snapshot capture");
        }
        return snappath;
    }


    public static String getFutureDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        String futureDate = sdf.format(cal.getTime());
        return futureDate;
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate = sdf.format(date);
        return currentdate;
    }

    public static String getPastDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        String pastDate = sdf.format(cal.getTime());
        return pastDate;

    }


}
