
package tp6.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

// buscarTeléfono() que en base a un apellido nos devuelve una lista con los nros de 
//teléfono asociados a dicho apellido.
public class Directorio {
    private HashMap<String,Cliente> registro=new HashMap<String,Cliente>();
    
    public Cliente buscarCliente(String numTelefono){
             
        return registro.get(numTelefono);
    }
public ArrayList<Cliente> buscarClientes(String ciudad){
        
        ArrayList<Cliente>buscar= new ArrayList();
        Set<String> claves=registro.keySet();
       Iterator<String> it = claves.iterator();
       while(it.hasNext()){
           String claveActual=it.next();
           Cliente clienteActual=registro.get(claveActual);
           
           if(clienteActual.getCiudad().equals(ciudad)){
               buscar.add(clienteActual);
           }         
       }
        return buscar;
    }



//AgregarCliente() que permite registrar un nuevo cliente con su respectivo nro de 
//teléfono. Siendo el nro del teléfono la clave del mismo.
    public boolean agregarCliente(String telefono, Cliente c) {
        boolean agregado = false;
        if (!registro.containsKey(telefono)) {
            registro.put(telefono, c);
            agregado = true;
        }
        return agregado;
    }   
    
    public ArrayList<String> buscarTelefono(String apellido){
        ArrayList <String> num= new ArrayList<String>();
        for (Map.Entry<String, Cliente> entry : registro.entrySet()) {
            if(registro.containsValue(apellido)){
                num.add(entry.getKey());
            }
        }
        //hola
//        Iterator <String> i= num.iterator();
//        while(i.hasNext()){
//            System.out.println(i.next());
//        }
        return num;
    }
    
    public void borrarCliente(String telefono){
        Cliente aux = registro.remove(telefono);
        if (aux==null) {
            JOptionPane.showMessageDialog(null,"Dato no Encontrado");
        } else {
            JOptionPane.showMessageDialog(null,"Cliente eliminado");
        }
    }
}
