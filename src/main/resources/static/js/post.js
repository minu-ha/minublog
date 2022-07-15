let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.delete();
        });
    },
    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/post/",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("글쓰기완료");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },

    delete: function () {
        let id = $("#id").val();

        $.ajax({
            type: "DELETE",
            url: "/api/post/" + id,
            dataType: "json",
        }).done(function (res) {
            alert("글삭제완료");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

index.init();
