package br.com.pedrociarlini.bonitaviaandroid.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by pedrociarlini on 1/25/17.
 */

public class Dados implements Serializable {
    /**
     * Produto
     */
    public HashMap<String, Integer> pedidos = new HashMap<String, Integer>();

    /**
     * Nome da mesa
     */
    public String mesaAtual;

    /**
     * Nome do sujeito
     */
    public String nome;

    public Dados() {
        pedidos.put("Exemplo", 5);
    }
}
