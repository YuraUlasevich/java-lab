<#import "parts/common.ftlh" as c>
<@c.page>
    Добавить самокат
    <div>
        <form method="post" action="/scooterwork">
            <input class="form-control ${(textError??)?string('is-invalid', '')}" type="text" name="location" placeholder="Введите локацию" />
            <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="text" name="producer" placeholder="Введите производителя" />
            <input type="text" name="brand" placeholder="Введите марку" />
            <input type="number" name="charge_level" placeholder="Введите заряд батареии" />
            <button type="submit">Добавить</button>
        </form>
    </div>

    Список самокатов
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

</@c.page>