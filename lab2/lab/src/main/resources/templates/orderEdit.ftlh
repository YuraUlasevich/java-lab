<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/order/admin/${scooter.id}" method="post">
        <input type="hidden" value="${scooter.id}" name="userId">
        <input type="text" value="${scooter.location}" name="location">
        <input type="text" value="${scooter.flag}" name="flag">
        <input type="number" value="${scooter.charge_level}" name="charge_level">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>