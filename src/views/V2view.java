/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import presenters.I2presenter;
/**
 *
 * @author k
 */
public class V2view implements I2view {

    private String stringHeaderDump; //private
    private String stringListFields;
    private String stringFileInfo;
    private String printFileName;
    private I2presenter presenter;
    private String[] arrayMenu;
    private int choice_menu; 
    
    @Override
    public void runView() { //PrintInfo() {
            System.out.println("1>" + this.stringHeaderDump);
            System.out.println("2>" + this.stringFileInfo);
            System.out.println("4>" + this.stringListFields); //.substring(0, 78));
    } 

    @Override
    public int getChoice_menu() {
            return this.choice_menu;
    }
        
    @Override
    public void setPresenter(Object _presenter) {
            this.presenter = (I2presenter)_presenter;
    }

    @Override
    public void setDump(String _setHeaderDump) {
            this.stringHeaderDump = _setHeaderDump;
    }
    
    @Override
    public void setFileName(String _args) {
              this.printFileName = _args;
    }
    
    @Override
    public void setInfo(String _FileInfo) { //    public void printFileInfo(String _args) {
              this.stringFileInfo = _FileInfo;
    }
    
    @Override
    public void setListFields(String _args) {
              this.stringListFields = _args;
    }
    
    @Override
    public void setArrayMenu(String[] _args) {
              this.arrayMenu = _args;
    }
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//    private String stringHeaderDump;
//    private String stringListFields;
//    private String stringFileInfo;
//    private String printFileName;

//    private final DbfFile file;
//    private final DbfHeader header;
//    private final String typefiles = ".dbf";
//
//    public V2view(DbfFile _file, DbfHeader _header) {
//        this.file = _file;
//        this.header = _header;
//    }


//    public V2view(DbfFile _file, DbfHeader _header) {
//        this.file = _file;
//        this.header = _header;
//    }

//    private void getPrintInfo() {
//            System.out.println("1>" + this.stringHeaderDump);
//            System.out.println("2>" + this.stringFileInfo);
//            System.out.println("4>" + this.stringListFields);
//    }
