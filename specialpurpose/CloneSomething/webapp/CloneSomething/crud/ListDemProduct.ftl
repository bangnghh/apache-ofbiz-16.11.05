<div class="screenlet-body">
    <#if demProductList?has_content>
        <table cellspacing="0" cellpadding="2" border="0" class="basic-table">
            <thead>
                <tr>
                    <th>${uiLabelMap.demProductId}</th>
                    <th>${uiLabelMap.demProductTypeId}</th>
                    <th>${uiLabelMap.productName}</th>
                    <th>${uiLabelMap.comment}</th>
                </tr>
            </thead>
            <tbody>
                <#list demProductList as demProduct>
                    <tr>
                        <td>${demProduct.demProductId}</td>
                        <td>${demProduct.getRelatedOne("DemProductType").get("description", locale)}</td>
                        <td>${demProduct.productName?default("N/A")}</td>
                        <td>${demProduct.comment!}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</div>