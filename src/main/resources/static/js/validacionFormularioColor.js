document.getElementById('registroColorForm').addEventListener('submit', function(event) {
        let nombreColor = document.getElementById('nombreColor').value.trim();

        if (nombreColor === '') {
            alert('Por favor, rellena el campo de color.');
            event.preventDefault();
        }
    });