package org.ofbiz.learning.learning;

import org.apache.ofbiz.base.util.UtilHttp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class OfbizDemoEvents {
    public static String processFirstForm(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String combined = firstName + " " +lastName;

        request.setAttribute("combined", combined);
        request.setAttribute("allParams", UtilHttp.getParameterMap(request));
        request.setAttribute("submit", "Submition");

        return "success";
    }

    public static String processListForm(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String combined = firstName + " " +lastName;

        request.setAttribute("combined", combined);
        request.setAttribute("allParams", UtilHttp.getParameterMap(request));
        request.setAttribute("submit", "Submitted");

        return "success";
    }

    public static String processMultiForm(HttpServletRequest request, HttpServletResponse response){
        Collection parsed = UtilHttp.parseMultiFormData(UtilHttp.getParameterMap(request));
        Iterator parsedIte = parsed.iterator();

        List combined = new ArrayList();
        while(parsedIte.hasNext()){
            Map record = (Map) parsedIte.next();
            combined.add(record.get("firstName") + " - " + record.get("lastName"));
        }

        request.setAttribute("combined", combined);
        request.setAttribute("allParams", UtilHttp.getParameterMap(request));
        request.setAttribute("submit", "Submitted");

        return "success";
    }
}
