package codigo;
/**
 *
 * @author angel
 */
public class Cola 
{
    private Object[] cola;
    private int frente;
    private int fin;
    
    public Cola(int tamanio)
    {
        cola = new Object[tamanio];
        frente = fin = -1;
    }
    
    public boolean isEmpty()
    {
        return frente == fin;
    }
    
    public boolean isFull()
    {
        return fin == cola.length-1;
    }
    
    
    public void insert(Object elemento)
    {
        if(isFull())
            System.out.println("La cola esta llena, elimine datos!");
        else
            cola[++fin] = elemento;
    }
    
    public Object remove()
    {
        if(isEmpty())
        {
            System.out.println("La cola esta vacia, inserte datos!");
            return "Cola vacia";
        }
        else
            return cola[++frente];
    }
    
    
    public void print()
    {
        if(isEmpty())
            System.out.println("La cola esta vacia!");
        else if(frente == -1)
        {
            for(int i = 0; i <= fin; i++)
            {
                System.out.println(cola[i]);
            }
        }
        else
        {
            for(int j = frente; j <= fin; j++)
            {
                System.out.println(cola[j]);
            }
        }
    }
}












