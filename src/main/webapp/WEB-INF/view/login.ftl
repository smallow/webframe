<html lang="en">
<head>
    <meta charset="UTF-8">
    <#include "./common/header.ftl">
    <title>BD - 登录</title>
</head>
<body>
<div class="text-center">
    <div style="padding: 100px 0px;">
        <div>
            <h1 class="logo-name">BD</h1>
        </div>
        <h3>欢迎使用 Badminton</h3>
        <br/>

        <form class="form-horizontal"   action="${ctxPath}/login" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-4">
                    <input type="text"  class="form-control" id="userName" name="userName"
                           placeholder="请输入账号">
                </div>
            </div>
            <div class="form-group">
                <label for="pwd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="pwd" name="password"
                           placeholder="请输入密码">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-4">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>