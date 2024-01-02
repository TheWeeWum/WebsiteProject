<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <title>UniVerse</title>
</head>
<body>
<!--    NAVBAR-->
<nav>
    <a href="index">Home</a>
    <a href="universe/mainmap">Main Map</a>
    <div class="dropdown">
        <a class="dropbtn">Profile</a>
        <div class="dropdown-content">
            <a href="universe/favourites">Favourites</a>
            <a href="universe/reviews_page">Reviews</a>
            <a href="universe/profile">Profile</a>
        </div>
    </div>
    <a href="universe/about">About</a>
    <a href="universe/signup">Signup</a>
    <a href="universe/login">Login</a>
    <a href="universe/buildings">Buildings</a>

    <!-- Add more links as needed -->
</nav>

<header>
    <h1>Login</h1>
</header>

<form action="universe/login" method="post">
    <div class="input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
    </div>

    <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
    </div>

    <input class="login-button" type="submit" value="Login">
</form>

<!--   if the getAttribute("errorMessage") of the request isn't null, then there's an error with the Sign-Ip.-->
<% if (request.getAttribute("errorMessage") != null) { %>
<div class="error-frame">
    <div class="error-message">
        <%-- Display error message here --%>
        <p class="error-text"><%= request.getAttribute("errorMessage")%></p>
    </div>
</div>
<% } %>

</body>
</html>
