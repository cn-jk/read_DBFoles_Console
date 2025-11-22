/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenters;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author k
 */
public interface I1presenter {
    public final String TYPEFILE = ".dbf";
    
//    public abstract void printInfoData();
//    public abstract void get_List_of_records();
    
    public abstract void printInfoStructure();
    public abstract void printInfoDataRecords();    
    
//    public abstract void printInfoStructure(int numberChoiceFile); // throws IOException ;
    
    public abstract void setChange_choice_file(int _nom);
    public abstract void setChange_choice_strudata(int _nom);
    
    public abstract int  get_Nom_choice_file();
    public abstract File get_File_choice_file();
    public abstract int  get_Nom_choice_strudata();
}

//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//    public abstract void get_List_of_fields();
//    public abstract void performAction();