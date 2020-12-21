<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as r>
<@c.page>
    <div class="mb-1">Registration</div>
    ${message?ifExists}
    <@r.login "/registration" true/>
</@c.page>