<#macro login path isRegisterForm>

    <form action="${path}" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> User Name : </label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <#if isRegisterForm>
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Email: </label>
            <div class="col-sm-6">
                <input type="email" name="email" placeholder="some@some.com"/>
            </div>
        </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#if !isRegisterForm><a href="/registration">Registration</a></#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Register<#else>Sign In</#if></button>
    </form>

</#macro>

<#macro logout>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="btn btn-primary" type="submit">Log Out</button>
        </form>
</#macro>