/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.persistencia;

/**
 *
 * @author mouri
 */
public class DuplicateKeyException extends Exception 
{

    public DuplicateKeyException() 
    {
        super("A chave primaria não pode ser duplicada");
    }
    
}
