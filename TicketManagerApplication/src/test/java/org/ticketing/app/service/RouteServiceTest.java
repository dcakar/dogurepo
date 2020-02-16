package org.ticketing.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.response.ResponseRouteList;
import org.ticketing.app.dao.entity.Route;
import org.ticketing.app.dao.repository.RouteRepository;
import org.ticketing.app.util.TestUtil;

public class RouteServiceTest extends AbstractServiceTest {
    private RouteService routeService;
    @Mock
    private RouteRepository routeRepository;
   

    @Before
    public void setUp() {
    	routeService = new RouteServiceImpl(routeRepository);
    }

    @Test
    public void getRouteList_SuccessTest() throws Exception {
    	Route routeEntity = TestUtil.createRouteEntity();
    	List<Route> routeEntityList = new ArrayList<>();
    	routeEntityList.add(routeEntity);
        when(routeRepository.findAll()).thenReturn(routeEntityList);
    	ResponseRouteList response = routeService.getRouteList();
        verify(routeRepository, times(1)).findAll();
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getRouteDtoList()));
    }

    @Test
    public void getRouteById_SuccessTest() throws Exception {
    	Route routeEntity = TestUtil.createRouteEntity();
    	List<Route> routeEntityList = new ArrayList<>();
    	routeEntityList.add(routeEntity);
        when(routeRepository.findById(anyLong())).thenReturn(Optional.of(routeEntity));
    	ResponseRouteList response = routeService.getRoute(TestUtil.LONG_VAL);
        verify(routeRepository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getRouteDtoList()));
    }
    
    @Test
    public void addRoute_SuccessTest() throws Exception {
    	Route routeEntity = TestUtil.createRouteEntity();
        when(routeRepository.save(any(Route.class))).thenReturn(routeEntity);
		routeService.addRoute(TestUtil.createRequestRouteAdd());
        verify(routeRepository, times(1)).save(any(Route.class));
    }
}
