<#import "parts/common.ftlh" as c>
<@c.page>
    <#list scooters as scooter>
        <div>
            <b>${scooter.location}</b>
            <b>${scooter.producer}</b>
            <b>${scooter.brand}</b>
            <b>${scooter.chargeLevel}</b>
            <b>${scooter.flag}</b>
            <br />
        </div>
        <#else>
            No orders
    </#list>


</@c.page>