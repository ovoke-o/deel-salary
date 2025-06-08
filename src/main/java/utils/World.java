package utils;

import com.microsoft.playwright.Page;

public class World {
    private static Page page;

    public static Page getPage() {
        return page;
    }

    public static void setPage(Page p) {
        page = p;
    }
}
