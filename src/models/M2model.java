/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import datos.I2datos;
/**
 *
 * @author k
 */
public class M2model implements I2model {
    
    private String  col2_NameField;
    private String  col3_TypeField;
    private int     col4_SizeField;
    private int     col5_SizeDecimalField;
    private final I2datos datos;
    /**
     *
     * @param _datos
     */
    public M2model(I2datos _datos) {
        this.datos = _datos;
    }
    
    @Override
    public String getHeaderDump() {
        String _result = this.datos.getHeaderDump();
        return _result;
    }

    @Override
    public String printListFields() { // -- 2024-02-04 -- get-ListFields()
        String _result = this.datos.printListFields();
        return _result;
    }

    @Override
    public String getFileInfo() {
        String _result = this.datos.getFileInfo();
        return _result;
    }

    @Override
    public String getFileName() {
        String _result = this.datos.getFileName();
        return _result;
    }
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
    
//    @Override
//    public void setDatos(I2datos _datos) {
//        this.datos = _datos;
//    }