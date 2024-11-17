// Exibe o nome do usuário na tela
document.addEventListener('DOMContentLoaded', () => {
    const usuarioNome = document.getElementById('usuarioNome');
    const nome = sessionStorage.getItem('usuarioNome');

    if (nome) {
        usuarioNome.textContent = nome;
    } else {
        alert('Nome de usuário não encontrado.');
        window.location.href = 'login.html'; // Redireciona para a página de login se o nome do usuário não estiver disponível
    }
});

// Função de logout
document.getElementById('logout').addEventListener('click', () => {
    alert('Você saiu com sucesso!');
    sessionStorage.removeItem('usuarioNome'); // Remove o nome do usuário da sessão
    window.location.href = 'login.html'; // Redireciona para a página de login
});

// Função para visualizar o livro
function visualizarLivro(livro, imagemUrl) {
    // Atualiza a imagem do livro no modal
    document.getElementById('bookImage').src = imagemUrl;

    // Exibe o modal
    document.getElementById('bookModal').style.display = 'block';
}

// Função para marcar a leitura de um livro
function marcarLeitura(livro, paginas, categoria) {
    // Recupera o nome do usuário logado
    const usuarioNome = sessionStorage.getItem('usuarioNome');
    if (!usuarioNome) {
        alert('Você precisa estar logado para marcar uma leitura.');
        return;
    }

    // Recupera a lista de usuários do localStorage
    let usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    // Encontra o usuário atual
    let usuario = usuarios.find(user => user.nome === usuarioNome);

    if (!usuario) {
        alert('Usuário não encontrado.');
        return;
    }

    // Inicializa propriedades do usuário caso não existam
    usuario.livrosMarcados = usuario.livrosMarcados || [];
    usuario.pontosTotais = usuario.pontosTotais || 0;
    usuario.trofeus = usuario.trofeus || 0;
    usuario.livrosPorCategoria = usuario.livrosPorCategoria || {};

    // Verifica se o livro já está na lista
    if (!usuario.livrosMarcados.includes(livro)) {
        // Adiciona o livro à lista
        usuario.livrosMarcados.push(livro);

        // Adiciona o livro à lista de livros marcados no localStorage
        let livrosMarcados = JSON.parse(localStorage.getItem('livrosMarcados')) || [];
        if (!livrosMarcados.includes(livro)) {
            livrosMarcados.push(livro);
            localStorage.setItem('livrosMarcados', JSON.stringify(livrosMarcados));
        }

        // Calcula pontos
        let pontos = 1 + Math.floor(paginas / 100);
        usuario.pontosTotais += pontos;

        // Atualiza a contagem de livros por categoria
        usuario.livrosPorCategoria[categoria] = (usuario.livrosPorCategoria[categoria] || 0) + 1;

        // Verifica se o usuário ganhou algum troféu
        if (usuario.livrosPorCategoria[categoria] % 5 === 0) {
            usuario.trofeus += 1;
            alert(`Parabéns! Você ganhou um troféu por ler 5 livros da categoria ${categoria}.`);
        }

        // Atualiza os dados do usuário no array de usuários
        let usuarioIndex = usuarios.findIndex(user => user.nome === usuarioNome);
        usuarios[usuarioIndex] = usuario;

        // Salva as atualizações no localStorage
        localStorage.setItem('usuarios', JSON.stringify(usuarios));

        // Mostra o resumo atualizado do usuário
        alert(`Pontos Totais: ${usuario.pontosTotais} | Troféus: ${usuario.trofeus}`);
    } else {
        alert(`O livro ${livro} já foi marcado.`);
    }
}


// Fecha o modal quando o usuário clica no botão de fechar
document.querySelector('.close').addEventListener('click', () => {
    document.getElementById('bookModal').style.display = 'none';
});

// Fecha o modal se o usuário clicar fora da área do modal
window.addEventListener('click', (event) => {
    if (event.target === document.getElementById('bookModal')) {
        document.getElementById('bookModal').style.display = 'none';
    }
});

// Função para marcar a leitura de um livro
function marcarLeitura(livro, paginas, categoria) {
    // Recupera o nome do usuário logado
    const usuarioNome = sessionStorage.getItem('usuarioNome');
    if (!usuarioNome) {
        alert('Você precisa estar logado para marcar uma leitura.');
        return;
    }

    // Recupera a lista de usuários do localStorage
    let usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    // Encontra o usuário atual
    let usuario = usuarios.find(user => user.nome === usuarioNome);

    if (!usuario) {
        alert('Usuário não encontrado.');
        return;
    }

    // Inicializa propriedades do usuário caso não existam
    usuario.livrosMarcados = usuario.livrosMarcados || [];
    usuario.pontosTotais = usuario.pontosTotais || 0;
    usuario.trofeus = usuario.trofeus || 0;
    usuario.livrosPorCategoria = usuario.livrosPorCategoria || {};

    // Verifica se o livro já está na lista
    if (!usuario.livrosMarcados.includes(livro)) {
        // Adiciona o livro à lista
        usuario.livrosMarcados.push(livro);

        // Adiciona o livro à lista de livros marcados no localStorage
        let livrosMarcados = JSON.parse(localStorage.getItem('livrosMarcados')) || [];
        if (!livrosMarcados.includes(livro)) {
            livrosMarcados.push(livro);
            localStorage.setItem('livrosMarcados', JSON.stringify(livrosMarcados));
        }

        alert(`Leitura marcada para: ${livro}`);

        // Calcula pontos
        let pontos = Math.floor(paginas / 100) + 1;
        usuario.pontosTotais += pontos;

        // Atualiza a contagem de livros por categoria
        usuario.livrosPorCategoria[categoria] = (usuario.livrosPorCategoria[categoria] || 0) + 1;

        // Verifica se o usuário ganhou algum troféu
        if (usuario.livrosPorCategoria[categoria] % 5 === 0) {
            usuario.trofeus += 1;
            alert(`Parabéns! Você ganhou um troféu por ler 5 livros da categoria ${categoria}.`);
        }

        // Atualiza os dados do usuário no array de usuários
        let usuarioIndex = usuarios.findIndex(user => user.nome === usuarioNome);
        usuarios[usuarioIndex] = usuario;

        // Salva as atualizações no localStorage
        localStorage.setItem('usuarios', JSON.stringify(usuarios));

        // Mostra o resumo atualizado do usuário
        alert(`Pontos Totais: ${usuario.pontosTotais} | Troféus: ${usuario.trofeus}`);
    } else {
        alert(`O livro ${livro} já foi marcado.`);
    }
}
