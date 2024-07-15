document.addEventListener('DOMContentLoaded', () => {
    const baseUrl = 'http://localhost:8080/productos'; // Cambia la URL base según tu configuración

    const container = document.getElementById('products-container');

    ///js/productos.json
    //http://localhost:8080/productos/listar-productos
    function cargarProductos() {
        fetch("http://localhost:8080/productos/listar-productos")
            .then(response => response.json())
            .then(products => {
                container.innerHTML = ''; // Limpiar contenedor
                products.forEach(product => {
                    const card = document.createElement('div');
                    card.className = 'card';

                    const image = document.createElement('img');
                    image.src = product.imagen;
                    image.alt = product.titulo;

                    const title = document.createElement('h1');
                    title.textContent = product.titulo;

                    const price = document.createElement('p');
                    price.className = 'price';
                    price.textContent = `$${product.precio}`;

                    const stock = document.createElement('p');
                    stock.className = 'stock';
                    stock.textContent = `Stock: ${product.stock}`;

                    const buttons = document.createElement('div');
                    buttons.className = 'buttons';

                    const modifyButton = document.createElement('button');
                    modifyButton.className = 'modify btn btn-primary';
                    modifyButton.textContent = 'Modificar';
                    modifyButton.onclick = () => {
                        showModal(product);
                    };

                    const deleteButton = document.createElement('button');
                    deleteButton.className = 'delete btn btn-danger';
                    deleteButton.textContent = 'Eliminar';
                    deleteButton.onclick = () => {
                        if (confirm(`¿Estás seguro de que quieres eliminar el producto ${product.titulo}?`)) {
                            fetch(`http://localhost:8080/productos/eliminar-producto/${product.id}`, {
                                method: 'DELETE',
                                headers: {
                                    'Content-Type': 'application/json'
                                }
                            })
                                .then(response => {
                                    if (response.ok) {
                                        console.log('Producto modificado exitosamente');
                                        // Recargar la página después de un breve retraso
                                        setTimeout(() => {
                                            location.reload();
                                        }, 1000); // 1000 milisegundos = 1 segundo
                                    } else {
                                        throw new Error('Error al eliminar el producto');
                                    }
                                })
                                .then(data => {
                                    console.log('Producto eliminado:', data);
                                    cargarProductos(); // Recargar la lista de productos
                                })
                                .catch(error => console.error('Error al eliminar el producto:', error));
                        }
                    };

                    buttons.appendChild(modifyButton);
                    buttons.appendChild(deleteButton);

                    card.appendChild(image);
                    card.appendChild(title);
                    card.appendChild(price);
                    card.appendChild(stock);
                    card.appendChild(buttons);

                    container.appendChild(card);
                });
            })
            .catch(error => console.error('Error al obtener los productos:', error));
    }

    cargarProductos();

    // Función para mostrar el modal de edición con los datos del producto
    function showModal(product) {
        document.getElementById('editProductId').value = product.id;
        document.getElementById('editTitle').value = product.titulo;
        document.getElementById('editPrice').value = product.precio;
        document.getElementById('editStock').value = product.stock;
        document.getElementById('editImage').value = product.imagen;

        const editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    }

    // Evento para guardar los cambios del producto modificado
    document.getElementById('saveChanges').addEventListener('click', () => {
        const id = document.getElementById('editProductId').value;
        const titulo = document.getElementById('editTitle').value;
        const precio = document.getElementById('editPrice').value;
        const stock = document.getElementById('editStock').value;
        const imagen = document.getElementById('editImage').value;

        const producto = {
            id: id,
            titulo: titulo,
            precio: parseFloat(precio),
            stock: parseInt(stock),
            imagen: imagen
        };
        console.log(producto);

        fetch("http://localhost:8080/productos/actualizar-producto", {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        })
        .then(response => {
            if (response.ok) {
                console.log('Producto modificado exitosamente');
                // Recargar la página después de un breve retraso
                setTimeout(() => {
                    location.reload();
                }, 1000); // 1000 milisegundos = 1 segundo
            } else {
                throw new Error('Error al modificar el producto');
            }
        })
        .catch(error => {
            console.error('Error al modificar el producto:', error);
        });
    });
});
