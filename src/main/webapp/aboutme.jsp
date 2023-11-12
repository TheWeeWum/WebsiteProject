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
    <p>About Me</p>
</header>

<nav id="nav">
    <a href="home">Home</a>
    <a href="projects">Projects</a>
    <a href="contact">Contact</a>
</nav>

<main id="main">
    <section id="about">
        <h2>About Me</h2>
        <p>
            Greetings! I'm Liam Csiffary, a passionate undergraduate student
            at the University of Toronto, delving into the realms of mathematical
            and physical sciences. Currently pursuing a double major in
            Computer Science and Physics, with a minor in Mathematics, my academic
            journey is fueled by a profound fascination for the intricate world of
            Computer Science and mathematics.
            <br><br>
            My journey into the realm of technology began with an insatiable
            curiosity for understanding how things work. Even before encountering
            computers or programming, I found joy in dismantling toys and experimenting
            with anything within reach, transforming them into imaginative creations.
            My introduction to computers occurred during a small camp with my scouts
            group, where the allure of disassembling and exploring the inner workings
            of old computers sparked my interest.
            <br><br>
            A pivotal moment came when my dad introduced me to the world of Raspberry Pi.
            This small but powerful device became the canvas for my experimentation
            with software, paving the way for my initial foray into coding. Starting
            with JavaScript on Khan Academy, I progressed through their courses before
            venturing into independent programming using VSCode to explore the
            intricacies of Python.
            <br><br>
            The journey continued as I delved into the realm of C++, discovering
            the exhilarating speed at which programs could run. Motivated by the
            desire for optimization, I revisited and enhanced projects initially
            crafted in Python. My formal education introduced me to Java and Swift,
            and I dedicated substantial time honing my skills in Object-Oriented
            Programming, culminating in the creation of a comprehensive triangle
            program which calculated just about every possible thing you could
            calculate about a triangle.
            <br><br>
            In my final year of high school we were to create
            a Unity game based off of one of the Unity tutorials. However, I felt that I
            would learn more starting from scratch, as I had been doing my whole life
            up until that point. And so after much research, debugging, and experimenting
            I created a pretty cool roguelike RPG game with procedurally generating terrain,
            randomized enemies, and an upgradable moveset for the player.
            My Computer Science teacher was blown away by my creation telling me how
            impressive it was especially considering how little time we had to develop it.
            <br><br>
            The journey continued into the realm of C# Unity, where I expanded my
            repertoire of coding languages. Collaborating with my brother, we
            embarked on joint ventures in game development, combining our skills to
            create engaging projects. The synergy of our efforts further fueled my passion
            for problem-solving and continuous learning.
            <br><br>
            Today, with nine years of coding experience under my belt, I find myself
            still enthralled by the dynamic landscape of computer science. I revel in
            the joy of solving problems, pushing boundaries, and embarking on the next
            challenge. As I continue my academic journey, I am excited about the endless
            possibilities that await in the ever-evolving world of technology.
            <!--            My name is Liam Csiffary, I am currently an undergraduate student-->
            <!--            at the University of Toronto. I am pursuing an undergraduate degree-->
            <!--            in the mathematical and physical sciences. Doing a double major in-->
            <!--            Computer Science and Physics, and minoring in Mathematics.-->
            <!--            I have always had a deep interest in Computer Science and almost anything-->
            <!--            to do with math. Before I had a computer or knew what-->
            <!--            programming was I always found myself tinkering with toys and-->
            <!--            whatever I could get my hands on turning it into whatever my mind-->
            <!--            could dream up. My first experience with computers was in a small camp-->
            <!--            with my scouts group. They had recently acquired a few old broken-->
            <!--            computers, and they allowed us to disassemble them. Then shortly after-->
            <!--            my dad allowed my to get a raspberry pi which my brother and I used to-->
            <!--            experiment with software in ways we couldn't before. This birthed a new-->
            <!--            interest in computers for me which developed into my interest in learning-->
            <!--            how to code. So as any reasonable person would do I began my coding-->
            <!--            adventures with javascript on Khan Academy since that at the time was-->
            <!--            the only place I knew of to learn how to code. After completing-->
            <!--            all the courses they had to offer I discovered how to run programs-->
            <!--            on my own machine. In the beginning using VSCode to learn python.-->
            <!--            I began small working on little projects eventually making a text based-->
            <!--            RPG game over the summer. Then I stepped into the world of C++ where-->
            <!--            I learned how much faster programs could run and I started trying to-->
            <!--            optimize some of the codes I had written so long ago in python.-->
            <!--            Then in school we began learning Java and swift, this for the time being-->
            <!--            is where I focused most of my time, here I honed my skills in OOP creating-->
            <!--            a triangle program which calculated just about anything you could ever want-->
            <!--            to know about a triangle (and way more). Java and Python became my main-->
            <!--            languages of focus though I still stepped occasionally into C++ any time I-->
            <!--            wanted my code to be really fast. In my final year of highschool we were to create-->
            <!--            a Unity game based off of one of the Unity tutorials. However, I felt that I-->
            <!--            would learn more starting from scratch, as I had been doing my whole life-->
            <!--            up until that point. And so after much research, debugging, and experimenting-->
            <!--            I created a pretty cool roguelike RPG game with procedurally generating terrain,-->
            <!--            randomized enemies, and an upgradable moveset for the player.-->
            <!--            My Computer Science teacher was blown away by my creation telling me how-->
            <!--            impressive it was especially considering how little time we had to develop it.-->
            <!--            After this I continued to play around with C# Unity adding it to my repository-->
            <!--            of coding languages. Then both my brother and I began experimenting with C# and-->
            <!--            Unity together, where we worked on some games collaboratively as well as independently.-->
            <!--            And now here I am, still enjoying solving problems and learning new things as much-->
            <!--            as I did 9 years ago.-->
        </p>
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
