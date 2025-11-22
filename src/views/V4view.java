/**
 *  Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import presenters.*; //I4presenter;

/**
 *
 * @author studer
 */
public class V4view implements I2view {
    
    private String RecordsDump_string; //private
    private String Fields_string;
    private String Records_string;
    private String FileName_string;
    private I4presenter presenter;
    private String[] arrayMenu;
    private int choice_menu;

    private void getPrintInfo() {
            System.out.println("1>" + this.RecordsDump_string);
            System.out.println("2>" + this.Records_string);
//          System.out.println("4>" + this.Fields_string);
    }
    
    @Override
    public void runView() { // PrintInfo() {
            System.out.println("1>\n" + this.FileName_string); // .RecordsDump_string);
            System.out.println("2>\n" + this.Fields_string); //.RecordsDump_string);
            System.out.println("3>\n" + this.Records_string);
    }

    @Override
    public int getChoice_menu() {
            return this.choice_menu;
    }

    @Override
    public void setPresenter(Object _presenter) {
            this.presenter = (I4presenter) _presenter;
    }

    @Override
    public void setFileName(String _args) {
            this.FileName_string = _args;
    }

    @Override
    public void setDump(String _RecordsDump) {
            this.RecordsDump_string = _RecordsDump;
    }

    @Override
    public void setInfo(String _RecordsString) { // public void setRecords(String _Records_string) {
            this.Records_string = _RecordsString;
    }

    @Override
    public void setListFields(String _args) {
            this.Fields_string = _args;
    }

    @Override
    public void setArrayMenu(String[] _args) {
            this.arrayMenu = _args;
    }    
}
