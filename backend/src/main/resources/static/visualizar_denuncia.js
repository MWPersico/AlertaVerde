function pegarParametro(nome) {
  const params = new URLSearchParams(window.location.search);
  return params.get(nome);
}

async function buscarDenunciaPorId(id){
  const res = await fetch('/denuncia/' + id);
  if(!res.ok) throw new Error('Erro ao buscar denúncia');
  return res.json();
}

function formatarData(iso){
  if(!iso) return '';
  return new Date(iso).toLocaleString();
}

async function iniciarVisualizacao(){
  const id = pegarParametro('id');
  if(!id) return document.getElementById('visualizacao').innerText = 'ID da denúncia não informado.';
  try{
    const d = await buscarDenunciaPorId(id);
    document.getElementById('v-titulo').innerText = d.titulo || '';
    document.getElementById('v-categoria').innerText = d.categoria.replaceAll("_", " ") || '';
    document.getElementById('v-data').innerText = formatarData(d.dataDenuncia);
    document.getElementById('v-local').innerText = d.latitude && d.longitude ? `${d.latitude}, ${d.longitude}` : '—';
    document.getElementById('v-descricao').innerText = d.descricao || '';
    document.getElementById('v-codigo').innerText = d.codigoRastreamento || '';

    const midiasEl = document.getElementById('v-midias');
    midiasEl.innerHTML = '';
    if(d.midias && d.midias.length){
      d.midias.forEach(m => {
        const img = document.createElement('img');
        img.src = m.urlArquivo;
        img.style.width = '140px';
        img.style.height = '100px';
        img.style.objectFit = 'cover';
        img.style.borderRadius = '6px';
        midiasEl.appendChild(img);
      });
    }
  } catch(err){
    console.error(err);
    document.getElementById('visualizacao').innerText = 'Erro ao carregar a denúncia.';
  }
}

document.addEventListener('DOMContentLoaded', iniciarVisualizacao);
