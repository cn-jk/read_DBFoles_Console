/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import datos.I1datos;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author k
 */
public interface I1model {
  //public abstract void     setDatos(I1datos _datos);
    public abstract String[] getArrayOfM1model(); // throws IOException;    
    public abstract File     getFiles(int _number_Choice_File); // throws IOException; 
}
