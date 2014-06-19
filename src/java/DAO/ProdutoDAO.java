/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import model.Produto;

/**
 *
 * @author 2200319
 */
public class ProdutoDAO extends DAOGenerico<Produto, Integer>{
        public ProdutoDAO() {
        super(Produto.class);
    }
    
}
