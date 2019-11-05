<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/25/19
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
</head>

<body>
<br><br><br><br>

<form action="sendMsg" method="post">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center">Send Msg Form
                            </h3>
                            <div class="form-group">
                                <label for="sender">From</label><br>
                                <input type="text" required name="sender" id="sender" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="msg">Message</label><br>
                                <input type="text" required name="msg" id="msg" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="to">To:</label><br>
                                <input type="text" name="to" id="to" class="form-control">

                            </div>
                            <div class="form-group">
                                <select required name="option" id="" class="btn">
                                    <option>SEND BY</option>
                                    <option>AT</option>
                                    <option>NEXMO</option>
                                    <option>INFOBIT</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Send">
                                <input type="reset" name="reset" class="btn btn-danger btn-md" value="Cancel">
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>


    <style>
        body {

        }

        #login .container #login-row #login-column #login-box {
            margin-top: 40px;
            max-width: 600px;
            height: 320px;
        }

        #login .container #login-row #login-column #login-box #login-form {
            padding: 20px;
        }

        #login .container #login-row #login-column #login-box #login-form #register-link {
            margin-top: -75px;
        }
    </style>


</body>

</html>
