package reto;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;
import arboles.app.VistaArbol;

public class MainReto {

    public static void main(String[] args) {
        // ==========================================
        // Parte 1: Construir el árbol A
        // ==========================================
        ArbolBinario<String> arbolA = new ArbolBinario<>();
        Nodo<String> ltx = arbolA.crearRaiz("LTX");
        
        Nodo<String> atf = arbolA.agregarIzquierdo(ltx, "ATF");
        arbolA.agregarIzquierdo(atf, "TUA");
        arbolA.agregarDerecho(atf, "IBB");
        
        Nodo<String> mch = arbolA.agregarDerecho(ltx, "MCH");
        Nodo<String> snc = arbolA.agregarIzquierdo(mch, "SNC");
        arbolA.agregarIzquierdo(snc, "LGQ");
        arbolA.agregarDerecho(mch, "OCC");

        // ==========================================
        // Parte 2: Consultar
        // ==========================================
        System.out.println("--- Parte 2: Consultar Árbol A ---");
        System.out.println("Raíz: " + arbolA.getRaiz().getDato());
        System.out.println("Cantidad de nodos: " + arbolA.contarNodos());
        System.out.println("Cantidad de hojas: " + arbolA.contarHojas());
        System.out.println("Altura: " + arbolA.altura());
        System.out.println("Grado de LTX: " + ltx.grado());
        System.out.println("Grado de SNC: " + snc.grado());
        System.out.println();

        // ==========================================
        // Parte 3: Decidir
        // ==========================================
        // 1. Construir el árbol B
        ArbolBinario<String> arbolB = new ArbolBinario<>();
        Nodo<String> gps = arbolB.crearRaiz("GPS");
        Nodo<String> scy = arbolB.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbolB.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbolB.agregarDerecho(mrr, "PTZ");
        arbolB.agregarDerecho(ptz, "TPN");

        // 3. Probar esCadena con el árbol A y con el árbol B
        System.out.println("--- Parte 3: Decidir ---");
        System.out.println("¿El árbol A es cadena? " + esCadena(arbolA));
        System.out.println("¿El árbol B es cadena? " + esCadena(arbolB));
        System.out.println();
        
        // 4. Responder
        System.out.println("Respuesta a la pregunta 4:");
        System.out.println("El árbol B se parece a una lista enlazada (es un árbol degenerado).");
        System.out.println("Al buscar un dato en él, se perdería la eficiencia logarítmica de un");
        System.out.println("árbol binario equilibrado. Habría que recorrer nodo por nodo secuencialmente,");
        System.out.println("por lo que tomaría un tiempo proporcional a la cantidad de nodos (O(n)).");
        System.out.println();

        // ==========================================
        // Casos límite que deben probar
        // ==========================================
        System.out.println("--- Casos límite ---");
        
        // Árbol vacío
        ArbolBinario<String> arbolVacio = new ArbolBinario<>();
        System.out.println("Árbol vacío: " + esCadena(arbolVacio));

        // Árbol de un solo nodo
        ArbolBinario<String> arbolUnNodo = new ArbolBinario<>();
        arbolUnNodo.crearRaiz("Unico");
        System.out.println("Árbol de un solo nodo: " + esCadena(arbolUnNodo));

        // Agregar un hijo donde ya hay uno
        System.out.print("Agregar un hijo donde ya hay uno: ");
        try {
            arbolA.agregarDerecho(ltx, "ERROR");
        } catch (IllegalStateException e) {
            System.out.println("Mensaje capturado -> " + e.getMessage());
        }
        System.out.println();
        
        // ==========================================
        // Entrega Extra (Camino I, D, I)
        // ==========================================
        System.out.println("--- Entrega Extra ---");
        Nodo<String> actual = arbolA.getRaiz(); // LTX
        
        if (actual != null) {
            actual = actual.getIzquierdo(); // I (ATF)
            if (actual != null) {
                actual = actual.getDerecho(); // D (IBB)
                if (actual != null) {
                    actual = actual.getIzquierdo(); // I (null, IBB no tiene hijo izquierdo)
                }
            }
        }
        
        System.out.print("Camino I, D, I en el árbol A: ");
        if (actual != null) {
            System.out.println("Aeropuerto " + actual.getDato());
        } else {
            System.out.println("null (No se encuentra ningún aeropuerto, se llega a un nodo vacío)");
        }
    }

    // 2. Escribir método esCadena
    static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol.esVacio()) {
            return false;
        }
        // Un árbol es una cadena cuando su altura es igual a su cantidad de nodos menos 1.
        return arbol.altura() == (arbol.contarNodos() - 1);
    }
}
