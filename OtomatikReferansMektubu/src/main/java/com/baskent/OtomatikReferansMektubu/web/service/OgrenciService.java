package com.baskent.OtomatikReferansMektubu.web.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.baskent.OtomatikReferansMektubu.web.entity.Ogrenci;
import com.baskent.OtomatikReferansMektubu.web.utilities.IDataService;
import com.baskent.OtomatikReferansMektubu.web.utilities.PagingResult;
import com.baskent.OtomatikReferansMektubu.web.service.BaseDao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ogrenciService")
public class OgrenciService implements com.baskent.OtomatikReferansMektubu.web.utilities.IDataService<Ogrenci> {

    @Autowired
	private transient BaseDao baseDao;


	public Ogrenci save(Ogrenci entity) {
		return (Ogrenci) baseDao.save(entity);

	}


	public Ogrenci update(Ogrenci entity) {
		return (Ogrenci) baseDao.update(entity);
	}

	public boolean delete(Ogrenci entity) {
		return baseDao.delete(entity);
	}

	@Transactional
	public PagingResult getAllByPaging(int first, int pageSize,
			SortOrder sortOrder, Map<String, Object> filters) {
		Session session = baseDao.getSession();
		Criteria criteria = session.createCriteria(Ogrenci.class);
		if (filters.get("ad") != null) {
			criteria.add(Restrictions.ilike("ad", filters.get("ad").toString(),
					MatchMode.ANYWHERE));
		}
		int totalResult = Integer.parseInt(criteria
				.setProjection(Projections.rowCount()).uniqueResult()
				.toString());
		criteria.setProjection(null);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(first);
		criteria.addOrder(Order.desc("id"));
		return new com.baskent.OtomatikReferansMektubu.web.utilities.PagingResult(criteria.list(), totalResult);
	}

	@SuppressWarnings("unchecked")
	public List<Ogrenci> getAll() {
		return (List<Ogrenci>) baseDao.getAll(Ogrenci.class);
	}

	public Ogrenci getById(Long entityId) {
		return (Ogrenci) baseDao.getById(entityId, Ogrenci.class);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

    
}
