package com.example.ofbiz.service;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

import java.util.Map;

public class CreateTypeService {

    public static final String module = CreateTypeService.class.getName();

    public static Map<String, Object> createDemProductType (DispatchContext dctx, Map<String, ? extends Object> context){
        Map<String, Object> result = ServiceUtil.returnSuccess("Successfully!");
        Delegator delegator = dctx.getDelegator();
        GenericValue demProductType = null;

        try{
            demProductType = delegator.makeValue("DemProductType");
            demProductType.setPKFields(context);
            demProductType.setNonPKFields(context);
            demProductType = delegator.create(demProductType);


            //result.put("demProductTypeId", demProductType.getString("demProductTypeId"));
            Debug.log("=======================================================================");
        } catch (GenericEntityException e) {
            Debug.logError(e, module);
            return ServiceUtil.returnError("Error in creating record in DemProductType entity ......."+module);
        }
        return result;
    }
}
