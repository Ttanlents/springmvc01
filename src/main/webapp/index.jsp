<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<script src="/js/jquery-1.7.2.js" type="text/javascript"></script>

<h2>Hello World!</h2>
账号<input type="text" name="name" id="name"/>
密码<input type="password" name="password" id="password"/>
<input id="but" type="button" value="get"/>
<br/>
账号<input type="text" name="name" id="name2"/>
密码<input type="password" name="password" id="password2"/>


爱好
<form action="/demo.form" method="post">
    <input type="checkbox" name="hobbys[0]" id="ids" value="1"/>
    <input type="checkbox" name="hobbys[1]" value="2"/>
    <input type="checkbox" name="hobbys[2]" value="3"/>
    <input type="submit" value="提交"/>
</form>

<form action="/demo2.form" method="post">
    <input type="text" name="map['username']"><br>
    <input type="text" name="map['password']"><br>
    <input type="text" name="map['age']"><br>
    <input type="submit" value="map对象参数绑定"><br>
</form>
<br/>
<a href="/demo3.form">demo3</a>
<a href="/demo4.form">demo4</a>
<a href="/demo5.form">demo5</a>
<a href="/demo6.form">demo6</a>

<form action="/demo7.form" method="post">
    <input type="text" name="name" />
    <input type="text" name="password" />
    <input type="text" name="age" />
    <input type="date" name="date"/>
    <input type="submit" value="日期提交"/>
</form>
<br/>
<br/>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="文件提交"/>
</form>

<form action="/uploads" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple="multiple"/>
    <input type="submit" value="文件提交"/>
</form>


</body>
<script>

    $(function () {
        $('#but').click(function () {
            var name=$('#name').val();
            var password=$('#password').val();
            var json={"name":name,"password":password}
            console.log(name)
            console.log(password)
            $.ajax({
                url:'/demo9',
                contentType:"application/json;charset=utf-8",
                type:'post',
                data:JSON.stringify(json),
                dataType:'json',
                ayc:'true',
                success:function (data) {
                    alert(JSON.stringify(data))
                    if (data.code==200){
                        console.log("success")
                        var name=data.user.name;
                        var password=data.user.password;
                        $('#name2').val(name)
                        $('#password2').val(password)
                    }
                }
            });
        });
    });
</script>
</html>
