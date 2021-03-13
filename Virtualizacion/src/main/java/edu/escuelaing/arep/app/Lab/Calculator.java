package edu.escuelaing.arep.app.Lab;
/**
 *
 * @author Verbo Camacho Villamarin
 */
public class Calculator {
    LinkedList list = new LinkedList();

    /**
     * Builder of Calculator with a LinkedList
     * @param lista
     */
    public Calculator(LinkedList lista){
        this.list = lista;
    }
    /**
     * Method that makes the averages the list of nodes
     * @return result float
     */
    public float mean(){
        float result = list.sumNode()/list.getSize();
        return result ;
    }
    /**
     * Method that makes the standard deviation from the
     * list of nodes
     * @return deviation float
     */

    public float standarDeviation(){
        float media = list.sumNode()/list.getSize();
        float suma=0;

        for(int i=0;i<list.getSize();i++){
            suma += Math.pow(list.dataIndex(i)-media, 2);
        }

        float deviation = (float) Math.pow(suma/(list.getSize()-1), 0.5);
        return deviation;

    }
}
