/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author orann
 */
public class Singleton{
    private static Query q = null;
    
    private Singleton()
    {
        if(q == null)
        {
            q = new Query();
        }
    }
    
    public static Query getRequetes()
    {
        if(q == null)
        {
            new Singleton();
        }
        return q;
    }
}
