package edu.escuelaing.arep.app.Lab;
/**
 *
 * @author Verbo Camacho Villamarin
 */
public class Node {
    private float valor;
    private Node next;
    /**
     * Builder of Node with value and next (null)
     * @param value float
     */
    public Node(float value){
        this.next= null;
        this.valor= value;

    }

    /**
     * Method to return the Node's value
     * @return valor float
     */
    public float getValue(){
        return valor;
    }

    /**
     * Method to return the next node of the head
     * @return next node
     */
    public Node getNext(){
        return next;
    }

    /**
     * Method to set the next node
     * @param next node
     * @return next node
     */
    public Node setNext(Node next){
        return this.next=next;
    }
}
