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
            txt.crearFichero(ruta);
        } catch (NullPointerException er) {
            System.out.println("Error: " + er.getMessage());
        }
    }
}

class fichero {

    public void crearFichero( String ruta) {
        try {
            BufferedReader lecturaFichero = new BufferedReader(new FileReader( new File("cabecera.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ruta)));
            String linea = null;
	        while((linea = lecturaFichero.readLine()) != null){
                if(linea.contains("<body>")){
                    break;
                }
                bw.write(linea);
                bw.newLine();
            }	    
	        lecturaFichero = new BufferedReader(new FileReader( new File("temp2.txt")));
            while((linea = lecturaFichero.readLine()) != null){
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            lecturaFichero.close();
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    public void leerHTML(String ruta){
        try{
            File fichero = new File(ruta);
            File temp = new File("temp.txt");
            BufferedReader lecturaFichero = new BufferedReader(new FileReader(fichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            String linea = null;
            archivoConfig(ruta);
            while((linea = lecturaFichero.readLine()) != null){
                if(linea.contains("<body")){
                    bw.write(linea);
                    bw.newLine();
                    while((linea = lecturaFichero.readLine()) != null){
                        bw.write(linea);
                        bw.newLine();
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

    public void archivoConfig(String ruta){
        try{
        System.out.println(ruta);
        BufferedReader lecturaFichero = new BufferedReader(new FileReader(new File(ruta)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cabecera.txt")));
        String linea = null;    
            while((linea = lecturaFichero.readLine()) != null){
                System.out.println("Entro a While");
                if(linea.contains("<body")){
                    lecturaFichero.close();
                    bw.close();
                    return;
                }
                else{
                    System.out.println(linea);
                    bw.write(linea);
                    bw.newLine();
                }
            }
            lecturaFichero.close();
            bw.close();
        } catch(IOException error){
            System.out.println("Error de Lectura: " + error.getMessage());
        }

    }

    public void modificarFichero(){
        try{
            Scanner read = new Scanner(System.in);
            System.out.print("MENU\n1) Color de la Pagina\n2) Imagen\n3) Titulo de Pestaña de Pagina\n4) Titulo de Pagina\n5) H1\n6) Input\nQue deceas modificar: ");
            int opc = read.nextInt();

            switch(opc){
                case 1:
                body cuerpo = new body();
                cuerpo.modificar();
                    break;
                case 2:
                img image = new img();
                image.modificar();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                h1 h = new h1();
                h.modificar();
                    break;
                case 6:
                input inp = new input();
                inp.modificar();
                    break;
            }
        } catch(NullPointerException error){
        System.out.println("Error de Lectura: " + error.getMessage());
        }

    }
}
class body{
    public String direccion = null;
    private BufferedReader br;
    private BufferedWriter bw;
    body(){
        try {
        br = new BufferedReader(new FileReader(new File("temp.txt")));
        bw = new BufferedWriter(new FileWriter(new File("temp2.txt")));
        } catch (IOException error){
            System.out.println("Error de Constructor Body: " + error.getMessage());
        }
    }

    public void modificar(){
        try{
            Scanner read = new Scanner(System.in);
            String busqueda = "<body";
            String linea = null;
            String cadenaModificada;
                    while((linea = br.readLine()) != null){
                        System.out.println(linea);
                        System.out.println(busqueda);
                        
                        if(linea.contains(busqueda)){
                                System.out.println("entro a if");
                                cadenaModificada = conf();
                                System.out.println(cadenaModificada);
                                bw.write(cadenaModificada);
                                bw.newLine();
                        }
                        else{
                            System.out.println("no entro a if");
                            bw.write(linea);
                            bw.newLine();
                        }
                    }
                    bw.close();
                    br.close();
        } catch(IOException error){
        System.out.println("Error de Modificacion en Input: " + error.getMessage());
        }
    }

    public String conf(){
        Scanner read = new Scanner(System.in);
        System.out.print("background-color: ");
        String color = read.nextLine();
        String cadena = "<body style=\"background-color:"+color+";\">";
        return cadena;
    }
}
class img{
    public String direccion = null;
    private BufferedReader br;
    private BufferedWriter bw;
    img(){
        try {
        br = new BufferedReader(new FileReader(new File("temp.txt")));
        bw = new BufferedWriter(new FileWriter(new File("temp2.txt")));
        } catch (IOException error){
            System.out.println("Error de Constructor Img: " + error.getMessage());
        }
    }

    public void modificar(){
        try{
            Scanner read = new Scanner(System.in);
            System.out.print("Dame el ID de la imagen: ");
            String idInput = read.nextLine();
            String busqueda = "id=\""+idInput +"\"";
            String linea = null;
            String cadenaModificada;
                    while((linea = br.readLine()) != null){
                        System.out.println(linea);
                        System.out.println(busqueda);
                        
                        if(linea.contains(busqueda)){
                                System.out.println("entro a if");
                                cadenaModificada = conf();
                                System.out.println(cadenaModificada);
                                bw.write(cadenaModificada);
                                bw.newLine();
                        }
                        else{
                            System.out.println("no entro a if");
                            bw.write(linea);
                            bw.newLine();
                        }
                    }
                    bw.close();
                    br.close();
        } catch(IOException error){
        System.out.println("Error de Modificacion en Input: " + error.getMessage());
        }
    }

    public String conf(){
        Scanner read = new Scanner(System.in);
        System.out.print("Url: ");
        String src = read.nextLine();
        System.out.print("Encabezado: ");
        String alt = read.nextLine();
        System.out.print("Ancho: ");
        String width = read.nextLine();
        System.out.print("Alto: ");
        String height = read.nextLine();
        String cadena = "<img src=\""+src+"\" alt=\""+alt+"\" width=\""+width+"\" height=\""+height+"\" id=\"carro\">";
        return cadena;
    }
}
class h1{
    public String direccion = null;
    private BufferedReader br;
    private BufferedWriter bw;
    h1(){
        try {
        br = new BufferedReader(new FileReader(new File("temp.txt")));
        bw = new BufferedWriter(new FileWriter(new File("temp2.txt")));
        } catch (IOException error){
            System.out.println("Error: " + error.getMessage());
        }
    }

    public void modificar(){
        try{
            Scanner read = new Scanner(System.in);
            System.out.print("Que H1 deceas modificar, dame que numero de h1 es: ");
            int seleccion = read.nextInt();
            int i = 1;
            String linea = null;
            String cadenaModificada;
                    while((linea = br.readLine()) != null){
                        System.out.println(linea);
                        System.out.println(i);
                        System.out.println(seleccion);
                        
                        if(linea.contains("<h1")){
                            if(i == seleccion)
                            {
                                System.out.println("entro a seleccion");
                                cadenaModificada = conf();
                                System.out.println(cadenaModificada);
                                bw.write(cadenaModificada);
                                bw.newLine();
                                i++;
                            }
                            else{
                                System.out.println("no entro a seleccion");
                                i++;
                                bw.write(linea);
                                bw.newLine();
                            }
                        }
                        else{
                            System.out.println("no entro a if");
                            bw.write(linea);
                            bw.newLine();
                        }
                    }
                    bw.close();
                    br.close();
        } catch(IOException error){
        System.out.println("Error de Modificacion: " + error.getMessage());
        }
    }

    public String conf(){
        Scanner read = new Scanner(System.in);
        System.out.print("font-size: ");
        String tamano = read.nextLine() + "px;";
        System.out.print("font-family: ");
        String letra = read.nextLine() + ";";
        System.out.print("text-align: ");
        String alineacion = read.nextLine() + ";";
        System.out.print("color: ");
        String color = read.nextLine() + ";";
        System.out.print("texto: ");
        String texto = read.nextLine();
        String cadena = "<h1 style=\"font-size:"+tamano+ "font-family:" + letra + "text-align:" + alineacion + "color:" + color + "\">"+ texto +"</h1>";
        return cadena;
    }

}

class input{
    public String direccion = null;
    private BufferedReader br;
    private BufferedWriter bw;
    input(){
        try {
        br = new BufferedReader(new FileReader(new File("temp.txt")));
        bw = new BufferedWriter(new FileWriter(new File("temp2.txt")));
        } catch (IOException error){
            System.out.println("Error de Constructor Input: " + error.getMessage());
        }
    }

    public void modificar(){
        try{
            Scanner read = new Scanner(System.in);
            System.out.print("Dame el ID del input: ");
            String idInput = read.nextLine();
            String busqueda = "id=\""+idInput +"\"";
            String linea = null;
            String cadenaModificada;
                    while((linea = br.readLine()) != null){
                        System.out.println(linea);
                        System.out.println(busqueda);
                        
                        if(linea.contains(busqueda)){
                                System.out.println("entro a if");
                                cadenaModificada = conf();
                                System.out.println(cadenaModificada);
                                bw.write(cadenaModificada);
                                bw.newLine();
                        }
                        else{
                            System.out.println("no entro a if");
                            bw.write(linea);
                            bw.newLine();
                        }
                    }
                    bw.close();
                    br.close();
        } catch(IOException error){
        System.out.println("Error de Modificacion en Input: " + error.getMessage());
        }
    }

    public String conf(){
        Scanner read = new Scanner(System.in);
        System.out.print("type: ");
        String tipo = read.nextLine();
        System.out.print("value: ");
        String texto = read.nextLine();
        System.out.print("color: ");
        String color = read.nextLine();
        String cadena = "<input type=\""+tipo+"\" value=\""+texto+"\" id=\"button\" style=\"color:"+color+";\">";
        return cadena;
    }
}
