<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>UniVerse</title>
    <link rel="stylesheet" href="css/standard_background.css">
    <link rel="stylesheet" href="css/buildings.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <script src="js/buildings.js"></script>
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
    <h1>Buildings</h1>
</header>

<!-- Container for building sections -->
<div id="buildingsContainer">
</div>

<!-- Load More button -->
<button id="loadMoreButton" onclick="loadMoreBuildings()"> Load More Buildings ↓</button>


</body>
</html>
