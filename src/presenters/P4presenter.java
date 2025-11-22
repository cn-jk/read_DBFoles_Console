/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenters;

import models.I4model;
import java.io.File;
import java.io.IOException;
import models.*;
import views.*;

/**
 *
 * @author k
 */
public class P4presenter implements I4presenter {

    final private I2view  view;
    final private I4model model;
    final private String  whatLookingStructOrData = "Data";
    
    public P4presenter(I2view _view, I4model _model) throws IOException {
        this.model = _model;
        this.view  = _view;
    } 
}
