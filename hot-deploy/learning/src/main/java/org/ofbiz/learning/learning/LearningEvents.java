package org.ofbiz.learning.learning;

import org.apache.ofbiz.base.util.UtilHttp;
import org.apache.ofbiz.party.contact.ContactMechWorker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class LearningEvents {
    public static String postalAddressAdvisory(HttpServletRequest request, HttpServletResponse response){
        String partyId = request.getParameter("partyId");
        Map mechMap = new HashMap();
        ContactMechWorker.getContactMechAndRelated(request, partyId, mechMap);
        Map postalAddress = (Map) mechMap.get("postalAddress");
        if (postalAddress == null){
            return "notMars";
        }

        String planet = (String) postalAddress.get("planet");
        if(postalAddress == null || !planet.equalsIgnoreCase("Mars")){
            return "notMars";
        } else {
            return "isMars";
        }
    }

    public static String processFirstForm(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        request.setAttribute("combined", firstName + " " + lastName);
        request.setAttribute("allParams", UtilHttp.getParameterMap(request));
        request.setAttribute("submit", "Da Submmit");
        return "success";
    }

    public static String processListForm(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        request.setAttribute("combined",firstName+ " - "+lastName);
        request.setAttribute("allParams",UtilHttp.getParameterMap(request));
        request.setAttribute("submit","Submitted");
        return "success";
    }

    public static String processMultiForm(HttpServletRequest request, HttpServletResponse response){
        Collection parsed = UtilHttp.parseMultiFormData(UtilHttp.getParameterMap(request));

        List combined = new ArrayList();
        Iterator parsedIterator = parsed.iterator();

        while (parsedIterator.hasNext()){
            Map record = (Map) parsedIterator.next();
            combined.add(record.get("firstName") + " " + record.get("lastName"));
        }
        request.setAttribute("combined", combined);
        request.setAttribute("allParams", UtilHttp.getParameterMap(request));
        request.setAttribute("submit", "Already submitted");
        return "success";
    }
}
