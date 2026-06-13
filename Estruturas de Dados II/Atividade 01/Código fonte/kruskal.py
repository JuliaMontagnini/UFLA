from GrafoPonderado import GrafoPonderado
from UnionFind import UnionFind

def kruskal(grafo: GrafoPonderado):
    num_vertices = grafo.num_vertices
    arestas = [] # uniremos todas as arestas em uma lista para ordená-las
    
    for i in range(num_vertices): # pega a lista de adjacência de cada vértice
        for j in range(len(grafo.adj[i])): # pega cada aresta que pode ser formada com aquele vértice 
            # organizando a aresta com todas as informações - origem, destino e peso
            aresta = (i, grafo.adj[i][j][0], grafo.adj[i][j][1])
            aresta_inversa = (aresta[1], aresta[0], aresta[2]) # para verificar se não estamos adicionando uma aresta duplicada
            if aresta_inversa not in arestas:
                arestas.append(aresta)

    # ordena pelo elemento na posição 2 de cada aresta (o peso)
    arestas.sort(key=lambda aresta: aresta[2])

    uf = UnionFind(num_vertices) # construtor do objeto
    mst = []
    arestas_descartadas = []
    custo = 0
    for u, v, peso in arestas:
        if uf.find(u) != uf.find(v): # não forma ciclo, pode ser adicionada!
            uf.union(u, v)
            mst.append((u, v, peso))
            custo += peso
        else: # froma ciclo, "descarta" e registra na lista de descartadas
            arestas_descartadas.append((u, v, peso)) 
    return arestas, mst, arestas_descartadas, custo