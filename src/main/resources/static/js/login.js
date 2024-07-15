function iniciarSesion() {
  const correo = document.getElementById('txtEmail').value;
  const clave = document.getElementById('txtPassword').value;

  const loginData = {
      correo: correo,
      clave: clave
  };

  fetch('http://localhost:8080/credencial/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(loginData)
  })
  .then(response => {
      if (response.ok) {
          return response.json();
      } else {
          throw new Error('Credenciales incorrectas');
      }
  })
  .then(data => {
      console.log('Inicio de sesión exitoso:', data);
      // Redirigir según el rol del usuario
      if (data.rol === 1) {
          window.location.href = 'http://localhost:8080/index-cli.html';
      } else if (data.rol === 2) {
          window.location.href = 'http://localhost:8080/index-admin.html';
      } else {
          console.error('Rol no reconocido:', data.rol);
      }
  })
  .catch(error => {
      console.error('Error al iniciar sesión:', error);
      alert('Error al iniciar sesión: ' + error.message);
  });
}
