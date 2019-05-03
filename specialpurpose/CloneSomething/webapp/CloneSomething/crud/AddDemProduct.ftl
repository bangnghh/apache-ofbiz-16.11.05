<div class="screenlet-body">
    <form id="createDemProductEvent" method="POST" action="<@ofbizUrl>createDemProductEvent</@ofbizUrl>">
        <input type="hidden" name="addDemProductFromFtl" value="Y"/>
        <fieldset>
            <div>
                <span class="label">${uiLabelMap.DemProductType}</span>
                <select name="demProductTypeId" class='required'>
                    <#list demProductTypes as demoType>
                        <option value='${demoType.demProductTypeId}'>${demoType.description}</option>
                    </#list>
                </select>
            </div>
            <div>
                <span class="label">${uiLabelMap.productName}</span>
                <input type="text" name="productName" class='required' maxlength="20"/>
            </div>
            <div>
                <span class="label">${uiLabelMap.comment}</span>
                <input type="text" name="comment" class='inputBox' size="60" maxlength="255"/>
            </div>

        </fieldset>
        <input type="submit" value="${uiLabelMap.CommonAdd}">
    </form>
</div>