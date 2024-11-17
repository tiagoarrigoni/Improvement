def computador_escolhe_jogada(n, m):
    # Computador tenta encontrar o número ideal de peças para remover
    for i in range(1, m + 1):
        if (n - i) % (m + 1) == 0:
            return i
    return min(n, m)  # Caso não ache, remove o máximo possível (m ou n)

def usuario_escolhe_jogada(n, m):
    # Usuário escolhe o número de peças para remover
    jogada = int(input(f"Quantas peças você vai tirar (1 a {m})? "))
    while jogada < 1 or jogada > m or jogada > n:
        print("Oops! Jogada inválida! Tente de novo.")
        jogada = int(input(f"Quantas peças você vai tirar (1 a {m})? "))
    return jogada

def partida():
    # Solicita valores de n e m
    n = int(input("Quantas peças no jogo? "))
    m = int(input("Limite de peças por jogada? "))
    
    # Verifica quem começa a jogar
    if n % (m + 1) == 0:
        print("Você começa!")
        jogador_atual = "usuario"
    else:
        print("Computador começa!")
        jogador_atual = "computador"
    
    # Loop do jogo até acabar as peças
    while n > 0:
        if jogador_atual == "computador":
            jogada = computador_escolhe_jogada(n, m)
            print(f"O computador tirou {jogada} peça(s).")
            jogador_atual = "usuario"
        else:
            jogada = usuario_escolhe_jogada(n, m)
            print(f"Você tirou {jogada} peça(s).")
            jogador_atual = "computador"
        
        # Atualiza o número de peças restantes
        n -= jogada
        print(f"Agora restam {n} peça(s) no tabuleiro.")
    
    # Fim de jogo, verifica quem ganhou
    if jogador_atual == "usuario":
        print("O computador ganhou!")
    else:
        print("Você ganhou!")

def campeonato():
    # Realiza três partidas consecutivas
    placar_computador = 0
    placar_usuario = 0

    for i in range(3):
        print(f"**** Rodada {i + 1} ****")
        partida()
        if "O computador ganhou!" in globals():
            placar_computador += 1
        else:
            placar_usuario += 1
    
    # Exibe o placar final do campeonato
    print("**** Final do campeonato! ****")
    print(f"Placar: Você {placar_usuario} X {placar_computador} Computador")

# Execução principal
print("Bem-vindo ao jogo NIM! Escolha:")
print("1 - para jogar uma partida isolada")
print("2 - para jogar um campeonato")

opcao = int(input())

if opcao == 1:
    print("Você escolheu uma partida isolada!")
    partida()
elif opcao == 2:
    print("Você escolheu um campeonato!")
    campeonato()
