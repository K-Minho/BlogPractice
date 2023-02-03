<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3">
            <div class="container">
                <form action="/join" method="post" onsubmit="return valid(), valpassword(), valclick()">
                    <div class="d-flex form-group mb-2">
                        <input type="text" name="username" class="form-control" placeholder="Enter username"
                            id="username" required>
                        <button class="badge bg-secondary ms-2" type="button" onclick="sameCheck()">중복확인</button>
                    </div>
                    <div class="usernameBox"></div>

                    <div class="form-group mb-2">
                        <input type="password" name="password" class="form-control" placeholder="Enter password"
                            id="password" required>
                    </div>

                    <div class="form-group mb-2">
                        <input type="password" class="form-control passwordCheck" placeholder="Enter passwordCheck"
                            required>
                    </div>
                    <div class="alert alert-danger checkPasswordBox" style="display: none;">
                        비밀번호가 다릅니다.
                    </div>
                    <div class="form-group mb-2">
                        <input type="email" name="email" class="form-control" placeholder="Enter email" id="email"
                            required>
                    </div>

                    <button type="submit" class="btn btn-primary">회원가입</button>
                </form>

            </div>
        </div>

        <script>

            let check = false;
            let checkclick = false;

            function valclick() {
                if (checkclick) {
                    return true;
                } else {
                    alert("중복체크를 해주세요");
                    return false;
                }
            }

            $("#username").keydown(() => {
                if (check == true) {
                    check = false;
                }
            });

            function valid() {
                if (check) {
                    return true;
                } else {
                    return false;
                }
            }

            function sameCheck() {
                let username = $("#username").val();
                $.ajax({
                    type: "get",
                    url: "/user/username-samecheck?username=" + username
                }).done(res => {
                    $(".idTrue").remove();
                    $(".idFalse").remove();
                    console.log(res);
                    check = res.object;
                    checkclick = true;
                    if (check) {
                        $(".usernameBox").append(`<div class="alert alert-success idTrue">사용 가능한 ID입니다.</div>`);
                    } else {
                        $(".usernameBox").append(`<div class="alert alert-danger idFalse">사용 불가능한 ID입니다.</div>`);
                    }
                }).fail(err => { });
            }

            function valpassword() {
                let password = $("#password").val();
                console.log("password : ", password);
                let passwordCheck = $(".passwordCheck").val();
                console.log("passwordCheck : ", passwordCheck);
                if (password != passwordCheck) {
                    $(".checkPasswordBox").show();
                    return false;
                }
                return true;
            }
        </script>

        <%@ include file="../layout/footer.jsp" %>