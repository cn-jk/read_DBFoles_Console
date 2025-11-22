/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dbField.*;
import java.util.List;

/**
 *
 * @author k
 */
public interface I4datos {
    
    public final String IDATAdatos = "I4datos";
    public final String DBF_TYPEFILE = ".dbf";

    public abstract String                getFileName();    
    public abstract List<Idbfield>        getFieldsList();
    public abstract dbfData.DbfDataRecord getRecord(int i);
    public abstract String                printFieldsList();
    public abstract String                printRecordsList();

}
