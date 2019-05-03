package com.example.ofbiz.events;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CreateEvents {
    public static final String module = CreateEvents.class.getName();

    public static String createDemProductEvent(HttpServletRequest request, HttpServletResponse response){
        //Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String demProductTypeId = request.getParameter("demProductTypeId");
        String productName = request.getParameter("productName");
        String comment = request.getParameter("comment");

        if(UtilValidate.isEmpty(productName) || UtilValidate.isEmpty(comment) || UtilValidate.isEmpty(demProductTypeId)){
            String errMsg = "Product name field can't be empty";

            request.setAttribute("_ERROR_MESSAGE_",errMsg);
            return "error";
        }

        try {
            Map context = UtilMisc.toMap("demProductTypeId", demProductTypeId,
                    "productName", productName, "comment", comment, "userLogin", userLogin);
            Debug.logInfo("======================= Create DemProduct record in event using service createDemProductInJava======",module);

            dispatcher.runSync("createDemProductInJava", context);

        } catch (GenericServiceException e) {
            String errMsg = "Ko the tao dc records trong DemProduct entity: " +e.toString();
            request.setAttribute("_ERROR_MESSAGE_",errMsg);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "Khoi tao thanh cong !");
        return "success";
    }
}
