<#import "parts/common.ftlh" as c>
<@c.page>
    List of users
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
        </tr>
        </thead>
    </table>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.role as r>${r} <#sep>, </#list></td>
            <td><a href="/user/${user.id}">Edit</a></td>
            <br/>
        </tr>
    </#list>
    </tbody>
</@c.page>