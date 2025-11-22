/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mMenus;

//import java.io.Console;
/**
 *
 * @author k
 */
public class V1menu_getInput_FileName implements I1menu {
          
    private final String[] arrayItems;

    public V1menu_getInput_FileName(String[] _arrayItem) {
        this.arrayItems = _arrayItem;
    }
    /**
    * static_PrintTitle();
    */
    @Override
    public void printMenu_Head() {
        //graphika.GraphikaOfInterface.V1printHeaderTable();
        String _title = graphika.GraphikaOfInterface.view_ListMenuOfFiles;
        graphika.GraphikaOfInterface.V1printHeaderTable(_title);        
    }
    
    @Override
    public void printMenu_Body() {        
        String itemFormat = "%3d%88s\n";
        for (int _Nom = 1, i = 0; i < this.arrayItems.length; i++, _Nom++) {
            System.out.printf(itemFormat, _Nom, this.arrayItems[i]);
        }        
    }
    
    public void printMenu_Footer() {
        graphika.GraphikaOfInterface.View_printFooter_menu();
    }
    
    @Override
    public int getInput() {
        
        final    int _min = 0;
        final    int _max = this.arrayItems.length;
        final String _st_1= graphika.GraphikaOfInterface.V1view;
        final String _st_2= graphika.GraphikaOfInterface.V1vie2;
        
        int _choice = -1;
        String _input = "";
        
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

            return _choice;
    }

    @Override
    public int runMenu() {
        
        this.printMenu_Head();
        this.printMenu_Body();
        this.printMenu_Footer();
        
        return
        this.getInput();
    }
    
//    private int getInput_console_readLine() {
//        
//        final    int _min = 0;
//        final    int _max = this.arrayItems.length;
//        final String _st_1= graphika.GraphikaOfInterface.V1view;
//        final String _st_2= graphika.GraphikaOfInterface.V1vie2;
//        
//        int _choice = -1;
//        String _input = "";
//        
//        Console _cons = System.console();
//        System.out.println(_cons.readLine());        
//                    System.out.print(_st_1);
//        
//            do {
//                try  {
//                    System.out.print(_st_1);
//                    
//                    _input = _cons.readLine();
//                    _choice = Integer.parseInt(_input);
//                    
//                    if ((_choice < _min) || (_choice > _max)) {
//                        System.out.println(_choice + _st_2);
//                        _input = "";
//                    }
//                }
//                catch (NumberFormatException nfe) {
//                    System.out.println(_input + _st_2);
//                }
//            } while ((_choice < _min) || (_choice > _max));
//
//            return _choice;
//    }   
}
