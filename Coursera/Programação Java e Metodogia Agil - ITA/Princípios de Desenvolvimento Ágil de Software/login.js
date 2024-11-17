document.getElementById('acessar').addEventListener('click', function() {
    const nome = document.getElementById('nome').value.trim();
    const senha = document.getElementById('senha').value.trim();

    if (!nome || !senha) {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    // Pega os usuários cadastrados do localStorage
    const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    // Verifica se o nome e senha coincidem
    const usuarioEncontrado = usuarios.find(user => user.nome === nome && user.senha === senha);

    if (usuarioEncontrado) {
        // Salva o nome do usuário no sessionStorage
        sessionStorage.setItem('usuarioNome', nome);
        alert('Login bem-sucedido!');
        window.location.href = 'painelUsuario.html'; // Redireciona para a página do usuário
    } else {
        alert('Nome ou senha incorretos.');
    }
});

document.getElementById('registrar').addEventListener('click', function() {
    window.location.href = 'cadastro.html'; // Redireciona para a página de cadastro
});
