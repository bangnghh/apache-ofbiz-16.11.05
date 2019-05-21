package org.ofbiz.learning.learning;

import org.apache.ofbiz.party.contact.ContactMechWorker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


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
}
