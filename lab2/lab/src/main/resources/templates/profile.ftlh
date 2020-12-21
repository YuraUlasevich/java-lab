<#import "parts/common.ftlh" as c>

<@c.page>
    ${message?ifExists}
    <h5>${username}</h5>
    <form method="post" action="/user/profile">
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="Password"/>
            </div>
        </div>
            <div class="form-group">
                <label class="col-sm-2 col-form-label"> Email: </label>
                <div class="col-sm-6">
                    <input type="email" name="email" placeholder="some@some.com" value="${email!''}"/>
                </div>
            </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit">Save</button>
    </form>
</@c.page>