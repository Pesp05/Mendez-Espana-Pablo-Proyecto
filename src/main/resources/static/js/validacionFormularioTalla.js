 document.getElementById('registroTallaForm').addEventListener('submit', function(event) {
        let nombreTalla = document.getElementById('nombreTalla').value.trim();

        if (nombreTalla === '') {
            alert('Por favor, rellena el campo de calla.');
            event.preventDefault();
        }
    });