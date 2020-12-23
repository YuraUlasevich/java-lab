<#import "parts/common.ftlh" as c>
<@c.page>

<div class="form-row">
    <form method="get" action="/index" class="form-inline">
        <input type="text" name="location" placeholder="Search by location"/>
        <button type="submit">Search</button>
    </form>
</div>



<#list scooters as scooter>
    <div>
        <b>${scooter.location}</b>
        <b>${scooter.producer}</b>
        <b>${scooter.brand}</b>
        <b>${scooter.chargeLevel}</b>
        <b>${scooter.flag}</b>
        <b>
            <form action="/order/${scooter.id}" method="post">
                <button type="submit">Order</button>
                <input type="hidden" value="${_csrf.token}" name="_csrf">
            </form>
        </b>
        <br />
    </div>
    <#else>
        No scooters
</#list>
<br/>
<a href="/about">About page</a>

</@c.page>