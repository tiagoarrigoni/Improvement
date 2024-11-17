function voltar() {
    window.history.back();
}


function visualizarLivro(livro, imagemUrl) {
    // Atualiza a imagem do livro no modal
    document.getElementById('bookImage').src = imagemUrl;

    // Exibe o modal
    document.getElementById('bookModal').style.display = 'block';
}

function marcarLeitura(livro) {
    // Recupera a lista de livros do localStorage ou cria uma nova lista se não existir
    let livrosMarcados = JSON.parse(localStorage.getItem('livrosMarcados')) || [];

    // Verifica se o livro já está na lista
    if (!livrosMarcados.includes(livro)) {
        // Adiciona o livro à lista
        livrosMarcados.push(livro);
        alert(`Leitura marcada para: ${livro}`);
    } else {
        alert(`O livro ${livro} já foi marcado.`);
    }

    // Salva a lista de volta no localStorage
    localStorage.setItem('livrosMarcados', JSON.stringify(livrosMarcados));
}

// Função para carregar e exibir a lista de livros marcados
function carregarLivrosMarcados() {
    let livrosMarcados = JSON.parse(localStorage.getItem('livrosMarcados')) || [];
    const lista = document.getElementById('listaLivrosMarcados');
    lista.innerHTML = ''; // Limpa a lista antes de preenchê-la

    if (livrosMarcados.length === 0) {
        lista.innerHTML = '<li>Nenhum livro marcado.</li>';
    } else {
        livrosMarcados.forEach(livro => {
            const li = document.createElement('li');
            li.textContent = livro;
            lista.appendChild(li);
        });
    }
}

// Chama a função ao carregar a página
document.addEventListener('DOMContentLoaded', carregarLivrosMarcados);

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

// Função para carregar e exibir a lista de livros marcados
function carregarLivrosMarcados() {
    let livrosMarcados = JSON.parse(localStorage.getItem('livrosMarcados')) || [];
    const lista = document.getElementById('listaLivrosMarcados');
    lista.innerHTML = ''; // Limpa a lista antes de preenchê-la

    if (livrosMarcados.length === 0) {
        lista.innerHTML = '<li>Nenhum livro marcado.</li>';
    } else {
        livrosMarcados.forEach(livro => {
            const li = document.createElement('li');
            li.textContent = livro;
            lista.appendChild(li);
        });
    }
}

// Chama a função ao carregar a página
document.addEventListener('DOMContentLoaded', carregarLivrosMarcados);
