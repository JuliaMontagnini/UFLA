# importando as funções dos outros arquivos
from GrafoPonderado import GrafoPonderado
from dijkstra import * # importa os dois métodos de uma vez
from prim import prim
from kruskal import kruskal

if __name__ == "__main__": # função main que será executada
    grafo = GrafoPonderado(9) # criando o objeto "grafo" com 9 vértices
    # adicionando todas as arestas com seus respectivos pesos
    grafo.adicionar_aresta(0, 1, 4)
    grafo.adicionar_aresta(0, 2, 2)
    grafo.adicionar_aresta(1, 2, 1)
    grafo.adicionar_aresta(1, 3, 5)
    grafo.adicionar_aresta(2, 3, 8)
    grafo.adicionar_aresta(2, 4, 10)
    grafo.adicionar_aresta(3, 4, 2)
    grafo.adicionar_aresta(3, 5, 6)
    grafo.adicionar_aresta(4, 5, 3)
    grafo.adicionar_aresta(4, 6, 7)
    grafo.adicionar_aresta(5, 6, 1)
    grafo.adicionar_aresta(5, 7, 9)
    grafo.adicionar_aresta(6, 7, 4)
    grafo.adicionar_aresta(6, 8, 6)
    grafo.adicionar_aresta(7, 8, 2)
    
    print("=== GRAFO ===")
    grafo.exibir()
    grafo.vizinhos(0)

    print("\n=== DIJKSTRA origem 0 ===")
    distancias, pais = dijkstra_heap(grafo, 0)
    print(f"Menores distâncias de 0 aos demais vértices: {distancias}")
    print(f"Pais: {pais}")

    caminho5, custo5 = reconstruir_caminho(distancias, pais, 5)
    print(f"\nCaminho 0 -> 5: {caminho5}")
    print(f"Custo: {custo5}")

    caminho8, custo8 = reconstruir_caminho(distancias, pais, 8)
    print(f"\nCaminho 0 -> 8: {caminho8}")
    print(f"Custo: {custo8}")

    print("\n=== DIJKSTRA origem 4 ===")
    distancias, pais = dijkstra_heap(grafo, 4)
    print(f"Menores distâncias de 4 aos demais vértices: {distancias}")
    print(f"Pais: {pais}")

    caminho7, custo7 = reconstruir_caminho(distancias, pais, 7)
    print(f"\nCaminho 4 -> 7: {caminho7}")
    print(f"Custo: {custo7}")

    caminho0, custo0 = reconstruir_caminho(distancias, pais, 0)
    print(f"\nCaminho 4 -> 0: {caminho0}")
    print(f"Custo: {custo0}")

    print("\n=== PRIM origem 0 ===")
    mst, custo_p, ordem_visita = prim(grafo, 0)
    print(f"Arestas selecionadas:\n{mst}")
    print(f"Custo total: {custo_p}")
    print(f"\nOrdem em que os vértices foram adicionados: {ordem_visita}")
    # teste 2
    print("\n=== PRIM origem 5 ===")
    mst, custo_p, ordem_visita = prim(grafo, 5)
    print(f"Arestas selecionadas:\n{mst}")
    print(f"Custo total: {custo_p}")
    print(f"\nOrdem em que os vértices foram adicionados: {ordem_visita}")

    print("\n=== KRUSKAL ===")
    arestas_ordenadas, mst, arestas_descartadas, custo_k = kruskal(grafo)
    print(f"Arestas ordenadas por peso:\n{arestas_ordenadas}")
    print(f"\nArestas selecionadas:\n{mst}")
    print(f"Arestas descartadas (formam ciclo):\n{arestas_descartadas}")
    print(f"\nCusto total: {custo_k}")