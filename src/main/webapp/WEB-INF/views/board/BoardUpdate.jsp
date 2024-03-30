<%--
  Created by IntelliJ IDEA.
  User: WhiteKIM
  Date: 2024-03-28
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>게시글 작성</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        .require {
            color: #666;
        }
        label small {
            color: #999;
            font-weight: normal;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1>게시글 수정</h1>
            <form action="/api/board/update" method="POST">
                <input id="id" name="id" hidden="hidden">
                <div class="form-group has-error">
                    <label for="image">이미지 <span class="require">*</span> <small>(썸네일 이미지.)</small></label>
                    <input type="file" accept="image/*" class="form-control" id="image" name="image" />
                </div>
                <div class="form-group">
                    <label for="title">Title <span class="require">*</span></label>
                    <input type="text" id="title" class="form-control" name="title" value="${board.title}"/>
                </div>
                <div class="form-group">
                    <label for="content">Description</label>
                    <textarea rows="5" id="content" class="form-control" name="content" >${board.content}</textarea>
                </div>
                <div class="form-group">
                    <p><span class="require">*</span> - required fields</p>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">
                        Create
                    </button>
                    <button class="btn btn-default">
                        Cancel
                    </button>
                    <button class="btn btn-default" onclick="deletePost()">
                        Delete
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    let input_id = document.getElementById('id');
    let split = window.location.href.split("/");
    input_id.value = split[4];

    function deletePost() {
        fetch('api/board/${board.id}', {
            method : 'delete'
        });
    }
</script>
</body>
</html>