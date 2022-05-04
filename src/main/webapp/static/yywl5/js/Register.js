let baseUrl = "http://localhost:8080";

let checkInput = $("#checkInput")[0];  //验证码输入
let userInput = $("#userInput")[0];    //用户名输入
let nickInput = $("#nicknameInput")[0];//昵称输入
let pwInput = $("#pwInput")[0];        //密码输入
let form = $("form")[0];           //form表单
let check = $(".test_er")[0];      //验证码
let user_err = $(".user_err")[0];   //用户名输入错误
let pw_err = $(".pw_err")[0];      //密码输入错误
let test_err = $(".test_err")[0];  //验证码输入错误
//更新验证码
function updateTest() {
    $.ajax({
        type:"GET",
        url:baseUrl+"/toLogin/updateCheck",
        success:function(data){
            check.innerText = data;
        }
    });
}
// 获取输入信息
function handleInputChange() {
    event.target.value=event.target.value.trim();
}
//清除报错
function clear_err() {
    const name = event.target.name;
    if(name === "userName"){
        user_err.innerText = "";
    }
    if(name === "password"){
        pw_err.innerText = "";
    }
    if(name === "check"){
        test_err.innerText = "";
    }
}
//检查输入合法性
function checkInputs () {
    user_err.innerText = "";
    pw_err.innerText = "";
    //检验输入是否为空
    if(checkInput.value === undefined||checkInput.value === ""){
        test_err.innerText = "请输入验证码";
        return false;
    }
    if(nickInput.value === undefined||checkInput.value === ""){
        test_err.innerText = "请输入昵称";
        return false;
    }
    if(userInput.value === undefined||userInput.value === ""){
        user_err.innerText = "用户名不能为空!";
    }
    if(pwInput.value === undefined||pwInput.value === ""){
        pw_err.innerText = "密码不能为空!";
    }
    if((userInput.value === undefined||userInput.value === "")||(pwInput.value === undefined||pwInput.value === "")){
        // 更新验证码
        updateTest();
        return false;
    }
    return true;
}
//表单提交
form.onsubmit=function(){
    event.preventDefault();
    let bl = checkInputs();
    if(bl) {
        event.target.submit();
    }
}

// 快速注册
function fastRegister(){
    let bl = checkInputs();
    if(bl){
        if(window.confirm("是否注册该用户?")){
            $.ajax({
                type:"post",
                url:baseUrl+"/toLogin/register",
                data:getData(),
                success:function(res){success(res)}
            })
        }
    }
}

