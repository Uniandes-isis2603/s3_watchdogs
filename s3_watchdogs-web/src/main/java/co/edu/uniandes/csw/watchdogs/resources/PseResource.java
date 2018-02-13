/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.PseDetailDTO;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author jc.pulido
 */
public class PseResource {
    
    /**
     * <h1>POST /api/cities : Crear una ciudad.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Crea una nueva ciudad con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva ciudad .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la ciudad.
     * </code>
     * </pre>
     * @param pse {@link CityDetailDTO} - La ciudad que se desea guardar.
     * @return JSON {@link CityDetailDTO}  - La ciudad guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la ciudad.
     */
    @POST
    public PseDetailDTO createPse(PseDetailDTO pse) throws BusinessLogicException
    {
        return pse;
    }
    
    /**
     * <h1>GET /api/cities/{id} : Obtener ciudad por id.</h1>
     * 
     * <pre>Busca la ciudad con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la ciudad correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una ciudad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la ciudad que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("(id: \\d+)")
    public PseDetailDTO getPse(@PathParam("id") Long id)
    {
        return null;
    }
    
      /**
     * <h1>PUT /api/cities/{id} : Actualizar ciudad con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza la ciudad con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la ciudad con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ciudad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la ciudad que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pse {@link CityDetailDTO} La ciudad que se desea guardar.
     * @return JSON {@link CityDetailDTO} - La ciudad guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PseDetailDTO updatePse(@PathParam("id") Long id, PseDetailDTO pse) throws BusinessLogicException {
        return pse;
    }
    
     /**
     * <h1>DELETE /api/cities/{id} : Borrar ciudad por id.</h1>
     * 
     * <pre>Borra la ciudad con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la ciudad correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ciudad con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la ciudad que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCity(@PathParam("id") Long id) {
        // Void
    }
}