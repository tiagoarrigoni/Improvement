document.getElementById('cadastroForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const nome = document.getElementById('Nome').value.trim();
    const senha = document.getElementById('Senha').value.trim();

    if (!nome || !senha) {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    // Pega os dados existentes no localStorage
    let usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    // Verifica se o usuário já está cadastrado
    const usuarioExistente = usuarios.find(user => user.nome === nome);
    if (usuarioExistente) {
        alert('Usuário já cadastrado!');
        return;
    }

    // Adiciona o novo usuário com pontos e troféus iniciais
    usuarios.push({
        nome: nome,
        senha: senha,
        livrosMarcados: [], // Inicialmente sem livros marcados
        pontosTotais: 20, // 20 pontos iniciais
        trofeus: 5,   // 5 troféus iniciais
        livrosPorCategoria: {} // Inicializa sem livros por categoria
    });

    // Salva a lista atualizada no localStorage
    localStorage.setItem('usuarios', JSON.stringify(usuarios));

    alert('Cadastro realizado com sucesso!');
    window.location.href = 'login.html'; // Redireciona para a página de login
});

