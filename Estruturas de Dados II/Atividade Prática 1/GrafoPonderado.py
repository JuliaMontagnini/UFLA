class GrafoPonderado:
    def __init__(self, num_vertices:int):
        self.num_vertices = num_vertices
        self.adj = [] # cria lista de adjacências

        for _ in range(num_vertices):
            # permite que cada vértice tenha uma lista que armazene seus vizinhos
            self.adj.append([]) 

    def adicionar_aresta(self, origem: int, destino: int, peso: int) -> None:
        # inclui na lista de adjacência u para v e v para u
        self.adj[origem].append((destino, peso))
        self.adj[destino].append((origem, peso))

    def exibir(self):
        # imprime toda a lista de adjacência, indicando o vértice e seus vizinhos
        for vertice in range(self.num_vertices):
            print(f"{vertice}: {self.adj[vertice]}")

    def vizinhos(self, vertice: int):
        # mostra apenas os vizinhos do vértice escolhido, sem os pesos, para uma visualização mais direta
        # viz = self.adj[vertice] # vizinho e peso
        viz = self.adj[vertice][0] # só vizinho
        print(f"\nVizinhos de {vertice}: {viz}")