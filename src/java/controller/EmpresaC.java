package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Empresa;
import DAO.EmpresaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name = "empresaC")
@ViewScoped
public class EmpresaC {
    
    private Empresa empresa = new Empresa();
    private List<Empresa> empresaLista;

    public EmpresaC(){
        empresaLista = new EmpresaDAO().findAll();
        if (empresa == null){
            empresa = new Empresa();
        }
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresaLista() {
        return empresaLista;
    }

    public void setEmpresaLista(List<Empresa> empresaLista) {
        this.empresaLista = empresaLista;
    }
    
    public void salvarEmpresa(){
        try {
            this.empresa.setUsuarioscodigo(UsuarioLogadoC.getInstance().getUsuario());
        } catch (Exception ex) {
            Logger.getLogger(LocalidadeC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new EmpresaDAO().save(empresa);
        empresaLista = new EmpresaDAO().findAll();
        empresa = new Empresa();
    }
    
    public void atualizarEmpresa(){
        new EmpresaDAO().update(empresa);
        empresaLista = new EmpresaDAO().findAll();
        empresa = new Empresa();
    }
    
    public void deleteEmpresa(){
        new EmpresaDAO().delete(empresa);
        empresaLista = new EmpresaDAO().findAll();
        empresa = new Empresa();
    }
    
}
