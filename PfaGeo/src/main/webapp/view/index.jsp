<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
    html, body {
        height: 100%;
    }
    
    form,
    input {
        color: red
    }
    
    label {
        color: #ffffff
    }
    
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: #000000;/* Replace with your desired background color */
       
    }
    
    .logo {
        position: absolute;
        top: 10px;
        left: 10px;
        width: 480px; /* Adjust the width as per your image */
        height: 210px; /* Adjust the height as per your image */
    }
</style>
</head>

<body class="vh-100">
    <img alt="Logo" src="file:///C:/spring%20projects/PfaGeo/src/main/webapp/view/logo.jpg" class="logo">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="/reclamations" method="POST" class="form-group">
                    <label>Entrer la municipalité :</label><br>
                    <input type="text" name="baladia"><br>
                    <input type="submit" value="Save">
                </form><br>
            </div>
        </div>
    </div>
</body>

</html>
