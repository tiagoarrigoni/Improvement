function voltar() {
    window.history.back();
}

function inicializarUsuarios() {
    const usuariosExistentes = JSON.parse(localStorage.getItem('usuarios')) || [];
    if (usuariosExistentes.length > 0) {
        return; // Se já houver usuários, não inicializa dados fictícios
    }

    // Neste ponto, você pode escolher se deseja inicializar com dados ou deixar vazio
    // Para este exemplo, vamos deixar vazio se não houver usuários
    // const usuariosFicticios = [ /* Dados fictícios aqui se necessário */ ];
    // localStorage.setItem('usuarios', JSON.stringify(usuariosFicticios));
}

function atualizarRanking() {
    const rankingList = document.getElementById('ranking-list');
    rankingList.innerHTML = ''; // Limpa a lista existente

    const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    // Ordena os usuários por pontos (decrescente)
    usuarios.sort((a, b) => b.pontosTotais - a.pontosTotais); // Ordena por pontos

    usuarios.forEach((usuario, index) => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${index + 1}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.livrosMarcados.length}</td>
            <td>${usuario.pontosTotais}</td>
            <td class="trofeu">${usuario.trofeus} Troféus</td>
        `;
        rankingList.appendChild(tr);
    });
}

document.addEventListener('DOMContentLoaded', () => {
    // Inicializa os usuários apenas se não houver dados no localStorage
    inicializarUsuarios();
    atualizarRanking();
});
