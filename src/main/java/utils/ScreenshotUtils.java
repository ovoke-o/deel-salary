package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void captureScreenshot(Page page, String name) throws FileNotFoundException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String directory = "screenshots";
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();

        String filename = directory + "/" + name + "_" + timestamp + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filename)).setFullPage(true));
        Allure.addAttachment(name, "image/png", new FileInputStream(filename), ".png");
    }
}
