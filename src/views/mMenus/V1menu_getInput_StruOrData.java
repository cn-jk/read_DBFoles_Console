/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mMenus;

import java.util.Scanner;

/**
 *
 * @author k
 */
public class V1menu_getInput_StruOrData implements I1menu {
    
    private final String[] ARRAYitems;
    private final String   TITLEmenu;
    private final String   stringFormatTitle = "%s %s: ";

    public V1menu_getInput_StruOrData(String[] _arrayItem, String _fileName) {
        this.ARRAYitems = _arrayItem;
        this.TITLEmenu =
        String.format(this.stringFormatTitle, _fileName, graphika.GraphikaOfInterface.view_StruDataOfFile);
    }
    /**
     * 
    * static_PrintTitle();
    */
    public void printMenu_Head() {
        //graphika.GraphikaOfInterface.V1printHeaderTable();        
        //graphika.GraphikaOfInterface.View_printHead_menu();        
        graphika.GraphikaOfInterface.View_printHead_menu(this.TITLEmenu);        
    }
    
    public void printMenu_Body() {        
        String itemFormat = "%3d%-88s\n";
        for (int _Nom = 1, i = 0; i < this.ARRAYitems.length; i++, _Nom++) {
            System.out.printf(itemFormat, _Nom, this.ARRAYitems[i]);
        }        
    }
    
    @Override
    public void printMenu_Footer() {
        graphika.GraphikaOfInterface.View_printFooter_menu();
    }
    
    @Override
    public int getInput() {
        
        final int _min = 0;
        final int _max = this.ARRAYitems.length;
        final String _st_1 = graphika.GraphikaOfInterface.view_EnterNom;
        final String _st_2 = graphika.GraphikaOfInterface.V1vie2;
        
        int _choice = -1;
        String _input = "";        
        /**
         * 
        2023-11-02 -- try (Scanner _scan = new Scanner(System.in)) {
        */
        do {
            try  {
                System.out.print(_st_1);

                _input = start.Main_start.SCAN.nextLine();
                _choice = Integer.parseInt(_input);

                if ((_choice < _min) || (_choice > _max)) {
                    System.out.println(_choice + _st_2);
                    _input = "";
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println(_input + _st_2);
            }
        } while ((_choice < _min) || (_choice > _max));
        //}
        return _choice;
    }
    
    @Override
    public int runMenu() {

        this.printMenu_Head();
        this.printMenu_Body();
        this.printMenu_Footer();
        
//        final int _min = 0;
//        final int _max = this.arrayItems.length;
//        final String _st_1 = graphika.GraphikaOfInterface.view_EnterNom;
//        final String _st_2 = graphika.GraphikaOfInterface.V1vie2;
//        
//        int _choice = -1;
//        String _input = "";        
//        /**
//         * 
//        2023-11-02 -- try (Scanner _scan = new Scanner(System.in)) {
//        */
//        do {
//            try  {
//                System.out.print(_st_1);
//
//                _input = program.program.SCAN.nextLine();
//                _choice = Integer.parseInt(_input);
//
//                if ((_choice < _min) || (_choice > _max)) {
//                    System.out.println(_choice + _st_2);
//                    _input = "";
//                }
//            }
//            catch (NumberFormatException nfe) {
//                System.out.println(_input + _st_2);
//            }
//        } while ((_choice < _min) || (_choice > _max));
//        //}
        return this.getInput();
    }       
}
