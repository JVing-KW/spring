<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>글 읽기</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                            <a class="nav-link" href="#">Features</a>
                            <a class="nav-link" href="#">Pricing</a>
                            <a class="nav-link disabled">Disabled</a>
                        </div>
                    </div>
                </div>
            </nav>


        </div>


    </div>

    <!-- header end -->
    <!-- 기존의 <h1>Header</h1>끝 -->
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    해야할 일
                </div>
                <div class="card-body">

                    <div class="input-group mb-3">
                        <span class="input-group-text">글번호</span>
                        <input type="text" name="tno" class="form-control"
                               value='<c:out value="${dto.tno}"></c:out>' readonly>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">글제목</span>
                        <input type="text" name="title" class="form-control"
                               value='<c:out value="${dto.title}"></c:out>' readonly>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">완료 예정일</span>
                        <input type="date" name="dueDate" class="form-control"
                               value='<c:out value="${dto.dueDate}"></c:out>' readonly>

                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">누가</span>
                        <input type="text" name="writer" class="form-control"
                               value='<c:out value="${dto.writer}"></c:out>' readonly>

                    </div>

                    <div class="form-check">
                        <label class="form-check-label" >
                            완료 여부 &nbsp;
                        </label>
                        <input class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""} disabled >
                    </div>


                    <div class="my-4">
                        <div class="float-end">
                            <button type="button" class="btn btn-primary">수정 / 삭제</button>
                            <button type="button" class="btn btn-secondary">글 목록</button>
                        </div>
                    </div>



                    <script>

                        document.querySelector(".btn-primary").addEventListener("click", function (e) {

                            self.location = "/todo/modify?tno=" + ${dto.tno}

                        }, false)

                        document.querySelector(".btn-secondary").addEventListener("click", function(e){
                            self.location = "/todo/list";
                        },false)
                    </script>


                </div>


            </div>



        </div>




    </div>



</div>


</body>
</html>