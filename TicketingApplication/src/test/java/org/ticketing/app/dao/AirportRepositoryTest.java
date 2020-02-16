package org.ticketing.app.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketing.app.dao.entity.Airport;
import org.ticketing.app.dao.repository.AirportRepository;
import org.ticketing.app.util.TestUtil;

public class AirportRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AirportRepository airportRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.clear();
    }

    @Test
    public void insertEntity_WhenGivenDummyEntity_ThenSuccess() {
        Airport saveEntity = airportRepository.save(TestUtil.createAirportEntity());
        assertTrue(saveEntity != null && saveEntity.getId() != null);
    }

    @Test
    public void updateEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Airport saveEntity = airportRepository.save(TestUtil.createAirportEntity());
    	Airport updateEntity = airportRepository.findById(saveEntity.getId()).get();
    	updateEntity.setName(TestUtil.TEST);
    	airportRepository.save(updateEntity);
    }

    @Test
    public void deleteEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Airport saveEntity = airportRepository.save(TestUtil.createAirportEntity());
    	Airport deleteEntity = airportRepository.findById(saveEntity.getId()).get();
    	airportRepository.delete(deleteEntity);
    }
}
