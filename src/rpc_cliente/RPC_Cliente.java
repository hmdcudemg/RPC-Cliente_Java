package rpc_cliente;
import java.util.*;
import org.apache.xmlrpc.*;

public class RPC_Cliente {
 public static void main (String [] args) {
  try {

     XmlRpcClient cliente = new XmlRpcClient("http://localhost:80/"); 
     Vector<String> text = new Vector<String>();
     Vector<Integer> params = new Vector<Integer>();
     String mensaje = "Ivanovich";
     text.addElement(mensaje);
     params.addElement(new Integer(2));
     params.addElement(new Integer(15));
     System.out.println("El cliente se conecto al servidor : "+cliente.getURL());
     
     Object result = cliente.execute("miServidor.saludo", text);
     
     String res=((String)result).toString();
     System.out.println("Mensaje del servidor :"+res);
     
     int suma = ((Integer) result).intValue();
     System.out.println("La suma es: "+ suma);
     
     Object r = cliente.execute("miServidor.resta", params);

     int resta = ((Integer) r).intValue();
     System.out.println("La resta es: "+ resta);
     

   } catch (Exception exception) {
     System.err.println("JavaClient: " + exception);
   }
  }
}

