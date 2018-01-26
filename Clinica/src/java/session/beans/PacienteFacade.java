package session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Paciente;

/**
 *
 * @author Miranda
 */
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {
    @PersistenceContext(unitName = "ClinicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }
    
}
