/**
2024-02-04
programma:
   - prosmatrivaet papku/directory: NAMEDIR  = "Z:\\dbf-files-examples";
   - vybiraet faily/files typa: ".dbf";
   - vyvodit pronumerovannyi spisok etih failov kak Menu
   - pol'zovatel'/korystuvach/user vvodit nomer faila i
     poluchaet informaciju ob etom faile spisok literatury:     
     DBASE FILE FORMAT (WITH CODING DETAILS) DBF AND DBT/FPT FILE STRUCTURE AUG-6-2018; 
 */
package start;

import models.I1model;
import datos.D1datos;
import datos.I1datos;
//import dbfFile.DbfFile;
import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import models.*;
import views.*;
import presenters.*;
/**
 *
 * @author k
 */
public class Main_start {

    private static final String
            OSdefault = "linux";

    private static final String
            OScurrent =
            System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    
    private static final String
            DIRlinux = "/home/user4/Documents/dbf-files-examples/files-dbf";
    
    private static final String
            DIRwindows = "Z:\\dbf-files-examples";
    
    private static String
            DIRcurrent = (OScurrent.contains(OSdefault)) ? DIRlinux : DIRwindows;

    public  static final Scanner
            SCAN       = new Scanner(System.in);
    
    //private static final String  typefiles=".dbf";
    //private static final String  typefiles=".DBF";

    public static void main(String[] args) throws IOException {
        
            System.out.println("current OS: " + OScurrent);        
        
            var dialogChooser = new javax.swing.JFileChooser();
            var whatTheChoosed = dialogChooser.showOpenDialog(null);
            if (whatTheChoosed == javax.swing.JFileChooser.APPROVE_OPTION) {
                DIRcurrent = dialogChooser.getSelectedFile().toString();
                System.out.println("YES! current file: " + DIRcurrent);
            }
            else {
                System.out.println("STOP! Nado vybrat_ fail !!");
            }
            
            DIRcurrent = dialogChooser.getCurrentDirectory().toString();
            //(args.length == 0) ? DIRcurrent :(args[0].trim().isEmpty() == true) ? DIRcurrent : args[0];
            
            System.out.println("current Directory: " + DIRcurrent);        
            

            I1datos     datos    = new D1datos(DIRcurrent);
            I1view      view     = new V1view();
            I1model     model    = new M1model(datos);            
            
            I1presenter presenter= new P1presenter(view, model);
            /**
             * 
            //  It is 1-rst_run/General_start
            //  Application.Run((Form)view);
            */
            view.runView();
            Main_start.SCAN.close();
    }
}

//    public V2view(DbfFile _dbfFile) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public static void main(String[] args) {
//
//        File[] files;
//        String nameDir = "Z:\\dbf-files-examples";
//
//        files = ReadDbfFiles.setFiles(nameDir);
//        /*
//            static_PrintTitle();
//         */
//        gGraphika.GraphikaOfInterface.printHeaderTable_2();
//        try {
//            /*
//            print menu -- List of files(.dbf) to console --------- inform to console > > >
//             */
//            static_4PrintToConsoleInfo(files);
//        } catch (Exception e) {
//            System.err.println("E104 >>> " + e.getMessage());
//        }
//        /*
//            static_PrintFooter();
//         */
//        gGraphika.GraphikaOfInterface.printFooterTable();
//    }