<#import "parts/common.ftlh" as c>

<@c.page>

    <#list orders as order>
        <div>
            <b>${order.scooter.location}</b>
            <b>${order.scooter.producer}</b>
            <b>${order.scooter.brand}</b>
            <b>${order.user.username}</b>
            <b>${order.status}</b>
            <b>${order.cost}</b>
            <b>
                <a href="admin/${order.id}">Edit</a>
            </b>
            <br />
        </div>
    <#else>
        No orders
    </#list>

</@c.page>