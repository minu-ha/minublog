$('#insert').click(function () {
    var jsonData = JSON.stringify({
        title: $('#board_title').val(),
        subTitle: $('#board_sub_title').val(),
        content: $('#board_content').val(),
        boardType: $('#board_type option:selected').val()
    });
    $.ajax({
        url: "http://localhost:8080/api/boards",
        type: "POST",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            alert('저장 성공!');
            location.href = '/board/list';
        },
        error: function () {
            alert('저장 실패!');
        }
    });
});

$('#update').click(function () {
    var jsonData = JSON.stringify({
        title: $('#board_title').val(),
        subTitle: $('#board_sub_title').val(),
        content: $('#board_content').val(),
        boardType: $('#board_type option:selected').val(),
        createdDate: $('#board_create_date').val()
    });
    $.ajax({
        url: "http://localhost:8080/api/boards/" + $('#board_id').val(),
        type: "PUT",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            alert('수정 성공!');
            location.href = '/board/list';
        },
        error: function () {
            alert('수정 실패!');
        }
    });
});
$('#delete').click(function () {
    $.ajax({
        url: "http://localhost:8080/api/boards/" + $('#board_id').val(),
        type: "DELETE",
        success: function () {
            alert('삭제 성공!');
            location.href = '/board/list';
        },
        error: function () {
            alert('삭제 실패!');
        }
    });
});

