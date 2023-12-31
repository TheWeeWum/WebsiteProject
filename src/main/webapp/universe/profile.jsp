<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/user-profile.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <script src="js/profile.js"></script>
    <title>User Profile</title>
</head>

<body>

<header>
    <h1>User Profile</h1>
</header>

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
    <a href="universe/buildings">Buildings</a>
    <a href="universe/signup">Signup</a>
    <a href="universe/login">Login</a>
</nav>

<%--    Add sign out button?--%>

<section>
    <% if (session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false))  { %>
        <h1>Please Login to View Profile or Sign up to Start</h1>
    <%} else { %>
        <h1>Welcome, <%= session.getAttribute("username")%></h1>
    <% } %>
</section>

<div id="userContainer"></div>

<%--<section id="favourites">--%>
<%--    <h2>Favourites</h2>--%>
<%--    <div id="favouritesContainer">--%>
<%--        <!-- Favourites content goes here -->--%>
<%--    </div>--%>

<%--    <h2>Your Reviews</h2>--%>
<%--    <div id="reviewContainer">--%>
<%--        <!-- Reviews content goes here -->--%>
<%--    </div>--%>
<%--</section>--%>

<div class="contactInformation">
    <h1>Contact Us</h1>
    <h3>The Gods of the UniVerse</h3>
    <p>
        Evan Wang<br>
        Isabella Nguyen<br>
        Ivan Kraskov<br>
        Liam Csiffary<br>
        Raon Kim<br>
    </p>
</div>

</body>
</html>
