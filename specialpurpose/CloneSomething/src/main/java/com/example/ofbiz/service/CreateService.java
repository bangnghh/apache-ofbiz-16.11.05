package com.example.ofbiz.service;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

import java.util.Map;

public class CreateService {
    public static final String module = CreateService.class.getName();

    public static Map<String, Object> createDemProduct(DispatchContext dctx, Map<String, ? extends Object> context){
        Map<String, Object> result = ServiceUtil.returnSuccess("Almost DONE !");
        Delegator delegator = dctx.getDelegator();
        GenericValue demProduct = null;

        try {
            demProduct = delegator.makeValue("DemProduct");
            demProduct.setNextSeqId();
            demProduct.setNonPKFields(context);
            demProduct = delegator.create(demProduct);

            result.put("demProductId", demProduct.getPrimaryKey().toString());
            Debug.log("=======================================================================");
        }catch(GenericEntityException e){
            Debug.logError(e, module);
            return ServiceUtil.returnError("Error in creating record in DemProduct entity ......."+module);
        }
        return result;
    }
}
