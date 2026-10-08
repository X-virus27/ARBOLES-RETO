# ARBOLES-RETO
Reto de la prima clase del segundo parcial
## Integrantes
- **Maigua Lenin**
- **Oto Cristhoper**

## Descripción del proyecto

En este reto se trabajó con estructuras de datos de tipo árbol binario utilizando el lenguaje de programación Java. El objetivo fue construir, analizar y comparar dos árboles para identificar sus características y determinar cuándo un árbol se comporta como una lista enlazada.

## Actividades realizadas

**Parte 1: Construcción del árbol A**

Se construyó el árbol A utilizando los métodos `crearRaiz()`, `agregarIzquierdo()` y `agregarDerecho()`, respetando la estructura establecida en la guía.

**Parte 2: Consultas del árbol A**

Se realizaron consultas para obtener la raíz, la cantidad de nodos, las hojas, la altura y el grado de determinados nodos.

Los resultados fueron:
- Raíz: LTX
- Cantidad de nodos: 8
- Cantidad de hojas: 4
- Altura: 3
- Grado de LTX: 2
- Grado de SNC: 1

**Parte 3: Identificación de un árbol en cadena**

Se construyó el árbol B y se implementó el método `esCadena()`, que permite determinar si la altura de un árbol es igual a su cantidad de nodos menos uno.

Se obtuvieron los siguientes resultados:
- Árbol A: `false`
- Árbol B: `true`

Además, se comprobaron los casos límite de un árbol vacío, un árbol con un solo nodo y la inserción de un hijo en una posición ocupada.

## Conclusión

Se logró comprender el funcionamiento de los árboles binarios y sus principales operaciones. Se identificó que el árbol B presenta una estructura similar a una lista enlazada, debido a que cada nodo tiene un único hijo, lo que puede hacer que la búsqueda de información requiera recorrer todos sus nodos.
