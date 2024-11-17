import re

def le_assinatura():
    '''A funcao le os valores dos tracos linguisticos do modelo e devolve uma assinatura a ser comparada com os textos fornecidos'''
    print("Bem-vindo ao detector automático de COH-PIAH.")
    print("Informe a assinatura típica de um aluno infectado:")

    wal = float(input("Entre o tamanho médio de palavra:"))
    ttr = float(input("Entre a relação Type-Token:"))
    hlr = float(input("Entre a Razão Hapax Legomana:"))
    sal = float(input("Entre o tamanho médio de sentença:"))
    sac = float(input("Entre a complexidade média da sentença:"))
    pal = float(input("Entre o tamanho medio de frase:"))

    return [wal, ttr, hlr, sal, sac, pal]

def le_textos():
    '''A funcao le todos os textos a serem comparados e devolve uma lista contendo cada texto como um elemento'''
    i = 1
    textos = []
    texto = input("Digite o texto " + str(i) +" (aperte enter para sair):")
    while texto:
        textos.append(texto)
        i += 1
        texto = input("Digite o texto " + str(i) +" (aperte enter para sair):")

    return textos

def separa_sentencas(texto):
    '''A funcao recebe um texto e devolve uma lista das sentencas dentro do texto'''
    sentencas = re.split(r'[.!?]+', texto)
    if sentencas[-1] == '':
        del sentencas[-1]
    return sentencas

def separa_frases(sentenca):
    '''A funcao recebe uma sentenca e devolve uma lista das frases dentro da sentenca'''
    return re.split(r'[,:;]+', sentenca)

def separa_palavras(frase):
    '''A funcao recebe uma frase e devolve uma lista das palavras dentro da frase'''
    return frase.split()

def n_palavras_unicas(lista_palavras):
    '''Essa funcao recebe uma lista de palavras e devolve o numero de palavras que aparecem uma unica vez'''
    freq = dict()
    unicas = 0
    for palavra in lista_palavras:
        p = palavra.lower()
        if p in freq:
            if freq[p] == 1:
                unicas -= 1
            freq[p] += 1
        else:
            freq[p] = 1
            unicas += 1

    return unicas

def n_palavras_diferentes(lista_palavras):
    '''Essa funcao recebe uma lista de palavras e devolve o numero de palavras diferentes utilizadas'''
    freq = dict()
    for palavra in lista_palavras:
        p = palavra.lower()
        if p in freq:
            freq[p] += 1
        else:
            freq[p] = 1

    return len(freq)

def compara_assinatura(as_a, as_b):
    '''IMPLEMENTAR. Essa funcao recebe duas assinaturas de texto e deve devolver o grau de similaridade nas assinaturas.'''
    pass

def calcula_assinatura(texto):
    '''IMPLEMENTAR. Essa funcao recebe um texto e deve devolver a assinatura do texto.'''
    pass

def avalia_textos(textos, ass_cp):
    '''IMPLEMENTAR. Essa funcao recebe uma lista de textos e uma assinatura ass_cp e deve devolver o numero (1 a n) do texto com maior probabilidade de ter sido infectado por COH-PIAH.'''
    pass

def compara_assinatura(as_a, as_b):
    '''Essa função recebe duas assinaturas de texto e devolve o grau de similaridade nas assinaturas.'''
    soma_diferencas = 0
    for i in range(len(as_a)):
        soma_diferencas += abs(as_a[i] - as_b[i])
    
    return soma_diferencas / len(as_a)

def calcula_assinatura(texto):
    '''Essa função recebe um texto e deve devolver a assinatura do texto.'''
    
    # Separar o texto em sentenças
    sentencas = separa_sentencas(texto)
    
    # Separar as sentenças em frases
    frases = []
    for sentenca in sentencas:
        frases.extend(separa_frases(sentenca))
    
    # Separar as frases em palavras
    palavras = []
    for frase in frases:
        palavras.extend(separa_palavras(frase))
    
    # Calcular os valores da assinatura
    wal = sum(len(palavra) for palavra in palavras) / len(palavras)  # Tamanho médio da palavra
    ttr = n_palavras_diferentes(palavras) / len(palavras)  # Relação Type-Token
    hlr = n_palavras_unicas(palavras) / len(palavras)  # Razão Hapax Legomana
    sal = sum(len(sentenca) for sentenca in sentencas) / len(sentencas)  # Tamanho médio da sentença
    sac = len(frases) / len(sentencas)  # Complexidade média da sentença
    pal = sum(len(frase) for frase in frases) / len(frases)  # Tamanho médio de frase
    
    return [wal, ttr, hlr, sal, sac, pal]


def avalia_textos(textos, ass_cp):
    '''Essa função recebe uma lista de textos e uma assinatura ass_cp e deve devolver o número (1 a n) do texto com maior probabilidade de ter sido infectado por COH-PIAH.'''
    assinaturas = []
    for texto in textos:
        assinatura = calcula_assinatura(texto)
        assinaturas.append(assinatura)
    
    similaridades = [compara_assinatura(ass_cp, assinatura) for assinatura in assinaturas]
    
    # Encontrar o texto com menor similaridade (mais próximo da assinatura COH-PIAH)
    texto_infectado = similaridades.index(min(similaridades)) + 1
    
    return texto_infectado

