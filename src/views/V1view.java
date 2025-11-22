/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import views.mMenus.V1menu_getInput_FileName;
import views.mMenus.V1menu_getInput_StruOrData;
import java.util.List;
import presenters.*;
/**
 *
 * @author k
 */
public class V1view implements I1view {
    
    private boolean exit;
    private List<String> listFiles;
    private String[] arrayFiles;
    private String[] arrayStruData;    
    private I1presenter presenter;
    
    private final int RENEWlist =-1;
    private final int STOPexit  = 0;
    private final int GOTOlist  = 1;
    
    @Override
    public void runView() { //throws IOException {
        /**
         * MAIN LOOP/Cycle for user interface
         */
        MAIN_Loop:
        do {            
            int choice_Nom = -10;
            int choice_StruOrData = -10;

            
            choice_Nom =
            (new V1menu_getInput_FileName(this.arrayFiles)).runMenu();
            
            this.presenter.setChange_choice_file(choice_Nom);            
            switch (choice_Nom) {
                case  STOPexit: break MAIN_Loop; // Cansel/Exit/Basta  2023-11-02
                case RENEWlist: continue MAIN_Loop; // Refresh List of files. 2023-11-02
            }
            
            SLAVE_Loop:
            do {
                String choice_FileName = this.presenter.get_File_choice_file().getName();
                
                choice_StruOrData=
                (new V1menu_getInput_StruOrData(this.arrayStruData, choice_FileName)).runMenu();

                this.presenter.setChange_choice_strudata(choice_StruOrData);
                switch (choice_StruOrData) {
                    case  STOPexit: break MAIN_Loop;    // Cansel/Exit/Basta  2023-11-02
                    case  GOTOlist: continue MAIN_Loop; // Continue cycle/work program. Goto list files 2023-11-02
                }
            } while (true);
        } while(!this.exit);      
    }
    
    @Override
    public void setPresenter(I1presenter _presenter) {
        this.presenter = _presenter;
    }

    @Override
    public void setArrayFiles(String[] _arrayFiles) {
        this.arrayFiles = _arrayFiles;
    }
    
    @Override
    public void setListFiles(List<String> _listFiles) {
        this.listFiles = _listFiles;
    }

    @Override
    public void setArrayStruData(String[] _array_StruData) {
        this.arrayStruData = _array_StruData;
    }
///////////
    /**
     *
     * @param _choice_FileName
     * @param _choice_StruData
     * @throws IOException
     */
    @Override
    public void performAction(int _choice_FileName, int _choice_StruData) { //throws IOException {
        
      //String _st_1 = graphika.GraphikaOfInterface.view_CancelExit;
        String _st_1 = graphika.GraphikaOfInterface.view4CancelExit;
        
        switch (_choice_StruData) {
            case 2: {
                /**
                 * 2023-11-02
                 * real number element in array = this.choice_FileName -= 1;
                 */
                // int kf = this.presenter.get_choice_file();
                // this.presenter.printInfoStructure(kf);
                this.presenter.printInfoStructure();
                break;
                
            }
            case 3: {
                //I2view view = new V2view();
                //models.I2model model = new models.M2model();
                //presenters.I2presenter presenter = new presenters.P2presenter(view, model);
                System.out.println("case: 3 -- Просмотр данных (таблица)");
                break;
            }
            case 1: {
                System.out.println("case: 1 -- Вернуться к списку .dbf-файлов");
                break;
            }
            case 0: {
                System.out.println(_st_1);
                this.exit = true;
                break;
            }
            default:
        }
        return;
    }
//////////////
}
//-mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

//            if (choice_FileName == 0) { break; }
//            else if (choice_FileName == -1) {
//                this.presenter.setChange_choice_file(choice_FileName);
//                break; } // 2023-11-02 Refresh List of files. choice_Refrsh_List_Files
//            else {
//                this.presenter.setChange_choice_file(choice_FileName); }


//            if (choice_StruOrData == 0) break; // Cansel/Exit/Basta  2023-11-02
//            if (choice_StruOrData == 1) continue;            

/**
*
 Список(менћ) фађлов:                                                           
-----------------------------------------------------------------------------   
 Nom.       имя.dbf  dBase  кол.строк  кол.полеђ  длина строки  дата ред-ции    
=======================================*=====================================   
  1         123-(2)  03     13         24         1041          2013-06-03       13 Kbytes 
  2          biblio  83     92         31         3727          1906-12-05      335 Kbytes 
  3    dbase_8b-(1)  8B     10         6          160           2000-06-12        1 Kbytes 
  4            qqqq  03     5          24         148           2013-06-23        1 Kbytes 
  5     Без-имени-1  03     2          2          5             1923-07-07      108 _bytes 
=======================================*=====================================   
  0   выключить программу (exit/cansel/quit) 
-----------------------------------------------------------------------------   
 Введите номер(Nom.) фаилa: 3
*
*/

/**
*
 Просмотр(менћ) фаћла:                                                          
-----------------------------------------------------------------------------   
 Nom. Команда                                                                   
=======================================*=====================================   
  1   Вернуться к списку .dbf-файлов                                                       
  2   Просмотр списока полей                                                               
  3   Просмотр данных (таблица)                                                            
=======================================*=====================================   
  0   выключить программу (exit/cansel/quit) 
-----------------------------------------------------------------------------   
 Введите номер(Nom.) командђ:
*
*/

            /**
             * 
            *  RESERV --- GET any other choices // 2023-11-02
            * 
            */            
            //this.performAction(choice_FileName, choice_StruOrData);            
            //this.performAction(choice_FileName, choice_StruOrData);            
