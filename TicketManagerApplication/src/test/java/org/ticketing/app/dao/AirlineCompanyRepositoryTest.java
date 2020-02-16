package org.ticketing.app.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketing.app.dao.entity.AirlineCompany;
import org.ticketing.app.dao.repository.AirlineCompanyRepository;
import org.ticketing.app.util.TestUtil;

public class AirlineCompanyRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.clear();
    }

    @Test
    public void insertEntity_WhenGivenDummyEntity_ThenSuccess() {
        AirlineCompany airlineCompanyEntity = airlineCompanyRepository.save(TestUtil.createAirlineCompanyEntity());
        assertTrue(airlineCompanyEntity != null && airlineCompanyEntity.getId() != null);
    }

    @Test
    public void updateEntity_WhenGivenDummyEntity_ThenSuccess() {
    	AirlineCompany savedEntity = airlineCompanyRepository.save(TestUtil.createAirlineCompanyEntity());
    	AirlineCompany updatedEntity = airlineCompanyRepository.findById(savedEntity.getId()).get();
    	updatedEntity.setName(TestUtil.TEST);
    	airlineCompanyRepository.save(updatedEntity);
    }

    @Test
    public void deleteEntity_WhenGivenDummyEntity_ThenSuccess() {
    	AirlineCompany savedEntity = airlineCompanyRepository.save(TestUtil.createAirlineCompanyEntity());
    	AirlineCompany deletedEntity = airlineCompanyRepository.findById(savedEntity.getId()).get();
    	airlineCompanyRepository.delete(deletedEntity);
    }
}
