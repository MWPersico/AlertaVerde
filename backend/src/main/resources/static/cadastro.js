document.addEventListener('DOMContentLoaded', function() {
  const form = document.querySelector('.login-form');
  if (form) {
    form.addEventListener('submit', async function(event) {
      event.preventDefault();
      const nome = document.getElementById('name').value;
      const email = document.getElementById('email').value;
      const telefone = document.getElementById('phone').value;
      const senhaHash = document.getElementById('password').value;
      // const confirmPassword = document.getElementById('confirm-password').value; // pode validar se quiser

      const data = {
        nome,
        email,
        telefone,
        senhaHash
      };

      const response = await fetch('/usuario', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert('Cadastro realizado com sucesso!');
        window.location.href = '/login';
      } else {
        alert('Erro ao cadastrar usuário.');
      }
    });
  }
}); 