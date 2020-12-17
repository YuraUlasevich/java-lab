<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<div>
    <form method="post" action="/index">
        <input type="text" name="location" placeholder="Введите локацию" />
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="checkbox" name="flag" placeholder="Свободен" />
        <input type="text" name="producer" placeholder="Введите производителя" />
        <input type="text" name="brand" placeholder="Введите марку" />
        <input type="number" name="charge_level" placeholder="Введите заряд батареии" />
        <button type="submit">Добавить</button>
    </form>
</div>

<div>
    <form method="get" action="/index">
        <input type="text" name="location""/>
        <button type="submit">Найти</button>
    </form>
</div>



<#list scooters as scooter>
    <div>
    <b>${scooter.id}</b>
    <b>${scooter.location}</b>
    <b>${scooter.producer}</b>
    <b>${scooter.brand}</b>
    <b>${scooter.chargeLevel}</b>
    <br />
    </div>
    <#else>
        No scooters
</#list>
<br/>
<a href="/about">About page</a>
<@l.logout />
</@c.page>