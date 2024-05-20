// Función para validar que todos los campos estén rellenos
function validarCamposRellenos() {
    let campos = document.querySelectorAll('input[type="text"], textarea, select');
    let isValid = true;

    campos.forEach(function(campo) {
        if (!campo.value.trim()) {
            isValid = false;
        }
    });

    return isValid;
}

// Función para validar la longitud del nombre del producto
function validarLongitudNombre() {
    let nombreProducto = document.getElementById('nombreProducto').value.trim();
    return nombreProducto.length <= 100;
}

// Función para validar que el precio sea mayor que cero
function validarPrecioMayorQueCero(precio) {
    return precio > 0;
}

// Función para validar que el precio de fábrica no sea mayor que el precio de venta
function validarPrecios() {
    let precioFabrica = parseFloat(document.getElementById('preciofabrica').value);
    let precioVenta = parseFloat(document.getElementById('precioVenta').value);
    return precioFabrica <= precioVenta;
}

// Función para validar que al menos un checkbox esté seleccionado
function validarCheckboxSeleccionado() {
    let checkboxes = document.querySelectorAll('input[type="checkbox"]');
    let isChecked = false;

    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            isChecked = true;
        }
    });

    return isChecked;
}

// Función principal de validación del formulario
function validarFormulario() {
    let isValid = true;

    if (!validarCamposRellenos()) {
        alert('Todos los campos son obligatorios');
        isValid = false;
    } else if (!validarLongitudNombre()) {
        alert('El nombre del producto no puede tener más de 100 caracteres');
        isValid = false;
    } else {
        let precioFabrica = parseFloat(document.getElementById('preciofabrica').value);
        let precioVenta = parseFloat(document.getElementById('precioVenta').value);

        if (!validarPrecioMayorQueCero(precioFabrica)) {
            alert('El precio de fábrica debe ser mayor que 0');
            isValid = false;
        } else if (!validarPrecioMayorQueCero(precioVenta)) {
            alert('El precio de venta debe ser mayor que 0');
            isValid = false;
        } else if (!validarPrecios()) {
            alert('El precio de fábrica no puede ser mayor que el precio de venta');
            isValid = false;
        }
    }

    if (!validarCheckboxSeleccionado()) {
        alert('Debes seleccionar al menos un color o una talla');
        isValid = false;
    }

    return isValid;
}

// Event listener para la validación del formulario en el submit
document.querySelector('form').addEventListener('submit', function(event) {
    if (!validarFormulario()) {
        event.preventDefault(); // Evitar que se envíe el formulario si no es válido
    }
});