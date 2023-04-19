package hash;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Uma estrutura de dados de dicionário utiliza uma tabela hash de endereçamento aberto
 * com o tratamento de colisões por encadeamento separado:
 * Isto é, uma lista (ArrayList) de listas encadeadas (LinkedList). O parâmetro max no
 * construtor especifica a capacidade da lista principal.
 * Escreva o código para a inserção (método put). Ele deverá inserir o par chave-valor (ex:
 * criar um objeto Entrada), sobrescrevendo o valor antigo se o dicionário já contém a
 * chave. Considere que a função de hash é chave % max
 */

public class Dic {

    private class Entrada {
        public int chave ;
        public String valor ;

        public Entrada(int chave, String valor){
            this.chave = chave;
            this.valor = valor;
        }

    }

    private ArrayList<LinkedList<Entrada>> dados ;

    public Dic(int max) {
        dados = new ArrayList<> () ;
        for(int i=0 ; i< max ; i++)
            dados.add(new LinkedList< > ()) ;
    }


    public void put(int chave , String valor) {
        int index = chave % dados.size();
        Entrada entrada = new Entrada(chave, valor);
        LinkedList<Entrada> bucketList = dados.get(index);
        for (Entrada e: bucketList){
            if(e.chave == chave){
                e.valor = valor;
                return;
            }
        }
        bucketList.add(entrada);
    }

    public String get (int chave){
        int index = chave % dados.size();
        LinkedList<Entrada> bucketList = dados.get(index);
        for (Entrada e : bucketList){
            if (e.chave == chave){
                return e.valor;
            }
        }
        return null;
    }

    public void remove (int chave){
        int index = chave % dados.size();
        LinkedList<Entrada> bucketList = dados.get(index);
        for (Entrada e : bucketList){
            if (e.chave == chave){
                bucketList.remove(e);
            }
        }
    }

    public static void main(String[] args) {

        var dic = new Dic(10);

        dic.put(4, "Marcelo");
        dic.put(2, "Rodrigo");
        dic.put(239, "Joao");
        dic.put(12, "Andre");

        System.out.println(dic.get(4));
        System.out.println(dic.get(2));
        System.out.println(dic.get(239));
        System.out.println(dic.get(12));
        System.out.println(dic.get(302198));

        dic.remove(4);
        dic.put(12, "Alexandre");
        System.out.println();

        System.out.println(dic.get(4));
        System.out.println(dic.get(2));
        System.out.println(dic.get(239));
        System.out.println(dic.get(12));
        System.out.println(dic.get(302198));
    }
}
