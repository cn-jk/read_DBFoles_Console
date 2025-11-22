/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import datos.I4datos;
/**
 *
 * @author studer
 */
public class M4model implements I4model {

    private String  col2_NameField;
    private String  col3_TypeField;
    private int     col4_SizeField;
    private int     col5_SizeDecimalField;
    private final I4datos datos;
    /**
     *
     * @param _datos
     */    
    public M4model(I4datos _datos) {
        this.datos = _datos;
    }
    
    @Override
    public String printFileName() {
        String _result = this.datos.getFileName();
        return _result;
    }    

    @Override
    public String printFieldsList() {
        String _result = this.datos.printFieldsList(); // this.datos.getFieldsList();        
        return _result;
    }
    
    @Override
    public String printRecords() {

        String _result = this.datos.printRecordsList();
        return _result;        
    }
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
//    @Override
//    public String getRecordsDump() {
//        String _result = this.datos.getRecordsDump();
//        return _result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    @Override
//    public String getHeaderDump() {
//        String _result = this.datos.getHeaderDump();
//        return _result;
//    }
