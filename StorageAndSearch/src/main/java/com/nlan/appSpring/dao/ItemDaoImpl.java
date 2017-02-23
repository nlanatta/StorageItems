package com.nlan.appSpring.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nlan.appSpring.model.Item;

@Repository("itemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Item findById(Integer id) { //Item is the Entity instead of stock (table name)
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.idEq(id));
		List<?> list = hibernateTemplate.findByCriteria(criteria);
		return Objects.nonNull(list) && list.size() > 0 ? (Item)list.get(0) : null;
	}
	
	@Override
	public Item findByCategoryId(Integer id) { //Item is the Entity instead of stock (table name)
		List<?> list = hibernateTemplate.find("from Item where CATEGORY_ID="+id+"");
		return Objects.nonNull(list) && list.size() > 0 ? (Item)list.get(0) : null;
	}

	@Override
	public List<Item> findAll() {
		List<Item> result = hibernateTemplate.loadAll(Item.class);
		return result;
	}

	@Override
	public void save(Item item) {
		hibernateTemplate.save(item);
	}

	@Override
	public void update(Item item) {
		hibernateTemplate.update(item);
	}

	@Override
	public void delete(Integer id) {
		Item item = findById(id);
		hibernateTemplate.delete(item );
	}

}
