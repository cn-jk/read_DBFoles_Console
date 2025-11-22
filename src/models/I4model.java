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
public interface I4model {
//    public abstract void setDatos(I2datos args);
//    public abstract String getRecordsDump();
    public abstract String printFileName();
    public abstract String printFieldsList();
    public abstract String printRecords();
//    public abstract String printRecords(int printFirstRecords);
}
