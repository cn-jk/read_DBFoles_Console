/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import datos.I1datos;
import java.io.File;
import java.util.List;
import java.util.Map;
//import java.io.IOException;
/**
 *
 * @author k
 */
public class M1model implements I1model {
    /**
    *
    * Fields:
    / private int  col1_ID = -1; // 2023-10-30 --- -----
    */
    private final I1datos datos;
    private String  col2_FileName;
    private String  col3_dBaseType;
    private int     col4_TotalRowInDBF;
    private int     col5_TotalColumnInDBF;
    private int     col6_LengthOfRecordDBF;
    private String  col7_DateOfLastEdit;
    private String  col8_FileSize;  
    /**
     * 
     * KONSTRUKTOR -- CONSTRUCTOR
     * @param _datos 
     */
    public M1model(I1datos _datos) {
        this.datos = _datos;
    }   
    /**
     * 
     * // 2023-10-30 --- ---------------------- -------
     * 
     * Konstruktor == Constructor
     * @param _dbfFile
     * @throws IOException 
     */    
    public M1model(dbFile.DBFile _dbFile) {
        this.datos = null;
        
        final dbfHeader.DbfHeader
        _header = new dbfHeader.DbfHeader(_dbFile.getHeader(), _dbFile.getFieldsList());
        
        this.col2_FileName         = _dbFile.getFile().getName().trim().split(".dbf")[0];
        this.col3_dBaseType        = _header.getdBaseVersion();
        this.col4_TotalRowInDBF    = _header.getCountOfRecords();
        this.col5_TotalColumnInDBF = _header.getCountOfFields();
        this.col6_LengthOfRecordDBF= _header.getRecordSize();
        this.col7_DateOfLastEdit   = _header.getdBaseDate();
        this.col8_FileSize         = _dbFile.printFileSize();
        
      //java.lang.reflect.Field[] fd = this.getClass().getFields();
      //int totalOfFields = this.getClass().getFields().length;
    }
    
    public File getFiles(int _number_choice_File) { //throws IOException {
        File _result = this.datos.getFiles(_number_choice_File);
        return _result;
    }
    /**
     *
     * @return
     * @throws IOException
     */
    @Override
    public String[] getArrayOfM1model() { //throws IOException {
        String[] _result = this.datos.getArrayOfM1model(); //.getArrayOfM1model();
        return _result;
    }
    /**
     * // 2023-10-30 --- 
     * @param _ID
     * @return 
     */
    public String toPrint(int _ID) {
        String itemFormat = "%4d == %86s";
 
        return  String.format(itemFormat
                ,_ID
                ,this.toString()
        );
    }

    @Override
    public String toString() {
        String i1temFormat = "%14s";
        String i2temFormat = "  %-5s  %-9d  %-9d  %-12d  %-13s  %-12s";
 
        i1temFormat = String.format(i1temFormat,this.col2_FileName);
        i2temFormat = String.format(i2temFormat
                ,this.col3_dBaseType
                ,this.col4_TotalRowInDBF
                ,this.col5_TotalColumnInDBF
                ,this.col6_LengthOfRecordDBF
                ,this.col7_DateOfLastEdit
                ,this.col8_FileSize
        );
        if (14 < i1temFormat.length()) {
            int _different = i1temFormat.length() - 14;
            i2temFormat = i2temFormat.substring(_different);
        }
        return i1temFormat + i2temFormat;
    }

    //@Override
    public String toString2() {
        //String itemFormat = "%3d  %14s  %-5s  %-9d  %-9d  %-12d  %-13s  %-12s";
        String itemFormat = "  %14s  %-5s  %-9d  %-9d  %-12d  %-13s  %-12s";
 
        return  String.format(itemFormat
                ,this.col2_FileName
                ,((this.col2_FileName.length() > 14) ? "" : this.col3_dBaseType)
                //,this.col3_dBaseType
                ,this.col4_TotalRowInDBF
                ,this.col5_TotalColumnInDBF
                ,this.col6_LengthOfRecordDBF
                ,this.col7_DateOfLastEdit
                ,this.col8_FileSize
        );
    }

    public String[] toArray() {
        int totalOfFields = this.getClass().getFields().length;
        String[] result = new String[totalOfFields];
        result[0] = this.col2_FileName;
        result[1] = this.col3_dBaseType;
        result[2] = this.col4_TotalRowInDBF+ "";
        result[3] = this.col5_TotalColumnInDBF+"";
        result[4] = this.col6_LengthOfRecordDBF+"";
        result[5] = this.col7_DateOfLastEdit;
        result[6] = this.col8_FileSize;
        return result;
    }

    public List toList() {
        java.util.List<String> result = new java.util.ArrayList<>();
      //result.add(this.col1_ID + "");
        result.add(this.col2_FileName);
        result.add(this.col3_dBaseType);
        result.add(this.col4_TotalRowInDBF+ "");
        result.add(this.col5_TotalColumnInDBF+"");
        result.add(this.col6_LengthOfRecordDBF+"");
        result.add(this.col7_DateOfLastEdit);
        result.add(this.col8_FileSize);
        return result;
    }
    
    public Map toHashMap() {
        java.util.Map<String, String> result = new java.util.HashMap<>();
      //result.put("col_ID",                this.col1_ID + ""          );
        result.put("col_FileName",          this.col2_FileName         );
        result.put("col_dBaseType",         this.col3_dBaseType        );
        result.put("col_TotalRowInDBF",     this.col4_TotalRowInDBF+ "");
        result.put("col_TotalColumnInDBF",  this.col5_TotalColumnInDBF+"");
        result.put("col_LengthOfRecordDBf", this.col6_LengthOfRecordDBF+"");
        result.put("col_DateOfLastEdit",    this.col7_DateOfLastEdit   );
        result.put("col_FileSize",          this.col8_FileSize         );
        return result;
    }

    public String toStringX2() { // xxx DRAFT xxxxxxxxxxxxxxxxxxxxxx

        StringBuilder _result = new StringBuilder();
        String _stringFormat;
        String _string;     
        
        _stringFormat = "%14s";
        _string = String.format(_stringFormat, this.col2_FileName);        
        _result.append(_string);
        
        _stringFormat = "%3s";
        _string = String.format(_stringFormat, this.col3_dBaseType);        
        _result.append(_string);
        
        return _result.toString();
    }
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//    @Override
//    public void setDatos(I1datos _datos) {
//        this.datos = _datos;
//    }

    /**
     * 
     * // 2023-10-30 --- ---------------------- -------
     * 
     * Konstruktor == Constructor
     * @param _id
     * @param _dbfFile
     * @throws IOException 
     */    

//    public M1model(int _id, dbfFile.DBFile _dbfFile) { // throws IOException {
//        
//        java.lang.reflect.Field[] fd = this.getClass().getFields();
//        int totalOfFields = this.getClass().getFields().length;
//
//        dbfHeader.DbfHeader _header =
//        new dbfHeader.DbfHeader(_dbfFile.getListRecordsOfHeader());
//        
//        this.col2_FileName         = _dbfFile.getFile().getName().trim().split(".dbf")[0];
//        this.col3_dBaseType        = _header.getdBaseVersion();
//        this.col4_TotalRowInDBF    = _header.getCountRecordsOfData();
//        this.col5_TotalColumnInDBF = _header.getCountFields();
//        this.col6_LengthOfRecordDBF= _header.getLengthOfDataRecord();
//        this.col7_DateOfLastEdit   = _header.getdBaseDate();
//        this.col8_FileSize         = _dbfFile.printFileSize();        
//    }
