package com.epam.jmp.buildTools;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maksim_Ruts on 10/10/2016.
 */
public class SimpleUtil {
    public static void printMessage(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().println(message);
    }
}
