package org.ticketing.app.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.util.TestUtil;

public class FlightRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.clear();
    }

    @Test
    public void insertEntity_WhenGivenDummyEntity_ThenSuccess() {
        Flight saveEntity = flightRepository.save(TestUtil.createFlightEntity());
        assertTrue(saveEntity != null && saveEntity.getId() != null);
    }

    @Test
    public void updateEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Flight saveEntity = flightRepository.save(TestUtil.createFlightEntity());
    	Flight updateEntity = flightRepository.findById(saveEntity.getId()).get();
    	updateEntity.increaseTicketsSold(10);
        flightRepository.save(updateEntity);
    }

    @Test
    public void deleteEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Flight saveEntity = flightRepository.save(TestUtil.createFlightEntity());
    	Flight deleteEntity = flightRepository.findById(saveEntity.getId()).get();
    	flightRepository.delete(deleteEntity);
    }
}
