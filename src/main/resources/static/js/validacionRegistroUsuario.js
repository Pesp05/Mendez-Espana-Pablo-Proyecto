document.getElementById('registroUsuarioForm').addEventListener('submit', function(event) {
        let nombreUsuario = document.getElementById('nombreUsuario').value.trim();
        let password = document.getElementById('password').value.trim();
        let fechaNac = document.getElementById('fechaNac').value;
        let valid = true;
        let errorMessage = '';

        if (nombreUsuario === '') {
            errorMessage += 'Por favor, rellena el nombre de usuario.\n';
            valid = false;
        }

        if (password === '') {
            errorMessage += 'Por favor, rellena la contraseña.\n';
            valid = false;
        }

        if (fechaNac !== '') {
            let fechaNacimiento = new Date(fechaNac);
            let fechaActual = new Date();

            if (fechaNacimiento > fechaActual) {
                errorMessage += 'La fecha de nacimiento no puede ser mayor que la fecha actual.\n';
                valid = false;
            }
        }

        if (!valid) {
            alert(errorMessage);
            event.preventDefault();
        }
    });