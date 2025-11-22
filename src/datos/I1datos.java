/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import models.I1model;

/**
 *
 * @author k
 */
public interface I1datos {

    /**
     *     FOR  .DBF  DATA  FILES !!
     */
    public final String DBF_TYPEFILE = ".dbf";
  //private abstract File[]       setFiles(String nameDir);
    public abstract File[]        getFiles();
    public abstract File          getFiles(int i);
    public abstract String[]      getArrayOfM1model(); // throws FileNotFoundException, IOException;
    public abstract List<String>  getListOfM1model();  //  throws FileNotFoundException, IOException;
    public abstract List<I1model> getListOfM1mode2();  //  throws FileNotFoundException, IOException;
}
                                //getArrayOfM1model()