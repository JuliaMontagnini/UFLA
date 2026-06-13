from GrafoPonderado import GrafoPonderado
import heapq

def prim(grafo: GrafoPonderado, origem: int):
    visitados = [origem]
    arestas = []

    for vizinho, peso in grafo.adj[origem]:
        # coloca os vizinhos na lista de arestas ordenando com heap
        heapq.heappush(arestas, (peso, origem, vizinho))
    
    mst = []
    custo = 0

    while arestas:
        # retira o primeiro elemento da fila e guarda seus componentes em outras variáveis
        peso, u, v = heapq.heappop(arestas)
        if v in visitados:
            continue # se o vértice já foi visitado pula para a próxima iteração 

        visitados.append(v)
        mst.append((u, v, peso))
        custo += peso

        for vizinho, peso in grafo.adj[v]:
            if vizinho not in visitados: # adiciona os adjacentes ao novo vértice não visitado
                heapq.heappush(arestas, (peso, v, vizinho))

    return mst, custo, visitados