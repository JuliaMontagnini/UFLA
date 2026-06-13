class UnionFind:
    def __init__(self, n):
        self.pai = list(range(n))

    def find(self, vertice):
        if self.pai[vertice] != vertice: # verifica se já é a raiz do conjunto
            self.pai[vertice] = self.find(self.pai[vertice])
        return self.pai[vertice]
    
    def union(self, u, v):
        pai_u = self.find(u)
        pai_v = self.find(v)
        if pai_u != pai_v: # se são de pais/conjuntos diferentes, unir! 
            self.pai[pai_v] = pai_u