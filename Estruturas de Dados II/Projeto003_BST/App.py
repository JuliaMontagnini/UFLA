from No import No
from ArvoreBinariaBusca import ArvoreBinariaBusca

bst = ArvoreBinariaBusca()
bst.raiz = bst.inserir(bst.raiz, 10)
bst.raiz = bst.inserir(bst.raiz, 5)
bst.raiz = bst.inserir(bst.raiz, 15)
bst.raiz = bst.inserir(bst.raiz, 2)
bst.raiz = bst.inserir(bst.raiz, 7)
bst.raiz = bst.inserir(bst.raiz, 12)
bst.raiz = bst.inserir(bst.raiz, 20)
print(f"\n=== INSERINDO VALORES ===")
bst.largura(bst.raiz)

print("\n\n=== PERCURSOS ===")
print("Pré-ordem:", end=" ")
bst.pre_ordem(bst.raiz)
print("\nEm-ordem:", end= " ")
bst.em_ordem(bst.raiz)
print("\nPós-ordem:", end=" ")
bst.pos_ordem(bst.raiz)

print("\n\n=== INFORMAÇÕES ===")
print(f"Altura da árvore: {bst.altura(bst.raiz)}")
print(f"Quantidade de nós: {bst.contar_nos(bst.raiz)}")
print(f"Quantidade de folhas: {bst.contar_folhas(bst.raiz)}")
print(f"Menor valor: {bst.minimo(bst.raiz)}")
print(f"Maior valor: {bst.maximo(bst.raiz)}")

print("\n=== BUSCAS ===")
if bst.buscar(bst.raiz, 7) == True:
    print("Buscar 7: encontrado")
else:
    print("Buscar 7: não encontrado")

if bst.buscar(bst.raiz, 12) == True:
    print("Buscar 12: encontrado")
else:
    print("Buscar 12: não encontrado")

if bst.buscar(bst.raiz, 99) == True:
    print("Buscar 99: encontrado")
else:
    print("Buscar 99: não encontrado")

if bst.buscar(bst.raiz, 1) == True:
    print("Buscar 1: encontrado")
else:
    print("Buscar 1: não encontrado")

print("\n=== REMOÇÃO DE NÓ FOLHA ===")
print("Removendo o nó 2...")
bst.raiz = bst.remover(bst.raiz, 2)
print(f"Percurso em-ordem:", end=" ")
bst.em_ordem(bst.raiz)

print("\n\n=== REMOÇÃO DE NÓ COM UM FILHO ===")
bst2 = ArvoreBinariaBusca()
bst2.raiz = bst2.inserir(bst2.raiz, 10)
bst2.raiz = bst2.inserir(bst2.raiz, 5)
bst2.raiz = bst2.inserir(bst2.raiz, 15)
bst2.raiz = bst2.inserir(bst2.raiz, 2)
bst2.raiz = bst2.inserir(bst2.raiz, 7)
bst2.raiz = bst2.inserir(bst2.raiz, 6)

print("Nova árvore:", end=" ")
bst2.largura(bst2.raiz)
print("\n\nRemovendo o nó 7...")
bst2.raiz = bst2.remover(bst2.raiz, 7)
print(f"Percurso em-ordem:", end=" ")
bst2.em_ordem(bst2.raiz)

print("\n\n=== REMOÇÃO DE NÓ COM DOIS FILHOS ===")
bst3 = ArvoreBinariaBusca()
bst3.raiz = bst3.inserir(bst3.raiz, 10)
bst3.raiz = bst3.inserir(bst3.raiz, 5)
bst3.raiz = bst3.inserir(bst3.raiz, 15)
bst3.raiz = bst3.inserir(bst3.raiz, 2)
bst3.raiz = bst3.inserir(bst3.raiz, 7)
bst3.raiz = bst3.inserir(bst3.raiz, 12)
bst3.raiz = bst3.inserir(bst3.raiz, 20)

print("Nova árvore:", end=" ")
bst3.largura(bst3.raiz)
print("\n\nRemovendo o nó 10...")
bst3.raiz = bst3.remover(bst3.raiz, 10)
print(f"Percurso em-ordem:", end=" ")
bst3.em_ordem(bst3.raiz)

print("\n\n=== ÁRVORE DEGENERADA ===")
bst4 = ArvoreBinariaBusca()
bst4.raiz = bst4.inserir(bst4.raiz, 1)
bst4.raiz = bst4.inserir(bst4.raiz, 2)
bst4.raiz = bst4.inserir(bst4.raiz, 3)
bst4.raiz = bst4.inserir(bst4.raiz, 4)
bst4.raiz = bst4.inserir(bst4.raiz, 5)

print("Valores inseridos:", end=" ")
bst4.largura(bst4.raiz)
print("\nPercurso em-ordem:", end=" ")
bst4.em_ordem(bst4.raiz)
print(f"\nAltura: {bst4.altura(bst4.raiz)}")
print(f"Quantidade de nós: {bst4.contar_nos(bst4.raiz)}")
print(f"Quantidade de folhas: {bst4.contar_folhas(bst4.raiz)}")