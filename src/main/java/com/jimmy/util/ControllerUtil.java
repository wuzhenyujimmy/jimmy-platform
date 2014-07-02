package com.jimmy.util;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtil {
    public static void setCommonRequestProperties(HttpServletRequest request, String module, String action) {
        request.setAttribute("module", module);
        request.setAttribute("action", action);
        request.setAttribute("urlPosition", UrlPositionUtil.getUrlPosition(request));
    }

}
