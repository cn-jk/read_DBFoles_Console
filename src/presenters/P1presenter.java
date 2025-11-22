/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenters;

import models.I2model;
import models.I4model;
import models.I1model;
import datos.D2datos;
import datos.D4datosDATA;
import datos.I4datos;
import datos.I2datos;
import dbFile.DBFile;
import dbfHeader.DbfHeader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import views.*;
//import static start.prograDATA.*;

/**
 *
 * @author k
 */
public class P1presenter implements I1presenter {

    private I1view  view;
    private I1model model;
    private File    choise_file;
    private int     nom_choise_file;
    private int     nom_choise_strudata;
    private int     whatLookingStructOrData;
    
    private final int RENEWlist =-1;
    private final int STOPexit  = 0;
    private final int PRINTstru = 2;
    private final int PRINTdata = 3;
    /**
     * 
     *  Konstruktor -- Constructor
     * 
     * @param _view
     * @param _model
     * @throws IOException 
     */
    public P1presenter(I1view _view, I1model _model) { // throws IOException {
                
        this.model  = _model;
        this.view   = _view;        
        
        //String[] _ar= this.datos.getArrayOfM1model();              
        String[] _ar= this.model.getArrayOfM1model();              
        this.view.setArrayFiles(_ar);

        _ar = graphika.GraphikaOfInterface.item_StruOrData;        
        this.view.setArrayStruData(_ar);
        /**
        *   Subscribe event handler method(s) to [V1view] event(s):
        *   this.view.choice_Filename_Event += printInfoStructure;
        */        
        view.setPresenter(this);        
    }

    /**
     *
     * @param _nom
     */
    @Override
    public void setChange_choice_file(int _nom) { //throws IOException {
        this.nom_choise_file = _nom;
        
        switch (_nom) {
            case  STOPexit: break; // 2023-11-02 Cansel/Exit/Basta 
            case  RENEWlist: break; /** 2023-11-02 Refresh List of files. */  
            default: this.choise_file = this.model.getFiles((_nom - 1));
        }
    }
    
    @Override
    public void setChange_choice_strudata(int _nom) { //throws IOException {
        this.nom_choise_strudata = _nom;

        switch (_nom) {
            case PRINTstru: { this.printInfoStructure(); break; } // Get list of fields  2023-11-14 
            case PRINTdata: { this.printInfoDataRecords(); break; } // Get list of records 2023-11-14 
        }
    }
    
//    @Override
//    public void printInfoData() { //throws IOException {
//    }
    
    /**
    *   2023-11-02
    * 
    *   event handler from V1view
     *  @param _number_Choice_File
     * @throws java.io.IOException
    */
//    @Override
//    public void printInfoStructure(int _number_Choice_File) { //throws IOException {
//    }
    
    @Override
    public void printInfoStructure() { //throws IOException {
        /**
         * 
         * File _file;
         * I2datos, Datos;
         * DbfHeader _dbfHeader
         */
        final File _file        = this.choise_file;        
        final String _file_path = _file.getPath();
        
        final I2view  _2view = new V2view();               
        
        try {
            final I2datos _2datos= new D2datos(_file);
            final I2model _2model= new M2model(_2datos);
            final I2presenter _2presenter = new P2presenter(_2view, _2model);

            _2view.setFileName(  _2model.getFileName());
            _2view.setDump(_2model.getHeaderDump());         // setHeaderDump -- 2024-02-20
            _2view.setInfo(_2model.getFileInfo());        
            _2view.setListFields(_2model.printListFields()); // String st2 = _2model.printFieldsList();
        }
        catch (IOException ex) {
            Logger.getLogger(P1presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        _2view.runView();              
        return;
    }
    
    @Override
    public void printInfoDataRecords() { //throws IOException {
        /**
         * 
         * File _file;
         * I2datos, Datos;
         * DbfHeader _dbfHeader
         */
        final File _file = this.choise_file;        
        final String _file_path = _file.getPath();
        
        final I2view  _4view = new V4view();      
        
        try {
            final I4datos _4datos= new D4datosDATA(_file);
            final I4model _4model= new M4model(_4datos);
            final I4presenter _2presenter = new P4presenter(_4view, _4model); //, _2datos);

            _4view.setFileName(   this.choise_file.getName()); // _4view.setFileName(   _4model.printFileName());
            _4view.setListFields(_4model.printFieldsList());        
            _4view.setInfo(      _4model.printRecords()); // _4view.setRecordsDump(_4model.printRecords());
        }
        catch (IOException ex) {
            Logger.getLogger(P1presenter.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        _4view.runView();
              
        return;
    }

    @Override
    public int get_Nom_choice_file() { //throws IOException {
        return this.nom_choise_file;
    }

    @Override
    public File get_File_choice_file() { //throws IOException {
        return this.choise_file;
    }

    @Override
    public int get_Nom_choice_strudata() { //throws IOException {
        return this.nom_choise_strudata;
    }
       
//    @Override
//    public void get_List_of_records() {
//        System.out.println("// Get list of records 2023-11-14");
//        this.printInfoData();
//        return;
//    }
}

//- mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//  xxx          case PRINTdata: { prograDATA(this.choise_file); break; } // Get list of records 2023-11-14

    //public P1presenter(I1view _view, I1model _model, I1datos _datos) throws IOException {

    //DbfFile _dbfFile = new DBFile(_file);
        //DbfHeader _dbfHeader = new DbfHeader(_dbfFile.getListRecordsOfHeader()); 