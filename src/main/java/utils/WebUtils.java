package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WebUtils {

    public static void selectDropdownOption(Page page, String placeholder, String targetOption) {
        Locator input = page.locator("input[placeholder='" + placeholder + "']");
        input.click();

        Locator listOptionLi = page.locator("li[role='option']");
        Locator listOptionDiv = page.locator("div[role='option']");

        Locator options;
        if (listOptionLi.count() > 0) {
            options = listOptionLi;
        } else if (listOptionDiv.count() > 0) {
            options = listOptionDiv;
        } else {
            throw new RuntimeException("No dropdown options found for placeholder: " + placeholder);
        }

        options.first().waitFor();

        boolean found = false;
        int count = options.count();

        for (int i = 0; i < count; i++) {
            Locator option = options.nth(i);
            String text = option.textContent().trim();

            if (text.equalsIgnoreCase(targetOption)) {
                option.scrollIntoViewIfNeeded();
                option.click();
                System.out.println("Selected: " + text);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("Option '" + targetOption + "' not found under '" + placeholder + "'");
        }
    }
}
