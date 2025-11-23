async function buscarUsuario(id){
  const res = await fetch('/usuario/' + id);
  if(!res.ok) throw new Error('Não foi possível carregar usuário');
  return res.json();
}

async function buscarDenuncias(){
  const res = await fetch('/denuncia');
  if(!res.ok) throw new Error('Não foi possível carregar denúncias');
  return res.json();
}

function sair(){
  localStorage.removeItem('usuarioId');
  window.location.href = '/login';
}

async function carregarPerfil(){
  const userId = localStorage.getItem('usuarioId');
  if(!userId){
    const card = document.getElementById('card-perfil');
    if(card) card.innerHTML = '<p>Você não está logado. <a href="/login">Entrar</a></p>';
    return;
  }

  try{
    const user = await buscarUsuario(userId);
    document.getElementById('perfil-nome').innerText = user.nome || user.name || 'Usuário';
    document.getElementById('perfil-email').innerText = user.email || '';
    document.getElementById('perfil-telefone').innerText = user.telefone ? 'Tel: ' + user.telefone : '';

    const todas = await buscarDenuncias();
    const minhas = todas.filter(d => d.usuario && String(d.usuario.id) === String(userId));
    const list = document.getElementById('lista-denuncias');
    if(!list) return;
    if(minhas.length === 0){
      list.innerHTML = '<p class="small-muted">Nenhuma denúncia encontrada para sua conta.</p>';
    } else {
      list.innerHTML = '';
      minhas.forEach(d => {
          const card = document.createElement('div');
          card.className = 'card-denuncia';
          card.innerHTML = `
            <div class="meta">
              <div class="titulo">Título: ${d.titulo}</div>
              <div class="categoria">${d.categoria ? d.categoria.replaceAll("_", " ") : 'Sem categoria'}</div>
              <div class="meta-line">Situação: ${d.status ? d.status.replaceAll("_", " ") : ''} • ${new Date().toLocaleDateString()}</div>
            </div>
            <div class="acoes">
              <a class="details-link" href="/visualizar_denuncia?id=${d.id}">Abrir</a>
            </div>
          `;
        list.appendChild(card);
      });
    }

  } catch(err){
    console.error(err);
    const list = document.getElementById('lista-denuncias');
    if(list) list.innerHTML = '<p class="small-muted">Erro ao carregar dados.</p>';
  }
}

document.addEventListener('DOMContentLoaded', carregarPerfil);
