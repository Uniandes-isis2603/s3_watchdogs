/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.DisponibilidadDetailDTO;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "disponibilidades".
 * URL: /api/disponibilidades
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "disponibilidades".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author id.salazar  
 * @version 1.0
 */
@Path("disponibilidades")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DisponibilidadResource {
    /**
     * <h1>POST /api/disponibilidades : Crear una disponibilidad.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link DisponibilidadDetailDTO}.
     * 
     * Crea una nueva Disponibilidad con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva Disponibilidad .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la Disponibilidad.
     * </code>
     * </pre>
     * @param disponibilidad {@link DisponibilidadDetailDTO} - La disponibilidad que se desea guardar.
     * @return JSON {@link DisponibilidadDetailDTO}  - La disponibilidad guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la Disponibilidad.
     */
    @POST
    public DisponibilidadDetailDTO createDisponibilidad(DisponibilidadDetailDTO disponibilidad) throws BusinessLogicException {
        return disponibilidad;
    }

    /**
     * <h1>GET /api/disponibilidades : Obtener todas las disponibilidades.</h1>
     * 
     * <pre>Busca y devuelve todas las disponibilidades que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las disponibilidades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link DisponibilidadDetailDTO} - Las disponibilidades encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<DisponibilidadDetailDTO> getDisponibilidades() {
        return new ArrayList<>();
    }

    /**
     * <h1>GET /api/disponibilidades/{id} : Obtener disponibilidad por id.</h1>
     * 
     * <pre>Busca la disponibilidad con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la disponibilidad correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una disponibilidad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la disponibilidad que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link DisponibilidadDetailDTO} - La disponibilidad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public DisponibilidadDetailDTO getDisponibilidad(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/disponibilidades/{id} : Actualizar disponibilidad con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link DisponibilidadDetailDTO}.
     * 
     * Actualiza la disponibilidad con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la disponibilidad con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una disponibilidad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la dos´pmonoñodad que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param disponibilidad {@link DisponibilidadDetailDTO} La disponibilidad que se desea guardar.
     * @return JSON {@link DisponibilidadDetailDTO} - La disponibilidad guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public DisponibilidadDetailDTO updateDisponibilidad(@PathParam("id") Long id, DisponibilidadDetailDTO disponibilidad){
        return disponibilidad;
    }
    
    /**
     * <h1>DELETE /api/disponibilidades/{id} : Borrar factura por id.</h1>
     * 
     * <pre>Borra la disponibilidad con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la disponibilidad correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una disponibilidad con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la disponibilidad que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteDisponibilidad(@PathParam("id") Long id) {
        // Void
    }
}