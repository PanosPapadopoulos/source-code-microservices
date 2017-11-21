package cs.unipi.gr.projects.generic;

import cs.unipi.gr.projects.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
@SuppressWarnings(value = "unchecked")
public abstract class GenericDAOImpl<Entity, ID extends Serializable> implements GenericDAO<Entity, ID> {

    protected SessionFactory sessionFactory;

    private Class clazz;

    public GenericDAOImpl(Class clazz) {
        this.clazz = clazz;
    }

    public Entity getByID(ID id) {
        // TODO Select by ID
        // Test
        Transaction txn = null;

        Entity entity = null;

        try {

            txn = getCurrentSession().beginTransaction();

            entity = (Entity) getCurrentSession().get(this.clazz, id);

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return entity;
    }

    public List getList() {

        List list;

        Transaction txn = null;
        try {

            txn = getCurrentSession().beginTransaction();

            list = getCurrentSession().createQuery("from " + this.clazz.getName()).list();

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return list;
    }

    public List search(Map<String, Object> parameterMap) {

        List list;

        Transaction txn = null;
        try {

            txn = getCurrentSession().beginTransaction();

            list = getCurrentSession().createQuery("from " + this.clazz.getName()).list();

            Criteria criteria = getCurrentSession().createCriteria(clazz);
            for (String field : parameterMap.keySet()) {
                //criteria.add(Restrictions.ilike(field, parameterMap.get(field)));

                if (parameterMap.get(field) instanceof Boolean) {
                    criteria.add(Restrictions.eq(field, parameterMap.get(field)));
                }
                else if (parameterMap.get(field) instanceof Integer) {
                    criteria.add(Restrictions.eq(field, parameterMap.get(field)));
                } else {
                    criteria.add(Restrictions.ilike(field, "%" +parameterMap.get(field) +"%"));
                }
            }

//            criteria.addOrder(Order.desc("createDate"));

            list = criteria.list();

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return list;

    }
    public List authenticate(String email,String password){

        List list;

        Transaction txn = null;
        try {

            txn = getCurrentSession().beginTransaction();

            list = getCurrentSession().createQuery("from " + this.clazz.getName()).list();

            Criteria criteria = getCurrentSession().createCriteria(clazz);
            criteria.add(Restrictions.eq("email",email));
            criteria.add(Restrictions.ilike("password",password, MatchMode.ANYWHERE));

            criteria.addOrder(Order.desc("createDate"));

            list = criteria.list();
            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return list;

    }
    public List searchDbSystem(String dbServerRelease, String dbSystem) {

        List list;

        Transaction txn = null;
        try {

            txn = getCurrentSession().beginTransaction();

            list = getCurrentSession().createQuery("from " + this.clazz.getName()).list();

            Criteria criteria = getCurrentSession().createCriteria(clazz);

            criteria.add(Restrictions.ilike("dbServerRelease", dbServerRelease +"%"));
            //criteria.add(Restrictions.ilike("dbSystem", "%" +dbSystem +"%"));

            criteria.addOrder(Order.desc("createDate"));

            list = criteria.list();

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return list;

    }

    public List searchInstance(Map<String, Object> parameterMap, Date createDateFrom, Date createDateTo) {

        List list;

        Transaction txn = null;
        try {

            txn = getCurrentSession().beginTransaction();

            list = getCurrentSession().createQuery("from " + this.clazz.getName()).list();

            Criteria criteria = getCurrentSession().createCriteria(clazz);
            for (String field : parameterMap.keySet()) {
                //criteria.add(Restrictions.ilike(field, parameterMap.get(field)));

                if (parameterMap.get(field) instanceof Boolean) {
                    criteria.add(Restrictions.eq(field, parameterMap.get(field)));
                }
                else if (parameterMap.get(field) instanceof Integer) {
                    criteria.add(Restrictions.eq(field, parameterMap.get(field)));
                } else {
                    criteria.add(Restrictions.ilike(field, "%" +parameterMap.get(field) +"%"));
                }
            }

            if (null != createDateFrom) {
                criteria.add(Restrictions.gt("createDate", createDateFrom));
            }

            if (null != createDateTo) {
                criteria.add(Restrictions.lt("createDate", createDateTo));
            }

            list = criteria.list();

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (getCurrentSession() != null) {
                getCurrentSession().close();
            }
        }

        return list;

    }

    public ID insert(Entity entity) {

        getCurrentSession().beginTransaction();

        ID pkId = (ID) getCurrentSession().save(entity);

        getCurrentSession().getTransaction().commit();

        getCurrentSession().close();

        return pkId;
    }

    public void update(Entity entity) {

        getCurrentSession().beginTransaction();

        getCurrentSession().update(entity);

        getCurrentSession().getTransaction().commit();

        getCurrentSession().close();
    }

    public void delete(Entity entity) {

        getCurrentSession().beginTransaction();

        getCurrentSession().delete(entity);

        getCurrentSession().getTransaction().commit();

        getCurrentSession().close();
    }

    public void deleteById(ID id) {
        getCurrentSession().beginTransaction();

        getCurrentSession().delete(getByID(id));

        getCurrentSession().getTransaction().commit();

        getCurrentSession().close();
    }

    private Session getCurrentSession() {
        return new HibernateUtil().getSessionFactory().getCurrentSession( );
    }

}