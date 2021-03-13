package edu.escuelaing.arep.app.Lab;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Verbo Camacho Villamarin
 */
public class ReadFileC {
    LinkedList lista = null;
    float mediaWeb,desviacionWeb;
    /**
     * Method to read the file
     * @param  archivo String
     *
     */
    public void ReadFile(String archivo) {
        try{
            lista= new LinkedList();
            String lectura;
            BufferedReader lector = new BufferedReader(new FileReader(archivo));

            while ((lectura = lector.readLine())!= null){
                lista.addNode(Float.parseFloat(lectura));
            }
            lector.close();

        }catch(Exception e){
            System.err.println("Archivo no encontrado");
        }
    }

    /**
     * Method to get the list with data
     * @return lista LinkedList
     */

    public LinkedList getData(){

        return lista;
    }

    /**
     * Method to read de input line in the app
     * @param form
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readWeb (String form) throws FileNotFoundException, IOException{
        LinkedList lista = new LinkedList();

        String[] inPut = form.split("-");
        //System.out.println(inPut.length);
        for(String i:inPut){
            float a = Float.parseFloat(i);
            lista.addNode(a);
        }

        Calculator calculadora = new Calculator(lista);
        mediaWeb = calculadora.mean();
        desviacionWeb = calculadora.standarDeviation();

    }

    /**
     * @return mediaWeb
     */
    public float getMediaWeb(){
        return mediaWeb;
    }

    /**
     * @return desviacionWeb
     */
    public float getDesviacionWeb(){
        return desviacionWeb;
    }




}
