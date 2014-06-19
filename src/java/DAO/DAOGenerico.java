package DAO;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Database;
import util.HibernateUtil;

public abstract class DAOGenerico <E, PK extends Serializable>{
    
    private Session session;
    private Class classe;
    
    public DAOGenerico(Class classe){
        this.classe = classe;
        session = Database.getInstance().getSession();
    }
    
    public void save(E obj){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.beginTransaction();
            session.save(obj);
            t.commit();
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso",  "Cadastro realizado com sucesso") );
            
        } finally {
            session.close();
        }
    }
    
    public void update(E obj){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.beginTransaction();
            session.update(obj);
            t.commit();
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso",  "Alteração realizada com sucesso") );
            
        } finally {
            session.close();
        }
    }
    
    public void delete(E obj){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.beginTransaction();
            session.delete(obj);
            t.commit();
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso",  "Exclusão realizada com sucesso") );
            
        } finally {
            session.close();
        }
    }
    
    public E findById(PK id){
        return (E) session.get(classe,id);
    }
    
    public List<E> findAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = session.createCriteria(classe);
            return cri.list();
        } finally {
            session.close();
        }
    }
    
    public List<E> findLogin(String email, String senha){
        List<E> list;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = (Query) session.createQuery("from Usuario where email = :email and senha = :senha"); 
            query.setParameter("email", email); 
            query.setParameter("senha", senha);             
            list = query.list();
            return list;
            //Criteria cri = session.createCriteria(classe);
            //return cri.list();
        } finally {
            session.close();
        }
    }
}
