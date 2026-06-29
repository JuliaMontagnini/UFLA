from collections import deque
from No import No

class ArvoreBinariaBusca:
    def __init__(self):
        self.raiz = None
    
    def inserir(self, no: No, valor: int):
        if no is None:
            return No(valor)
        if valor < no.valor:
            no.esq = self.inserir(no.esq, valor)
        elif valor > no.valor:
            no.dir = self.inserir(no.dir, valor)
        else:
            pass # ignora valores repetidos
        return no
 
    def buscar(self, no: No, valor: int):
        if no is None:
            return False
        if valor == no.valor:
            return True
        if valor < no.valor:
            return self.buscar(no.esq, valor)
        else:
            return self.buscar(no.dir, valor)
        
    def remover(self, no: No, valor: int):
        if no is None:
            return None
        
        if valor < no.valor:
            no.esq = self.remover(no.esq, valor)
        elif valor > no.valor:
            no.dir = self.remover(no.dir, valor)
        else:
            if no.esq is None:
                return no.dir
            if no.dir is None:
                return no.esq
            
            sucessor = self.menor_no(no.dir)
            no.valor = sucessor.valor
            no.dir = self.remover(no.dir, sucessor.valor)
        return no
        
    def minimo(self, no: No):
        if no is None:
            return None
        
        atual = no
        while atual.esq is not None:
            atual = atual.esq
        return atual.valor
    
    def maximo(self, no: No):
        if no is None:
            return None
        
        atual = no
        while atual.dir is not None:
            atual = atual.dir
        return atual.valor
    
    def menor_no(self, no: No):
        atual = no
        while atual.esq is not None:
            atual = atual.esq
        return atual
    
    def pre_ordem(self, no: No):
        if no is not None:
            print(no.valor, end=" ")
            self.pre_ordem(no.esq)
            self.pre_ordem(no.dir)

    def em_ordem(self, no: No):
        if no is not None:
            self.em_ordem(no.esq)
            print(no.valor, end=" ")
            self.em_ordem(no.dir)
    
    def pos_ordem(self, no: No):
        if no is not None:
            self.pos_ordem(no.esq)
            self.pos_ordem(no.dir)
            print(no.valor, end=" ")

    def largura(self, raiz: No):
        fila = deque([raiz])
        while fila:
            no = fila.popleft()
            print(no.valor, end=" ")

            if(no.esq):
                fila.append(no.esq)
            if(no.dir):
                fila.append(no.dir)

    def contar_nos(self, no: No):
        if no is None:
            return 0
        return 1 + self.contar_nos(no.esq) + self.contar_nos(no.dir)
    
    def contar_folhas(self, no: No):
        if no is None:
            return 0
        if no.esq is None and no.dir is None:
            return 1
        return self.contar_folhas(no.esq) + self.contar_folhas(no.dir)
    
    def altura(self, no: No):
        if no is None:
            return -1
        
        h_esq = self.altura(no.esq)
        h_dir = self.altura(no.dir)
        return 1 + max(h_esq, h_dir)
    
    # se a arvore está vazia retorna True
    def vazia(self):
        return self.raiz is None