/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dbFile.DBFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.M1model;
import models.I1model;
/**
 *
 * @author k
 */
public class D1datos implements I1datos {
    /**
     * nameDir  --------->  "Z:\\dbf-files-examples"
    */
    final private String nameDir;
    final private String typeFiles = DBF_TYPEFILE;
    final private File[] files;
    /**
     * 
     * KONSTRUKTOR -- Constructor
     * @param _nameDir
     * @param _typeFiles 
     */
    public D1datos(String _nameDir, String _typeFiles) {
        // this.D1datos(String _nameDir);
        this.nameDir = _nameDir;
        //this.typeFiles = _typeFiles;
        this.files = this.setFiles(this.nameDir);        
    }
    
    public D1datos(String _nameDir) {
        this.nameDir = _nameDir;
        //typeFiles = DBF_TYPEFILE;
        this.files = this.setFiles(this.nameDir);        
    }
    
//    public D1datos() {
//        this.nameDir = "Z:\\dbf-files-examples";;
//        this.files = this.setFiles(this.nameDir);        
//    }
    
    @Override
    public File[] getFiles() {
        return this.files;
    }
    /**
     * 
     * @param i
     * @return 
     */    
    @Override
    public File getFiles(int i) {
        return this.files[i];
    }
    /**
     *
     * @param _nameDir
     * @return
     */
    private File[] setFiles(String _nameDir) {        
    //public final File[] setFiles(String _nameDir) {        
        File _fileChoose;
        File[] _filesArray = null;
        
        try {            
            _fileChoose = new File(this.nameDir);
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    // We want to find only .dbf, .DBF, .Dbf  files
                    return name.toLowerCase().endsWith(".dbf");
                    //return name.toLowerCase().endsWith("");
                }
            };
            /**
             *  Note that this time we are using a File class as an array, // instead of String
                File[] files = f.listFiles(filter);
            */
            _filesArray = _fileChoose.listFiles(filter);
        } catch (Exception e) {
            System.err.println("D302 >>> " + e.getMessage());
        }        
        return _filesArray;
    }
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public List<String> getListOfM1model() { //throws FileNotFoundException, IOException {

        dbFile.DBFile _dbFile;        
        M1model _m1m;
        List<String> _list = new ArrayList<>();
        
        //try {
            
            for (File _file : this.files) {
                _dbFile = new DBFile(_file);
                _m1m =     new M1model(_dbFile); // new M1model(this);
                _list.add(_m1m.toString());
                continue;
            }
            
        //} catch (FileNotFoundException ex) {
        //    Logger.getLogger(D1datos.class.getName()).log(Level.SEVERE, null, ex);
        //}
        return _list;
    }
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public List<I1model> getListOfM1mode2() { // throws FileNotFoundException, IOException {

        dbFile.DBFile _dbfFile;        
        M1model _mn2;
        List<I1model> _list = new ArrayList<>();
        
//        try {
            for (File _file : this.files) {
                _dbfFile = new DBFile(_file);
                _mn2     = new M1model(this); // new M1model(_dbFile);
                _list.add(_mn2);
            }
//        } catch (FileNotFoundException fnfex) {
//            Logger.getLogger(D1datos.class.getName()).log(Level.SEVERE, null, fnfex);
//        }
        return _list;
    }
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public String[] getArrayOfM1model() { // throws FileNotFoundException, IOException {

        List<String> _list; // = null;
        String[] _array; // - null;
        _list = this.getListOfM1model();
        _array = _list.toArray(new String[0]);
        return _array;
    }
}

// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
//    public D1datos() {
//            // public File[] setFiles(String _nameDir) {
//        
//        File f;        
//        try {            
//            f = new File(this.nameDir);
//            FilenameFilter filter = new FilenameFilter() {
//                @Override
//                public boolean accept(File f, String name) {
//                    // We want to find only .dbf files
//                    return name.endsWith(".dbf");
//                }
//            };
//            /**
//             *  Note that this time we are using a File class as an array, // instead of String
//                File[] files = f.listFiles(filter);
//            */
//            files = f.listFiles(filter);
//        } catch (Exception e) {
//            System.err.println("E102 >>> " + e.getMessage());
//        }        
//        return files;
//    }