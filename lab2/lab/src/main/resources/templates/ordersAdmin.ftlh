<#import "parts/common.ftlh" as c>

<@c.page>

    <#list scooters as scooter>
        <div>
            <b>${scooter.location}</b>
            <b>${scooter.producer}</b>
            <b>${scooter.brand}</b>
            <b>${scooter.chargeLevel}</b>
            <b>${scooter.flag}</b>
            <b>
                <a href="admin/${scooter.id}">Edit</a>
            </b>
            <br />
        </div>
    <#else>
        No scooters
    </#list>

</@c.page>