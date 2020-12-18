<#import "parts/common.ftlh" as c>
<@c.page>
    User editor
    <form action="/user" method="post">
        <input type="hidden" value="${user.id}" name="userId">
        <input type="text" value="${user.username}" name="username">
        <#list role as r>
            <div>
                <label><input type="checkbox" name="${r}" ${user.role?seq_contains(r)?string("checked", "")}>${r}</label>
            </div>
        </#list>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>