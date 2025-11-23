async function buscarDenunciasComCoordenadas(){
  try{
    const res = await fetch('/denuncia');
    if(!res.ok) throw new Error('Erro ao carregar denúncias');
    const dados = await res.json();
    return dados.filter(d => d.latitude !== null && d.longitude !== null && !isNaN(d.latitude) && !isNaN(d.longitude));
  } catch(err){
    console.error(err);
    return [];
  }
}

function criarMapa(){
  const mapa = L.map('map', { scrollWheelZoom: false }).setView([-15.7801, -47.9292], 4);

  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>'
  }).addTo(mapa);

  return mapa;
}

async function plotarMarcadores(){
  const pontos = await buscarDenunciasComCoordenadas();
  const mapa = criarMapa();

  if(pontos.length === 0){
    return;
  }

  const grupo = L.featureGroup();

  pontos.forEach(d => {
    try{
      const lat = parseFloat(d.latitude);
      const lng = parseFloat(d.longitude);
      if(isNaN(lat) || isNaN(lng)) return;

      const marker = L.marker([lat, lng]);
      const titulo = d.titulo ? d.titulo : 'Denúncia';
      const link = `/visualizar_denuncia?id=${d.id}`;
      const popup = `<strong>${titulo}</strong><br/>${d.categoria ? d.categoria : ''}<br/><a href="${link}">Abrir</a>`;
      marker.bindPopup(popup);
      marker.addTo(grupo);
    } catch(e){ console.warn('erro marcando ponto', e); }
  });

  grupo.addTo(mapa);
  mapa.fitBounds(grupo.getBounds().pad(0.2));
}

document.addEventListener('DOMContentLoaded', plotarMarcadores);
