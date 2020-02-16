package org.ticketing.app.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketing.app.dao.entity.Ticket;
import org.ticketing.app.dao.repository.TicketRepository;
import org.ticketing.app.util.TestUtil;

public class TicketRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TicketRepository ticketRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.clear();
    }

    @Test
    public void insertEntity_WhenGivenDummyEntity_ThenSuccess() {
        Ticket saveEntity = ticketRepository.save(TestUtil.createTicketEntity());
        assertTrue(saveEntity != null && saveEntity.getId() != null);
    }

    @Test
    public void updateEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Ticket saveEntity = ticketRepository.save(TestUtil.createTicketEntity());
    	Ticket updateEntity = ticketRepository.findById(saveEntity.getId()).get();
    	updateEntity.setTicketClass(TestUtil.TEST);
    	ticketRepository.save(updateEntity);
    }

    @Test
    public void deleteEntity_WhenGivenDummyEntity_ThenSuccess() {
    	Ticket saveEntity = ticketRepository.save(TestUtil.createTicketEntity());
    	Ticket deleteEntity = ticketRepository.findById(saveEntity.getId()).get();
    	ticketRepository.delete(deleteEntity);
    }
}
