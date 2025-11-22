/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenters;

import models.I2model;
import java.io.File;
import java.io.IOException;
import models.*;
import views.*;

/**
 *
 * @author k
 */
public class P2presenter implements I2presenter {

    final private I2view  view;
    final private I2model model;
    final private String  whatLookingStructOrData = "Struct_Header_&_Fields";
    
    public P2presenter(I2view _view, I2model _model) throws IOException {
        this.model = _model;
        this.view  = _view;
    } 
}
