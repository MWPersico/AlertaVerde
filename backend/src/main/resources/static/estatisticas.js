async function buscarDenuncias(){
  const res = await fetch('/denuncia');
  if(!res.ok) throw new Error('Erro ao carregar denúncias');
  return res.json();
}

function calcularPercentual(parte, total){
  if(total === 0) return '0%';
  return Math.round((parte/total)*100) + '%';
}

function renderizarEstatisticas(total, contagens){
  const totalEl = document.getElementById('total-denuncias');
  if(totalEl) totalEl.innerText = total;
  const grade = document.getElementById('grade-estatisticas');
  if(!grade) return;
  grade.innerHTML = '';
  Object.keys(contagens).forEach(cat => {
    const count = contagens[cat];
    const card = document.createElement('div');
    card.className = 'stat-card';
    card.innerHTML = `<div style="font-weight:600">${cat}</div><div class="value">${count}</div><div class="small-muted">${calcularPercentual(count, total)}</div>`;
    grade.appendChild(card);
  });
}

async function iniciar(){
  try{
    const denuncias = await buscarDenuncias();
    const total = denuncias.length;
    const contagens = {};
    denuncias.forEach(d => {
      const cat = d.categoria ? d.categoria.replaceAll("_", " ") : 'SEM CATEGORIA';
      contagens[cat] = (contagens[cat] || 0) + 1;
    });
    renderizarEstatisticas(total, contagens);
  } catch(err){
    console.error(err);
    const grade = document.getElementById('grade-estatisticas');
    if(grade) grade.innerHTML = '<p class="small-muted">Erro ao carregar estatísticas.</p>';
  }
}

document.addEventListener('DOMContentLoaded', iniciar);
