package com.viagging.api.report.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.viagging.api.report.core.dao.MovimientoDAO;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Repository
public class MovimientoDAOImpl implements MovimientoDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovimientoDAOImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
    
	@Override
	public List<Object[]> findInfoReportSearch(String queryString) {
		List<Object[]> list = new ArrayList<>();
		try {
			Query query = entityManager.createNativeQuery(queryString);
            list = query.getResultList();
			return list;
		} catch(NoResultException e){
			LOGGER.error(e.getMessage());
			return list;
		}
	}
	
}