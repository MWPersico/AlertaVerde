// 5.3 Geolocalização automática
window.onload = () => {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const latitude = position.coords.latitude.toFixed(6);
        const longitude = position.coords.longitude.toFixed(6);
        document.getElementById("local").value = `${latitude}, ${longitude}`;
      },
      (error) => {
        document.getElementById("local").placeholder = "Erro ao obter localização";
        console.warn("Erro na geolocalização:", error);
      }
    );
  } else {
    document.getElementById("local").placeholder = "Geolocalização não suportada";
  }
};

// Exemplo de envio
function enviarDenuncia(event) {
  event.preventDefault();
  const categoria = document.getElementById("categoria").value;
  const local = document.getElementById("local").value;
  const descricao = document.getElementById("descricao").value;
  const imagem = document.getElementById("imagem").files[0];
  
  const formData = new FormData();
  formData.append("categoria", categoria);
  formData.append("local", local);
  formData.append("descricao", descricao);
  if (imagem) formData.append("imagem", imagem);

  fetch("/denuncia", {
    method: "POST",
    body: formData
  })
  .then(response => {
    if (response.ok) {
      window.location.href = "/tela_conclusao";
    } else {
      alert("Erro ao enviar denúncia.");
    }
  })
  .catch(() => alert("Erro ao enviar denúncia."));
} 