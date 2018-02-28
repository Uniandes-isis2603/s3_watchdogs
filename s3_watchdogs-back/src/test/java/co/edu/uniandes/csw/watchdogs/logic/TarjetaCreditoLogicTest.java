/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.logic;

import co.edu.uniandes.csw.watchdogs.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jc.pulido
 */
@RunWith(Arquillian.class)
public class TarjetaCreditoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private TarjetaCreditoLogic tarjetaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<TarjetaCreditoEntity> tarjetaData = new ArrayList<TarjetaCreditoEntity>();
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity editorial = factory.manufacturePojo(TarjetaCreditoEntity.class);
            em.persist(editorial);
            tarjetaData.add(editorial);
        }
    }
    
    /**
     * Prueba para crear un Book
     *
     *
     */
    @Test
    public void createBookTest() throws BusinessLogicException {
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaLogic.createTarjeta(newEntity);
        Assert.assertNotNull(result);
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCodigoSeguridad(), entity.getCodigoSeguridad());
        Assert.assertEquals(newEntity.getFechaVencimiento(), entity.getFechaVencimiento());
        Assert.assertEquals(newEntity.getNumeroTarjeta(), entity.getNumeroTarjeta());
    }
    
     /**
     * Prueba para consultar la lista de Books
     *
     *
     */
    @Test
    public void getTarjetasTest() {
        List<TarjetaCreditoEntity> list = tarjetaLogic.getTarjetas();
        Assert.assertEquals(tarjetaData.size(), list.size());
        for (TarjetaCreditoEntity entity : list) {
            boolean found = false;
            for (TarjetaCreditoEntity storedEntity : tarjetaData) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar un Book
     *
     *
     */
    @Test
    public void getTarjetaTest() {
        TarjetaCreditoEntity entity = tarjetaData.get(0);
        TarjetaCreditoEntity resultEntity = tarjetaLogic.getTarjeta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCodigoSeguridad(), resultEntity.getCodigoSeguridad());
        Assert.assertEquals(entity.getFechaVencimiento(), resultEntity.getFechaVencimiento());
        Assert.assertEquals(entity.getNumeroTarjeta(), resultEntity.getNumeroTarjeta());
    }
    
    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteTarjetaTest() {
        TarjetaCreditoEntity entity = tarjetaData.get(0);
        tarjetaLogic.deleteTarjeta(entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     /**
     * Prueba para actualizar un Book
     *
     *
     */
    @Test
    public void updateTarjetaTest() throws BusinessLogicException {
        TarjetaCreditoEntity entity = tarjetaData.get(0);
        TarjetaCreditoEntity pojoEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        pojoEntity.setId(entity.getId());

        tarjetaLogic.updateTarjeta(pojoEntity.getId(), pojoEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCodigoSeguridad(), resp.getCodigoSeguridad());
        Assert.assertEquals(pojoEntity.getFechaVencimiento(), resp.getFechaVencimiento());
        Assert.assertEquals(pojoEntity.getNumeroTarjeta(), resp.getNumeroTarjeta());
    }

}
