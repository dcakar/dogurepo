package org.ticketing.app.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketing.app.dao.entity.Route;
import org.ticketing.app.dao.repository.RouteRepository;
import org.ticketing.app.util.TestUtil;

public class RouteRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private RouteRepository routeRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.clear();
    }

    @Test
    public void insertEntity_WhenGivenDummyEntity_ThenSuccess() {
        Route saveEntity = routeRepository.save(TestUtil.createRouteEntity());
        assertTrue(saveEntity != null && saveEntity.getId() != null);
    }

    @Test
    public void updateEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Route saveEntity = routeRepository.save(TestUtil.createRouteEntity());
    	Route updateEntity = routeRepository.findById(saveEntity.getId()).get();
    	updateEntity.setArrival(TestUtil.TEST);
    	routeRepository.save(updateEntity);
    }

    @Test
    public void deleteEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Route saveEntity = routeRepository.save(TestUtil.createRouteEntity());
    	Route deleteEntity = routeRepository.findById(saveEntity.getId()).get();
    	routeRepository.delete(deleteEntity);
    }
}
