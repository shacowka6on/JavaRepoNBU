import JSConfetti from './confetti.js'; // Adjust the path if necessary

const confettiInstance = new JSConfetti();

const noButton = document.querySelector(".no-btn");
const yesButton = document.querySelector(".yes-btn");

document.addEventListener("DOMContentLoaded", () => {
    const yesButtonRect = yesButton.getBoundingClientRect();

    const initialTop = yesButtonRect.top  - 289.875;
    const initialLeft = yesButtonRect.right + 200; 

    noButton.style.position = "absolute"; 
    noButton.style.top = initialTop + "px";
    noButton.style.left = initialLeft + "px";
})

function randomizeButtonPosition() {
    const windowWidth = window.innerWidth;
    const windowHeight = window.innerHeight - 500;

    const randomTop = Math.floor(Math.random() * (windowHeight - 50));
    const randomLeft = Math.floor(Math.random() * (windowWidth - 100));

    noButton.style.top = randomTop + "px";
    noButton.style.left = randomLeft + "px";
    noButton.style.transition = "0.5s"
}

noButton.addEventListener("mouseenter", randomizeButtonPosition);

const yippiePage = document.querySelector(".header-items-yippie");
const mainPage = document.querySelector(".main")
yippiePage.style.display = "none";


yesButton.addEventListener('click', () => {
    document.title = "YIPPIEEEE"
    
    var music = new Audio("yippee_sound_effect.mp3");
    music.play();
    
    yippiePage.style.display = "flex";
    mainPage.style.display = "none";

    for(let i = 0; i < 100; i++){
        setTimeout(() => {
            confettiInstance.addConfetti();
        }, 1500 * i); 
    }
})
