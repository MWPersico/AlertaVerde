# Alerta Verde - Sistema de denúncias ambientais  

Este projeto consiste no desenvolvimento de uma plataforma web dedicada ao registro e acompanhamento de denúncias ambientais, como desmatamento, queimadas ilegais, poluição e tráfico de animais. O sistema foi pensado para ser acessível, seguro e fácil de usar, permitindo que qualquer cidadão ou organização possa contribuir ativamente na defesa do meio ambiente.

Entre as funcionalidades estão o registro anônimo, uso de geolocalização, envio de fotos ou vídeos como evidência, e armazenamento seguro das informações. A solução adota práticas ágeis e prioriza a experiência do usuário, oferecendo uma ferramenta confiável para ampliar o alcance da fiscalização ambiental colaborativa.

Indo além do registro de ocorrências, o projeto encontra-se em uma nova fase de aprimoramento. O foco atual é enriquecer a experiência com novas funcionalidades voltadas para o engajamento do usuário, análise de dados através de um painel de estatísticas e a promoção de conteúdo educacional.


---

## Grupo 15
Nosso grupo é composto por:

- Angela Brito Martins Meira 
- Caroline Costa Saldanha
- José Renato das Graças Filho
- Luiz Guilherme Longatto Adorno
- Marcos Willian Gonçalves Persico

---

## Índice  
- [Visão Geral](#visão-geral)  
- [Tecnologias Utilizadas](#tecnologias-utilizadas)  
- [Pré-requisitos](#pré-requisitos)  
- [Como Rodar o Projeto](#como-rodar-o-projeto)  
- [Contribuições](#contribuições)  
- [API](#api)
- [Telas](#telas)

---

## Visão Geral  
O aplicativo tem como objetivo oferecer uma plataforma segura e acessível para que os cidadãos possam relatar incidentes ambientais, como desmatamento, queimadas ilegais, poluição, tráfico de animais, entre outros. . A plataforma visa preencher a lacuna na denúncia de crimes ambientais, capacitando a sociedade para agir na proteção do meio ambiente e contribuindo para a proteção de práticas ambientais. 

O público-alvo inclui ONGs, empresas sustentáveis e cidadãos conscientes.

Entre as funcionalidades estão o registro anônimo, uso de geolocalização, envio de fotos ou vídeos como evidência, e armazenamento seguro das informações. A solução adota práticas ágeis e prioriza a experiência do usuário, oferecendo uma ferramenta confiável para ampliar o alcance da fiscalização ambiental colaborativa.

---

## Tecnologias Utilizadas  

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)  
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)  
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
![H2 Database](https://img.shields.io/badge/H2_Database-0078D6?style=for-the-badge&logo=databricks&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)  

---

## Programas Utilizados  

![Visual Studio Code](https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=White)  
![IntelliJ](https://img.shields.io/badge/Intellij%20Idea-000?logo=intellij-idea&style=for-the-badge)  

---

## Pré-requisitos  
Para rodar o projeto, você precisará de:  
- Um editor de texto, como VS Code.  
- Um navegador moderno (Chrome, Firefox, Edge).
- JDK ^17 configurada.  

## Como Rodar o Projeto  
- Clone o repositório: git clone https://github.com/MWPersico/AlertaVerde.git
- Abra o projeto em sua IDE
- Exceute a classe **AlertaVerdeApplication.java**
- Acesse a aplicação no navegador: http://localhost:8080
  
---

## Contribuições  
Quer ajudar a melhorar o projeto? Siga os passos:

1. Faça um fork do repositório.

2. Crie uma branch para sua feature:
   git checkout -b feature/nova-feature

3. Commit suas mudanças:
   git commit -m "Adiciona nova funcionalidade"

4. Envie para sua branch:
   git push origin feature/nova-feature

5. Abra um Pull Request no repositório original.

---

## API
A api do projeto foi criada utilizando Java com Spring Boot, com banco H2 em memória para persistência e HIbernate como ferramenta de ORM, disponibilizando operações de leitura, criação, deleção e atualização de entidades.

![Usuarios](https://github.com/MWPersico/AlertaVerde/blob/main/api/consulta_usuarios.png?raw=true)
![Usuario](https://github.com/MWPersico/AlertaVerde/blob/main/api/consulta_usuario.png?raw=true)
![NovoUsuario](https://github.com/MWPersico/AlertaVerde/blob/main/api/cadastro_usuario.png?raw=true)
![Denuncias](https://github.com/MWPersico/AlertaVerde/blob/main/api/consulta_denuncias.png?raw=true)
![Denuncia](https://github.com/MWPersico/AlertaVerde/blob/main/api/consulta_denuncia.png?raw=true)
![NovaDenuncia](https://github.com/MWPersico/AlertaVerde/blob/main/api/cadastro_denuncia.png?raw=true)
![NovaMidia](https://github.com/MWPersico/AlertaVerde/blob/main/api/cadastro_midia_denuncia.png?raw=true)
![Categorias](https://github.com/MWPersico/AlertaVerde/blob/main/api/cadastro_consulta_categorias.png?raw=true)

---

## Telas

Link do protótipo desenvolvido no Figma: [https://www.figma.com/proto/QBQDCs4ICmOVYwBYXoOrz1/PI-Alerta-Verde?node-id=0-1&t=26qlUJ2DnJLmnMqU-1](https://www.figma.com/proto/QBQDCs4ICmOVYwBYXoOrz1/PI-Alerta-Verde?node-id=0-1&t=26qlUJ2DnJLmnMqU-1)

### **Principais Telas**

![Prototipo Figma](/Prototipo%20Figma/PI%20Alerta%20Verde.png)
![Perfil](/Prototipo%20Figma/perfil.png)
![Estatísticasa](/Prototipo%20Figma/estatistica.png)

## Diagrama de Entidade-Relacionamento (DER)

![Estatísticasa](/Prototipo%20Figma/der_alerta_verde.png)

