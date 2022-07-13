
let index={

    init: function(){
        $("#btn-login").on("click", () => {
            this.login();
        });
    },
    save: function () {
        let data={
            name:$("#name").val(),
            password:$("#password").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
        }).done(function (resp){
            alert(JSON.stringify(resp));
            location.href = "/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });

    },
}

index.init();