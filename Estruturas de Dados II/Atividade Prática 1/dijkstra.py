from GrafoPonderado import GrafoPonderado
from math import inf
import heapq

def dijkstra_heap(grafo: GrafoPonderado, origem: int):
    n_vertices = grafo.num_vertices
    dist = [inf] * n_vertices # vetor de distâncias inicia com infinitos
    pai = [None] * n_vertices # vetor de predecessores inicia "vazio"
    dist[origem] = 0
    fila = [(0, origem)] # distância, vértice - ordem de visitação já ordenada
    while fila: # analisa enquanto houver elementos
        distancia, vertice_atual = heapq.heappop(fila)
        if distancia > dist[vertice_atual]:
            continue # se a distância atual até o vértice é menor do que a nova não precisamos mexer

        for vizinho, peso in grafo.adj[vertice_atual]:
            # relaxar
            nova_distancia = dist[vertice_atual] + peso
            if nova_distancia < dist[vizinho]:
                dist[vizinho] = nova_distancia
                pai[vizinho] = vertice_atual
                # atualizamos a distância e colocamos na fila
                heapq.heappush(fila, (nova_distancia, vizinho))
    
    return dist, pai

def reconstruir_caminho(distancia: list, pai: list, destino: int):
    caminho = []
    atual = destino
    while atual is not None: # o pai da origem é none, quando chegar em none já concluiu o caminho
        caminho.append(atual) # adiciona ao caminho
        atual = pai[atual] # próxima análise é o predecessor

    caminho.reverse()
    custo = distancia[destino]
    return caminho, custo