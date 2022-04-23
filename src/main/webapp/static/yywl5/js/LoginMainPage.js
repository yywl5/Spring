let baseUrl = "http://localhost:8080";

//修改用户昵称
function updateUserName(){
    if(window.confirm("确认修改用户名？")){
        let name = window.prompt("请输入新昵称:");
        $.ajax({
            type:"post",
            url:baseUrl+"/toLogin/updateUserName",
            data:{username:name},
            success:function (res) {
                let req = JSON.parse(res);
                alert(req.data);
                if(req.status===0){
                    window.location.href = baseUrl+"/toLogin";
                }else{
                    window.location.href = baseUrl+"/freeLogin";
                }
            }
        })
    }
}
