<html lang="en">
<head>
    <link rel="stylesheet" href="/users.css", type="text/css">
</head>
<body>
<div class="container">
    <h2>USERS</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">ID</div>
            <div class="col col-2">LOGIN</div>
            <div class="col col-3">PASSWORD</div>
        </li>
        <#list users as user>
        <li class="table-row">
            <div class="col col-1">${user.id}</div>
            <div class="col col-2">${user.login}</div>
            <div class="col col-3">${user.password}</div>
        </li>
    </#list>
</ul>
</div>
</body>
        </html>