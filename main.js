const navbar = document.querySelector('nav');
const hamburger = document.querySelector('.hamburger');

hamburger.addEventListener('click',()=>{
    navbar.classList.toggle('active');
    hamburger.classList.toggle('hamburgerActive');
})