package com.example.ofbiz.events;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTypeEvent {
    public static final String module = CreateTypeEvent.class.getName();

    public static String createDemProductTypeEvent(HttpServletRequest request, HttpServletResponse response){
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String demProductTypeId = request.getParameter("demProductTypeId");
        String description = request.getParameter("description");

        if(UtilValidate.isEmpty(demProductTypeId) || UtilValidate.isEmpty(description)){
            String errMsg = "Điền đầy đủ thông tin please";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        try{
            Debug.logInfo("======================= Create DemProductType record in event using service createDemProductTypeInJava ======",module);
            dispatcher.runSync("createDemProductTypeInJava", UtilMisc.toMap("demProductTypeId", demProductTypeId,"description", description,"userLogin", userLogin));
        } catch (GenericServiceException e) {
            String errMsg = "Ko the tao dc records trong DemProductType entity: " +e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "Khoi tao thanh cong !");
        return "success";
    }
}
