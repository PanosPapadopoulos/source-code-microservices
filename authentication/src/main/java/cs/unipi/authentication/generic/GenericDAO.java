package cs.unipi.authentication.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
public interface GenericDAO<Entity, ID extends Serializable> {

    Entity getByID(ID id);

    List getList();

    List search(Map<String, Object> parameterMap);

    ID insert(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    void deleteById(ID id);

}