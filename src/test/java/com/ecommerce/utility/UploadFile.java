package com.ecommerce.utility;


import com.github.pireba.applescript.AppleScript;

import java.io.IOException;


/**
 * <!-- Apple Script Java Executor -->
 * <dependency>
 * <groupId>com.github.pireba</groupId>
 * <artifactId>applescript</artifactId>
 * <version>0.0.4</version>
 * </dependency>
 * <p>
 * This is a utility class which contains few miscellaneous methods.
 */
public class UploadFile {
    /**
     * This Method is to select a file (Path given for the file)
     */
    public static void selectFileToUpload(String filePath) {
        String hostSystem = System.getProperty("os.name");
        System.out.println(hostSystem);
        hostSystem = hostSystem.toLowerCase();
        if (hostSystem.contains("windows")) {
            String script = System.getProperty("user.dir") + "src\\test\\java\\com\\ecommerce\\utility\\script.vbs";
            try {
                String[] args = {"wscript", script, filePath};
                Runtime.getRuntime().exec(args);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else if (hostSystem.contains("mac")) {
            try {
                String appleScript = "activate application \"###WEBBROWSER###\"\n" +
                        "tell application \"System Events\"\n" +
                        "  delay 3\n" +
                        "  keystroke \"G\" using {command down, shift down}\n" +
                        "  delay 3\n" +
                        "  keystroke \"###PATH###\"\n" +
                        "  delay 2\n" +
                        "  keystroke return\n" +
                        "  delay 2\n" +
                        "  keystroke return\n" +
                        "end tell";
                if ("chrome".contains("chrome")) {
                    appleScript = appleScript.replaceAll("###WEBBROWSER###", "Google Chrome");
                } else if (ConfigReader.getProperty("browser").contains("firefox")) {
                    appleScript = appleScript.replaceAll("###WEBBROWSER###", "Firefox");
                } else if (ConfigReader.getProperty("browser").contains("safari")) {
                    appleScript = appleScript.replaceAll("###WEBBROWSER###", "Safari");
                } else if (ConfigReader.getProperty("browser").contains("firefox")) {
                    appleScript = appleScript.replaceAll("###WEBBROWSER###", "Microsoft Edge");
                } else {
                    System.out.println("Browser Configuration Error");
                    System.out.println("Check configuration.properties file");
                    System.out.println("Check browser");
                }
                String str = "\\";
                filePath = filePath.replace(str, "/");
                appleScript = appleScript.replaceAll("###PATH###", filePath);
                System.out.println(appleScript);
                AppleScript as = new AppleScript(appleScript);
                String result = as.executeAsString();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Script could not executed for MAC");
            }
        } else
            System.out.println("You are not using Mac or Windows, This is not compatible with other OS.");
    }
}
