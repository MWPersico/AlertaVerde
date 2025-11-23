async function carregarDenuncias() {
  try {
    const response = await fetch("/denuncia");
    if (!response.ok) throw new Error("Erro ao carregar denúncias");

    const denuncias = await response.json();
    const container = document.getElementById("feed-container");
    container.innerHTML = "";

    denuncias.forEach((denuncia) => {
      const card = document.createElement("div");
      card.className = "denuncia-card";

      const imagem = denuncia.midias?.[0]?.urlArquivo || "";
      const data = new Date(denuncia.dataDenuncia).toLocaleDateString("pt-BR");

      card.innerHTML = `
          ${imagem ? `<img src="${imagem}" alt="Imagem da denúncia">` : ""}
          <div class="denuncia-info">
            <h2>${denuncia.titulo}</h2>
            <p><strong>Status:</strong> ${formatarStatus(denuncia.status)}</p>
            <p><strong>Categoria:</strong> ${denuncia.categoria}</p>
            <p><strong>Data:</strong> ${data}</p>
            <p><strong>Local:</strong> Latitude ${
              denuncia.latitude
            }, Longitude ${denuncia.longitude}</p>
            <p><strong>Descrição:</strong> ${denuncia.descricao}</p>
            <p><strong>Código de rastreamento:</strong> ${
              denuncia.codigoRastreamento
            }</p>
            <p style="margin-top:8px"><a href="/visualizar_denuncia?id=${denuncia.id}" style="background:#4453c3;color:#fff;padding:8px 10px;border-radius:6px;text-decoration:none;">Abrir</a></p>
          </div>
        `;

      container.appendChild(card);
    });
  } catch (err) {
    console.error(err);
    document.getElementById("feed-container").innerHTML =
      "<p>Não foi possível carregar as denúncias. Tente novamente mais tarde.</p>";
  }
}

function formatarStatus(status) {
  switch (status) {
    case "RECEBIDA":
      return "Recebida";
    case "EM_ANALISE":
      return "Em análise";
    case "RESOLVIDA":
      return "Concluída";
    default:
      return status;
  }
}

carregarDenuncias();