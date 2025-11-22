/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import presenters.I2presenter;
import presenters.I4presenter;

/**
 *
 * @author k
 */
public interface I2view {

    public abstract void runView(); // public abstract void runMenu();
    public abstract int  getChoice_menu();
    
    public abstract void setPresenter(Object _presenter); // public abstract void setPresenter(I2presenter _presenter);
    public abstract void setFileName(String _args);       // public abstract void printFileName(String _args);
    
    public abstract void setDump(String _args); // setHeaderDump or setRecordsDump // public abstract void setHeaderDump(String _args);
    
    public abstract void setInfo(String _args); // public abstract void printInfo(String _args); //    public abstract void printFileInfo(String _args);
    
    public abstract void setListFields(String _args);
    public abstract void setArrayMenu(String[] _args);
}
