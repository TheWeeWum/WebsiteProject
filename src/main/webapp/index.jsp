<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liam Csiffary - Personal Website</title>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/background.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/index.css">
    <!-- <link rel="javascript" href="js/index.js"> -->
</head>
<body>

<header>
    <h1>Liam Csiffary</h1>
    <p>CS Enthusiast</p>
</header>

<nav id="nav">
    <a href="about">About Me</a>
    <a href="projects">Projects</a>
    <a href="contact">Contact</a>
</nav>

<main id="main">
    <section id="about">
        <h2>About Me</h2>
        <p>
            (See About Me page above for a more detailed rendition)<br><br>
            Hello! I'm Liam Csiffary, a current undergraduate student at the University of Toronto. I'm double majoring in Computer Science and Physics, with a minor in Mathematics. My interest in technology began early - tinkering with toys and exploring broken computers at scout camp.
            <br><br>
            I got hands-on experience with a Raspberry Pi, sparking my curiosity in coding. Starting with JavaScript on Khan Academy, I moved on to Python using VSCode. Exploring C++ showed me the speed advantage in programming.
            <br><br>
            In school, I delved into Java and Swift, focusing on Object-Oriented Programming. In high school, I went beyond Unity tutorials, creating a roguelike RPG game from scratch, earning praise for its complexity.
            <br><br>
            Venturing into C# Unity, I expanded my coding skills. Collaborating with my brother, we worked on joint game development projects, adding more diversity to my skill set.
            <br><br>
            Nine years into coding, I still enjoy problem-solving and learning new things. I look forward to the challenges ahead in the ever-evolving field of computer science.
        </p>
    </section>
    <section id="career goals">
        <h2>Career Goals</h2>
        <p>

        </p>
    </section>
    <section id="projects">
        <h2>Projects</h2>
        <p>Highlight your projects and provide links to them.</p>
    </section>
</main>

<footer>
    <p>Contact: liamcsiffary@gmail.com or liam.csiffary@mail.utoronto.ca | LinkedIn: <a href="https://www.linkedin.com/in/liam-csiffary-51835b257/" target="_blank">LinkedIn</a> | GitHub: <a href="https://github.com/TheWeeWum" target="_blank">Personal GitHub</a></p>
</footer>

<script>
    window.onscroll = function() {myFunction()};

    var nav = document.getElementById("nav");
    var main = document.getElementById("about");
    var sticky = nav.offsetTop;

    function myFunction() {
        if (window.scrollY > sticky) {
            nav.classList.add("sticky");
            main.classList.add("pad");
        } else {
            nav.classList.remove("sticky");
            main.classList.remove("pad");
        }
    }
</script>

</body>
</html>
