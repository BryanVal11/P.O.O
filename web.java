import java.util.*;
import java.io.*;

public class web{
    public static void main(String[] args) {
        try {
            System.out.print("Dame la direccion del archivo html: ");
            Scanner entrada = new Scanner(System.in);
            String ruta = entrada.nextLine();
            fichero txt = new fichero();
            txt.leerHTML(ruta);
        } catch (NullPointerException er) {
            System.out.println("Error: " + er.getMessage());
        }
    }
}

class fichero {

    public void crearFichero() {
        try {
            System.out.println("Que nombre  deceas ponerle al archivo: ");
            Scanner read = new Scanner(System.in);
            String name = read.nextLine();
            File fichero = new File(name + ".html");
            BufferedWriter bw;
                File temp = new File("temp.txt");
                BufferedReader lecturaFichero = new BufferedReader(new FileReader(temp));
                String linea = null;
                bw = new BufferedWriter(new FileWriter(fichero));
                while((linea = lecturaFichero.readLine()) != null){
                    bw.write(linea);
                }
            bw.close();
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    public void leerHTML(String ruta){
        try{
            File fichero = new File("html.txt");
            File temp = new File("temp.txt");
            BufferedReader lecturaFichero = new BufferedReader(new FileReader(fichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            String linea = null;
            
            while((linea = lecturaFichero.readLine()) != null){
                if(linea.contains("<body>")){
                    while((linea = lecturaFichero.readLine()) != null){
                        bw.write(linea);
                    }
                }
            }
            lecturaFichero.close();
            bw.close();
            modificarFichero();
        } catch(IOException error){
            System.out.println("Error de Lectura: " + error.getMessage());
        }
    }

    public void modificarFichero(){
        try{
            /*BufferedReader br = new BufferedReader(new FileReader(new File("temp.txt")));
            String linea = null;*/
            Scanner read = new Scanner(System.in);
            System.out.print("MENU\n1) Color de la Pagina\n2) Fondo de la Pagina\n3) Titulo de Pestaña de Pagina\nTitulo de Pagina\nQue deceas modificar: ");
            int opc = read.nextInt();

            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        } catch(NullPointerException error){
        System.out.println("Error de Lectura: " + error.getMessage());
        }

    }
}
class h1{
    private static String direccion = null;
    private static BufferedReader br = new BufferedReader(new FileReader(new File(direccion)));
    private static BufferedWriter bw = new BufferedWriter(new FileWriter(new File("temp2.txt")));
    h1(String ubicacion){
        direccion = ubicacion;
    }

    public void modificar(){
        try{
            Scanner read = new Scanner(System.in);
            System.out.println("Que H1 deceas modificar, dame que numero de h1 es: ");
            int seleccion = read.nextInt();
            System.out.print("MENU\n1) font-size\n2) font-family\n3) text-align\nQue deceas modificar: ");
            int opc = read.nextInt();
            int i = 1;
            String cadenaModificada;
            switch(opc){
                case 1:
                    while((linea = br.readLine()) != null){
                        if(linea.contains("<a>")){
                            if(i == seleccion)
                            {
                                cadenaModificada = font_size();
                                bw.write(cadenaModificada);
                            }
                            else{
                                i++;
                                bw.write(linea);
                            }
                        }
                        else{
                            bw.write(linea);
                        }
                    }    
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } catch(NullPointerException error){
        System.out.println("Error de Modificacion: " + error.getMessage());
        }
    }

    public String font_size(){
        return "";
    }

}
