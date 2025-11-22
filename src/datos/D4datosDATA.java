/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dbField.Dbfield;
import dbField.Idbfield;
import dbfData.DbfData;
import dbFile.DBFile;
import dbfHeader.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * 
 * @author k
 */
public class D4datosDATA implements I4datos {
    
    private final List<byte[]>   RecordsList;
    private final Idbfheader     Header;
    private final String         FileName; //_result = this.file.getName();    
//    private final Idbfield[]     ARRAYfields;
//    private       List<Idbfield> LISTfields;
    
    public D4datosDATA(File _file) throws IOException {

            this.RecordsList =         (new dbFile.DBFile(_file)).getRecordsList();
//            this.RecordsList =         (new dbFile.DBFile(_file)).getListRecordsOfData();
            byte[] _Header =           (new dbFile.DBFile(_file)).getHeader();
            List<byte[]> _FieldsList = (new dbFile.DBFile(_file)).getFieldsList();

            this.Header = new DbfHeader(_Header, _FieldsList); // -- ).getFieldsArray();
            this.FileName = _file.getName();
    }

    @Override
    public dbfData.DbfDataRecord getRecord(int i) {
            final byte[] _Record = this.RecordsList.get(i);
            final Idbfield[] _Fields_array = this.Header.getFieldsArray();

            dbfData.DbfDataRecord _result = new dbfData.DbfDataRecord(_Record, this.Header);
            String strRecord = _result.toString();
            return _result;
    }

    @Override
    public List<Idbfield> getFieldsList() {
        
            List<Idbfield> _result = this.Header.getFieldsList();        
            return _result;
    }
    
    @Override
    public String printFieldsList() {
        
            StringBuilder _sb = new StringBuilder("");
            
            String _st = "",  _1format = "";
            int    _sizePrint, _nom_of_field = 1;
            final String _END_OF_LINE = "\n";
            final String _LINE = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
            final String _LINE2= "                                       ";
            
            // abcde<<<< fghjkl<<< nmopyugghj<<<
            for (Idbfield _field : this.Header.getFieldsList()) {
                    _sizePrint = _field.getSizeField();
                    _sizePrint = (_sizePrint < 10) ? 10 : _sizePrint; 
                    _sizePrint = (_sizePrint > 20) ? 20 : _sizePrint;
                    _1format = "%-" + _sizePrint + "s"; // _nom_of_field +
                    _st =   _field.getNameField() + _LINE;
                    _st =   (_st + _LINE).substring(0, (_sizePrint)) + "|";
                    _st =   String.format(_1format, _st);
                    _sb.append(_st);
            }
                    // _sb.insert(0, _END_OF_LINE);
                    _sb.append (_END_OF_LINE);

            for (Idbfield _field : this.Header.getFieldsList()) {
                    _sizePrint = _field.getSizeField();
                    _sizePrint = (_sizePrint < 10) ? 10 : _sizePrint; 
                    _sizePrint = (_sizePrint > 20) ? 20 : _sizePrint;
                    _1format = "%-" + _sizePrint + "s";
                    _st =   (_nom_of_field++) + ""; // _nom_of_field += 1;
                    _st =   (_st + _LINE2).substring(0, (_sizePrint)) + "|";
                    _st =   String.format(_1format, _st);
                    _sb.append(_st);
            }
            
//            for (Idbfield _field : this.Header.getFieldsList()) {
//                    _sizePrint = _field.getSizeField();
//                    _1format = "(" +  ")" + "%-" + _sizePrint + "s"; // _nom_of_field +
//                    _st =   _field.getNameField();
//                    _st =   String.format(_1format, _st);
//                    _sb.append(_st);
//                    _nom_of_field += 1;
//            }
                    _sb.append(_END_OF_LINE);
            
            return  _sb.toString();
    }

    @Override
    public String printRecordsList() {
        
            final StringBuilder _sb  = new StringBuilder("");
            final String _END_OF_LINE= "\n";            
            
            dbfData.DbfDataRecord _rc;
            
            String _st; // = "";            

            for (byte[] _bt : this.RecordsList) {
                
                    _rc = new dbfData.DbfDataRecord(_bt, this.Header);
                    
                    _st = _rc.printRecord2(); // _rc.printRecord(); //-<<<<<<<<<<<<<<<<<<<
                    
                    _sb.append(_st);
                    
                    _sb.append (_END_OF_LINE);
            }
           return _sb.toString();
    }
    
    @Override
    public String getFileName() {
            return this.FileName;
    }
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
    
//    public D4datosDATA(List<byte[]> _records, Dbfield[] _fields) {
//            this.LISTrecords = _records;
//            this.ARRAYfields = _fields;
//    }

//    @Override
//    public String getFileName() {
//        String _result = this.file.getName();
//        return _result;
//    }
    
//    @Override
//    public String getHeaderDump() {
//        String _result = dbfHeader.getHeaderDump();
//        return _result;
//    }

//        } catch (FileNotFoundException fnfex) {
//            Logger.getLogger(D2datos.class.getName()).log(Level.SEVERE, null, fnfex);
//        } catch (IOException ioex) {
//            Logger.getLogger(D2datos.class.getName()).log(Level.SEVERE, null, ioex);

//        DBFile _dbfFile = new DBFile(_file);
//        DbfHeader _dbfHeader = new DbfHeader(_dbfFile.getListRecordsOfHeader());
