package edu.escuelaing.arep.app;
import static spark.Spark.*;
import java.io.IOException;
import edu.escuelaing.arep.app.Lab.ReadFileC;
import spark.Request;
import spark.Response;
/**
 * Hello world!
 *
 */
public class SparkWebApp {
    public static void main(String[] args){

        port(getPort());
        get("/",(req, res)-> homePage(req, res));
        get("/calculator",(req, res)-> calculatorPage(req,res));
        get("/result",(req, res)-> resultPage(req,res));
    }

    /**
     * @return the port 4567
     */
    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    /**
     * Method make the homepage in web
     * @param req
     * @param res
     * @return
     */
    private static String homePage(Request req, Response res) {

        String home = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "   \n"
                + "   <head>\n"
                + "      <title>Home Page</title>\n"
                + "   </head>\n"

                + "      <body bgcolor=\"#00FFFF\">"
                + "	\n"
                + "   <body>\n"
                + "<center>"
                + "      <h2>Calculadora de Media y Desviación Estandar</h2>\n"
                + "      <h3>Elaborado por: Verbo Julian Camacho V.</h3>\n"
                + "      <h3>Laboratorio Heroku</h3>\n"
                + "      <p>Esta aplicacion calcula la media y la desviacion estándar de un conjunto dado de N numeros.\n\n</p>\n"
                + "      <p>\n\nClick en el link para ir a la calculadora</p>\n"
                + "      <a href = \"/calculator\" target = \"_self\">Calculadora</a>\n"
                + "</center>"
                + "   </body>\n"
                + "	\n"
                + "</html>";
        return home;
    }

    /**
     * Method make the calculatorinput in web
     * @param req
     * @param res
     * @return
     * @throws IOException
     */
    private static String calculatorPage(Request req, Response res) throws IOException{

        String calculosHtml = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "   \n"
                + "   <head>\n"
                + "      <title>Calculadora</title>\n"
                + "   </head>\n"
                + "      <body bgcolor=\"#00FFFF\">"
                + "	\n"
                + "<body>"
                + "<center>"
                + "      <h2>Ingrese los datos</h2>\n"
                + "      <p>Ingrese los numeros separados por Guiones.</p>\n"
                + "      <p>Ejemplo: 1-2-3-89-45-78</p>\n"
                + "       <form action=\"/result\">\n"
                + "           Conjunto de numeros:<br> <br>\n"
                + "           <input type=\"text\" placeholder=\"Numeros\" name=\"inputData\" ><br><br>\n"
                + "           <input type=\"submit\" value=\"Calcular\">\n"
                // + "
                + "       </form>\n"
                + "</center>\n"
                + "</body>\n"
                + "</html>";
        return calculosHtml;

    }

    /**
     * Method make the resultPage in web
     * @param req
     * @param res
     * @return
     * @throws IOException
     */
    private static String resultPage(Request req, Response res) throws IOException{
        String result = req.queryParams("inputData");
        ReadFileC data = new ReadFileC();
        data.readWeb(result);
        float media = data.getMediaWeb();
        float desviacion = data.getDesviacionWeb();
        String resultado = ("<!DOCTYPE html>"
                + "<html>\n"
                + "<center>"
                + "   <head>\n"
                + "      <title>Resultado</title>\n"
                + "   </head>\n"
                + "      <body bgcolor=\"#00FFFF\">"
                + "	\n"
                + "<body>"
                + "<h2>Resultados</h2>"
                + "<h2>Media Estadística:"+ media +"</h2>"
                + "<h2>Desviación Estándar:" + desviacion + " </h2>"
                + " <a href = \"/\" target = \"_self\">HomePage</a>\n"

                + "</body>"
                + "</center>\n"
                + "</html>");

        return resultado;

    }
}
