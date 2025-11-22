/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.util.List;
import presenters.I1presenter;
/**
 *
 * @author k
 */
public interface I1view {
    public abstract void runView() throws IOException;
    public abstract void performAction(int choice_FileName, int choice_StruData) throws IOException;
    public abstract void setPresenter(I1presenter presenter);
    public abstract void setListFiles(List<String> list);
    public abstract void setArrayFiles(String[] array);
    public abstract void setArrayStruData(String[] array);
}
