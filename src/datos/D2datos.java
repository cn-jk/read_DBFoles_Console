/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dbFile.DBFile;
import dbfHeader.*; //DbfHeader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author k
 */
public class D2datos implements I2datos {
    
    private final File file;
    private final Idbfheader dbfHeader; // private final DbfHeader dbfHeader;
    private final String sizeFile;
    private final List<byte[]> dbfRecordsList;
    /**
     * 
     * KONSTRUKTOR -- CONSTRUCTOR
     * 
     * @param _dbfHeaderList 
     */    
    public D2datos(File _file) throws FileNotFoundException, IOException {
        this.file = _file;
        this.sizeFile = (new DBFile(this.file)).printFileSize();
        byte[] arrayHeader  = (new DBFile(_file)).getHeader();
        List<byte[]> dbfFieldsList = (new DBFile(_file)).getFieldsList();
        this.dbfHeader      = new DbfHeader(arrayHeader, dbfFieldsList);
        this.dbfRecordsList = (new DBFile(_file)).getRecordsList();
    }

    @Override
    public String getFileName() {
        String _result = this.file.getName();
        return _result;
    }
    
    @Override
    public String getHeaderDump() {
        String _result = this.dbfHeader.getHeaderDump();
        return _result;
    }

    @Override
    public String getFileInfo() {
        String _result = this.dbfHeader.toStringInfo(this.sizeFile);
        return _result;
    }

    @Override
    public String printListFields() { // -- 2024-02-04 -- public String get-ListFields() {
        String _result = this.dbfHeader.printListFields();
        return _result;
    }
    
    public void printListFields2() { // -- 2024-02-04 --
        String result = this.dbfHeader.printListFields();
        System.out.println(result);
        return;
    }    
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

    
//  public final String typefiles = ".dbf";
    
//    public D2datos() {
//        this.file = null;
//        this.dbfHeader = null;
//    }


//        } catch (FileNotFoundException fnfex) {
//            Logger.getLogger(D2datos.class.getName()).log(Level.SEVERE, null, fnfex);
//        } catch (IOException ioex) {
//            Logger.getLogger(D2datos.class.getName()).log(Level.SEVERE, null, ioex);

//        DBFile _dbfFile = new DBFile(_file);
//        DbfHeader _dbfHeader = new DbfHeader(_dbfFile.getListRecordsOfHeader());
