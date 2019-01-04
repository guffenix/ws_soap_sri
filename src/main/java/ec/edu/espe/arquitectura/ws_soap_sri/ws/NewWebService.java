/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ws_soap_sri.ws;

import ec.edu.espe.arquitectura.ws_soap_sri.dao.ProcesarSRI;
import ec.edu.espe.arquitectura.ws_soap_sri.modelo.ContribuyenteGenerico;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Rolando Cachipuendo
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    @EJB
    private ProcesarSRI ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "obtenerSri")
    public ContribuyenteGenerico obtenerSri(@WebParam(name = "identificacion") String identificacion)   {
        try {
            return ejbRef.obtenerSri(identificacion);
        } catch (SQLException ex) {
            
            Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
