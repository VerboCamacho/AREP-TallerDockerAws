package edu.escuelaing.arep.app.Lab;
/**
 *
 * @author Verbo Camacho Villamarin
 */
public class LinkedList {
    private Node head;
    private int size;

    /**
     * Builder of LinkedList
     * with head null and size 0
     */

    public LinkedList(){
        head = null;
        size=0;
    }
    /**
     * Method to add a new node for the LinkedList
     * @param value float
     */
    public void addNode(float value){
        Node nodo1 = new Node(value);
        if (this.head == null){
            this.head = nodo1;
        }else{
            Node aux = head;
            while(aux.getNext()!=null){
                aux=aux.getNext();
            }
            aux.setNext(nodo1);
        }
        size++;
    }

    /**
     * Method to return the size of the LinkedList
     * @return size int
     */
    public int getSize(){
        return size;
    }
    /**
     * Method to return the sum of the all nodes in the LinkedList
     * @return sum float
     */
    public float sumNode(){
        Node nodo3 = head;
        float suma = nodo3.getValue();
        while (nodo3.getNext()!=null){
            nodo3 = nodo3.getNext();
            suma += nodo3.getValue();
        }
        return suma;


    }
    /**
     * Method to return a node data with index
     * @param index int
     * @return retorna float
     */
    public float dataIndex(int index){
        float retorna;
        Node nodo4 = head;
        for(int i=0;i<index;i++){
            //System.out.println(i);
            nodo4 = nodo4.getNext();
        }
        retorna = nodo4.getValue();
        return retorna;
    }
}
