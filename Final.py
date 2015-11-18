# -*- coding: utf-8 -*-
"""
Created on Mon Nov 16 18:46:23 2015

@author: Diego
"""

import networkx as nx
import matplotlib.pyplot as plt
import random as r
import timeit 
#tamaño del grafo
m = 15

#Obstaculo en el grafo y sus nodos
obstacle = [((1,1),(1,2)),((2,1),(2,2)),((1,1),(2,1)),((2,2),(1,2)),((0,1),(1,1)),((0,2),(1,2)),((0,1),(0,2)),((2,2),(3,2)),((2,2),(2,3)),((2,3),(3,3)),((3,2),(3,3)),((2,2),(3,2)),((3,3),(4,3)),((3,2),(4,2)),((4,2),(4,3)),((4,1),(4,2))]
obstacleNode = [(1,1),(1,2),(2,1),(2,2),(0,1),(0,2),(3,2),(4,2),(2,3),(3,3),(4,3)]

#Grafo en 2 dimensiones tamaño m
g = nx.grid_2d_graph(m,m)
pos = dict((n,n) for n in g.nodes())
listNodes = g.nodes()
listEdges = g.edges()

#Agrego los nodos  a un grafo que si se puede editar
G = nx.Graph()
G.add_nodes_from(listNodes)


#inicio de funciones
#funcion para obtener el peso de un path
def getWeight(path):
    wpath=0
    i=0
    for i in range(len(path)-1):
        if(i<len(path)-1):
            dummy = G.get_edge_data(path[i],path[i+1])
            wpath = wpath + dummy['weight']
        
    print wpath
#funcion para agregar nodos desde un listado de aristas
def addEdge(listEdges):
    for edge in listEdges:
        u = tuple(edge[0])
        v = tuple(edge[1])
        G.add_edge(u,v,weight=1)
#funcion para la heuristica
def dist(a, b):
    (x1, y1) = a
    (x2, y2) = b
    return  ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5
#Agregar arista segun probabilidad 
def addProbEdge(listNodes):
    for i in range(14):
        for j in range(14,0,-1):
            p = r.randint(0,1)
            if(p==0):     
                if(i<14) and (j>0):
                    u = (i, j)
                    v = (i+1,j-1)
                    G.add_edge(u,v,weight = 1.42)
            else:
                if(i<14) and (j>0):
                    u = (i+1, j)
                    v = (i,j-1)
                    G.add_edge(u,v,weight = 1.42)
#agregar una aristas con un peso segun su posicion                 
def addPerPosEdge(listEdges):
    for edge in listEdges:
        u = tuple(edge[0])
        v = tuple(edge[1])
        #Vertical
        if(u[0]==v[0]) and (u[1]+1==v[1]):
            G.add_edge(u,v,weight=u[0]+u[1])
        elif(u[0]==v[0]) and (v[1]+1==u[1]):
            G.add_edge(u,v,weight=u[0]+v[1])
        #Horizontal
        else:
            G.add_edge(u,v,weight=1)
#Agrego un obstaculo ya prestablido       
def addObstacle(listEdges):
    for edge in listEdges:
        u = tuple(edge[0])
        v = tuple(edge[1])
        if edge not in obstacle:
            G.add_edge(u,v,weight=1)
        else:
            print u,v
            G.add_edge(u,v,weight=99999)
#Agrego aristas con peso random          
def addRandomEdge(listEdges):
    for edge in listEdges:
        u = tuple(edge[0])
        v = tuple(edge[1])
        p = r.randint(1,500)
        G.add_edge(u,v,weight=p)
  

#Listado de opciones 

 
#1    
#addEdge(listEdges)
#2
#addEdge(listEdges)
#addProbEdge(listNodes)
#3
#addPerPosEdge(listEdges)
#4
#addEdge(listEdges)
#addObstacle(listEdges)
#5
addRandomEdge(listEdges)

laberinth = nx.minimum_spanning_tree(G)
laberinthListEdges = laberinth.edges()

#nodo inicial
u = tuple((0,0))
#nodo final
v = tuple((14,14))

#
tic=timeit.default_timer()
path1 = nx.dijkstra_path(G,u,v)
toc=timeit.default_timer()
print toc-tic
path2 = nx.astar_path(G,u,v,dist)
#Laberinto
path3 = nx.dijkstra_path(laberinth,u,v)
path4 = nx.astar_path(laberinth,u,v,dist)

print 'A*'
getWeight(path1)
print 'Dijkstra'
getWeight(path2)
print 'Laberinth A*'
getWeight(path3)
print 'Laberinth Dijkstra'
getWeight(path4)

#Opciones
#1,2,3
#nx.draw_networkx(G,pos=pos,nodelist=path1,alpha=1,edge_color='g',node_color='g',with_labels=False,node_size=75)
#nx.draw_networkx(G,pos=pos,nodelist=path2,alpha=1,edge_color='y',node_color='y',with_labels=False,node_size=75)
#nx.draw_networkx(G,pos=pos,nodelist=listNodes,alpha=0.5,edge_color='r',node_color='r',with_labels=False,node_size=30)
#4
#nx.draw_networkx(G,pos=pos,nodelist=obstacleNode,alpha=1,edge_color='black',node_color='black',with_labels=False,node_size=75)

#5
nx.draw_networkx(laberinth,pos=pos,node_size=30,with_labels=False)
nx.draw_networkx(G,pos=pos,nodelist=path3,alpha=1,node_color='b',edge_color='white',with_labels=False,node_size=75)
nx.draw_networkx(G,pos=pos,nodelist=path4,alpha=1,node_color='y',edge_color='white',with_labels=False,node_size=75)
nx.draw_networkx(G,pos=pos,edgelist=laberinthListEdges,alpa=0,node_size=0,with_labels=False)




plt.axis('off') 
plt.show

