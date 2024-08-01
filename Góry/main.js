const navbar = document.querySelector('nav');
const hamburger = document.querySelector('.hamburger');

hamburger.addEventListener('click',()=>{
    navbar.classList.toggle('active');
    hamburger.classList.toggle('hamburgerActive');
})

document.getElementById('newsletter-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        name: formData.get('name'),
        email: formData.get('email')
    };

    fetch('http://localhost:8080/newsletter', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();  // Zmiana na response.text()
    })
    .then(data => {
        console.log('Success:', data);
        alert(data);  // Wyświetlenie odpowiedzi jako tekst
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Subscription failed.');
    });
});
