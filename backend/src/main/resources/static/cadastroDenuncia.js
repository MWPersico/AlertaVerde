async function carregarCategorias() {
    try {
      const resp = await fetch('/enums/categoriaDenuncia');
      const categorias = await resp.json();
      const select = document.getElementById('categoria');
      categorias.forEach(cat => {
        const option = document.createElement('option');
        option.value = cat.descricao;
        option.textContent = cat.descricao;
        select.appendChild(option);
      });
    } catch (err) {
      console.error('Erro ao carregar categorias:', err);
    }
  }

  document.getElementById('denunciaForm').addEventListener('submit', async function (e) {
    e.preventDefault();

    const userId = localStorage.getItem('usuarioId');
    if (!userId) {
      document.getElementById('errorMsg').textContent = 'Usuário não autenticado.';
      return;
    }

    const data = {
      titulo: document.getElementById('titulo').value,
      descricao: document.getElementById('descricao').value,
      categoria: document.getElementById('categoria').value,
      latitude: parseFloat(document.getElementById('latitude').value),
      longitude: parseFloat(document.getElementById('longitude').value),
      anonima: document.getElementById('anonima').checked,
      status: "EM_ANALISE",
      usuario: {
        id: parseInt(userId)
      },
      midias: [
        {
          urlArquivo: document.getElementById('imagem').value,
          tipo: "IMAGEM"
        }
      ]
    };

    try {
      const response = await fetch('/denuncia', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        document.getElementById('successMsg').textContent = 'Denúncia enviada com sucesso!';
        document.getElementById('errorMsg').textContent = '';
        window.location.href = '/tela_conclusao';
      } else {
        const msg = await response.text();
        throw new Error(msg);
      }
    } catch (err) {
      document.getElementById('errorMsg').textContent = 'Erro ao enviar denúncia: ' + err.message;
      document.getElementById('successMsg').textContent = '';
    }
  });

  function obterLocalizacaoAtual() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        position => {
          document.getElementById('latitude').value = position.coords.latitude;
          document.getElementById('longitude').value = position.coords.longitude;
        },
        error => {
          console.warn('Erro ao obter localização:', error.message);
        }
      );
    } else {
      console.warn('Geolocalização não é suportada neste navegador.');
    }
  }

  carregarCategorias();
  obterLocalizacaoAtual();