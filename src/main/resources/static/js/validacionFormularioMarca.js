document.getElementById('registroMarcaForm').addEventListener('submit', function(event) {
        let nombreMarca = document.getElementById('nombreMarca').value.trim();

        if (nombreMarca === '') {
            alert('Por favor, rellena el campo de marca.');
            event.preventDefault();
        }
    });