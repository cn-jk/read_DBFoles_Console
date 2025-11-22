/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import datos.I4datos;

/**
 *
 * @author k
 */
public interface I2model {
  //public abstract void setDatos(I2datos args);
    public abstract String getHeaderDump();
    public abstract String getFileInfo();
    public abstract String printListFields();
    public abstract String getFileName();
}
