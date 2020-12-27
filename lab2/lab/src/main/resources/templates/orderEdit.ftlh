<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/order/admin/${order.id}" method="post">
        <b>${order.id}</b>
        <input type="number" value="${order.cost}" name="cost">
        <input type="text" value="${order.status}" name="status">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>