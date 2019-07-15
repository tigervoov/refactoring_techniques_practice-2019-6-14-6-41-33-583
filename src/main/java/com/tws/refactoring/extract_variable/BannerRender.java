package com.tws.refactoring.extract_variable;

public class BannerRender {
    private  static final String MAC="MAC";
    private  static final String IE="IE";
    String renderBanner(String platform, String browser) {
        boolean isCheckStr = (platform.toUpperCase().contains(MAC)) &&
                (browser.toUpperCase().contains(IE));
        if (isCheckStr) {
            return "IE on Mac?";
        }
        return "banner";
    }
}
