document.getElementById('registroProductoForm').addEventListener('submit', function(event) {
	        let nombreProducto = document.getElementById('nombreProducto').value;
	        let precioFabrica = document.getElementById('preciofabrica').value;
	        let precioVenta = document.getElementById('precioVenta').value;
	        let colores = document.querySelectorAll('input[name="colores"]:checked');
	        let tallas = document.querySelectorAll('input[name="tallas"]:checked');
	
	        let valid = true;
	        let errorMessage = '';
	
	        if (!nombreProducto.trim()) {
	            errorMessage += 'Por favor, rellena el nombre del producto.\n';
	            valid = false;
	        }
	
	        if (parseFloat(precioFabrica) < 0) {
	            errorMessage += 'Por favor, rellena el precio de fábrica con un valor mayor o igual a 0.\n';
	            valid = false;
	        }
	
	        if (parseFloat(precioVenta) < 0) {
	            errorMessage += 'Por favor, rellena el precio de venta con un valor mayor o igual a 0.\n';
	            valid = false;
	        }
	
	        if (colores.length === 0) {
	            errorMessage += 'Por favor, selecciona al menos un color.\n';
	            valid = false;
	        }
	
	        if (tallas.length === 0) {
	            errorMessage += 'Por favor, selecciona al menos una talla.\n';
	            valid = false;
	        }
	
			if (parseFloat(precioFabrica) > parseFloat(precioVenta)) {
				errorMessage += 'El precio de fábrica no puede ser mayor que el precio de venta.\n';
			valid = false;
			}
			
	        if (!valid) {
	            alert(errorMessage);
	            event.preventDefault();
	        }
	    });