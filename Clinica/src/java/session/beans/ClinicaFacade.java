/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Clinica;

/**
 *
 * @author Miranda
 */
@Stateless
public class ClinicaFacade extends AbstractFacade<Clinica> {
    @PersistenceContext(unitName = "ClinicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicaFacade() {
        super(Clinica.class);
    }
    
}
