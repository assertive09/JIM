<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Student Login</title>
</head>
<style>
    body {
        background: url("/resources/img/home.jpeg");
        background-repeat: no-repeat;
        background-size: 1500px;
    }

    .center {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
           
        }

        /* Set form size */
        .form-container {
            width: 500px;
            height: 400px;
            padding: 30px;
             background-color: black;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
</style>
<body>
    <div class="container center">
        <div class="form-container">
            <h1 class="text-center mb-2 text-white">Student Login</h1>
            <form method="post" action="/checkValidStudent">

                <div class="form-group">
                    <label for="email" class=" text-white">Email:</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group mb-3">
                    <label for="password"  class=" text-white">Password:</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
                </div>
                <a href="/forget_password">Forget Password</a>
                <br>
                <span class="text-white">OR</span><br>
                <a href="/signup_student">Create an account</a>
                <br>
                <div class="container text-center">
                <button type="submit" class="btn btn-primary">Login</button>
                &nbsp;&nbsp;&nbsp;
                <button type="reset" class="btn btn-primary">Clear</button>
            </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>


</html>