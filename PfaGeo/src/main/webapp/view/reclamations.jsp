<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.model.Reclamations" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reclamations</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
    html,
    body {
        height: 100%;
        margin: 0;
    }
    table {color : red;}
    h1{color:#ffffff;}
    body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: #000000;
    }

    .container {
        flex-grow: 1;
        width: 100%;
        max-width: 800px;
    }

    table {
        margin: 0 auto;
    }

    img {
        max-width: 150px;
        max-height: 150px;
    }
</style>
</head>
<body>
    <h1>Liste des réclamations</h1><br><br>
    <table class="table table-striped">
        <tr>
            <th>Num_rec</th>
            <th>Cin</th>
            <th>Localisation</th>
            <th>Photo</th>
            <th>Etat</th>
        </tr>
        <%
            List<Reclamations> reclamations = (List<Reclamations>) request.getAttribute("reclamations");
            if (reclamations != null && !reclamations.isEmpty()) {
                for (Reclamations rec : reclamations) {
                    %>
                    <tr>
                        <td><%= rec.getNum_rec() %></td>
                        <td><%= rec.getCin() %></td>
                        <td><%= rec.getLocalisation() %></td>
                        <td>
                            <%
                                Blob photo = rec.getPhoto();
                                if (photo != null) {
                                    InputStream inputStream = photo.getBinaryStream();
                                    byte[] bytes = inputStream.readAllBytes();
                                    String base64 = Base64.getEncoder().encodeToString(bytes);
                                    String imageSrc = "data:image/png;base64," + base64;
                                    out.println("<img src=\"" + imageSrc + "\">");
                                } else {
                                    out.println("No photo found.");
                                }
                            %>
                        </td>
                        <td><%= rec.getEtat() %></td>
                    </tr>
                    <%
                }
            } else {
                %>
                <tr>
                    <td colspan="5">No reclamations found.</td>
                </tr>
                <%
            }
        %>
    </table>
</body>
</html>
