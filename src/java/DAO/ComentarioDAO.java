/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.Serializable;
import model.Comentario;

/**
 *
 * @author 2200319
 */
public class ComentarioDAO extends DAOGenerico<Comentario, Integer> {
    
    public ComentarioDAO() {
        super(Comentario.class);
    }
}


