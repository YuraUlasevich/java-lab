<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@l.login "/login" />
    <h1>Авторизация</h1>
    <a href="/registration">Registration</a>

</@c.page>