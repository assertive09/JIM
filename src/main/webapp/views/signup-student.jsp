<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>SignUp||JIM</title>
</head>
<style>
    /* Set form size */
    .form-container {
        width: 600px;;
        height: auto;
        padding: 30px;
        background-color: black;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
</style>

<body>
    <div class="masthead" style="background-image: url('/resources/img/home.jpeg');">
        <div class="color-overlay d-flex justify-content-center align-items-center">
            <div class="container center text">
                <div class="form-container">
                    <h1 class="text-center mb-2 text-white">Student SignUp</h1>
                    <form method="post" action="/createaccount">
                        <div class="form-group">
                            <label for="name" class=" text-white">Name:</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Enter your name" required>
                        </div>
                        <div class="form-group">
                            <label for="email" class=" text-white">Email:</label>
                            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class=" text-white">Password:</label>
                            <input type="password" name="password" class="form-control" id="password"
                                placeholder="Enter password" required>
                        </div>
                        <div class="form-group">
                            <label for="mobile" class="text-white">Mobile number:</label>
                            <input type="tel" class="form-control " name="mobileNumber" id="mobile"
                                placeholder="Enter your mobile number" required>
                        </div>
                        <div class="form-group mb-3">
                            <label for="address" class="text-white">Address:</label>
                            <textarea name="address" class="form-control" id="address" rows="3"
                                placeholder="Enter your address" required></textarea>
                        </div>
                        <div class="container text-center ">
                            <button type="submit" class="btn btn-primary ">Create Account</button>
                            &nbsp;&nbsp;&nbsp;
                            <button type="reset" class="btn btn-primary">Clear</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>


</html>