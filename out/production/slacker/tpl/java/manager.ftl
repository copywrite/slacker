package ${package};

<#list importList as import>
import ${import};
</#list>

/**
 * ${className}
 *
 * User: ${user}
 * Date: ${today}
 */

public interface ${className}{

    /**
     * insert one data
     *
     * @param ${objPropertyName} object
     * @return primaryKey ${primaryKeyType}
     * @throws Exception exception
     */
     public ${primaryKeyType} insert(${objClassName} ${objPropertyName}) throws Exception;

    /**
     * update data
     *
     * @param ${objPropertyName} object
     * @return update num
     * @throws Exception exception
     */
    public int update(${objClassName} ${objPropertyName}) throws Exception;

    /**
     * get an obj
     *
     * @param ${primaryKeyName} key
     * @return obj obj
     * @throws Exception exception
     */
    public ${objClassName} get(${primaryKeyType} ${primaryKeyName}) throws Exception;

    /**
     * query a list
     *
     * @param ${queryPropertyName} query
     * @return List
     * @throws Exception exception
     */
    public List<${objClassName}> getList(${queryClassName} ${queryPropertyName}) throws Exception;

    /**
     * query count
     *
     * @param ${queryPropertyName} query
     * @return Integer
     * @throws Exception exception
     */
    public Integer getCount(${queryClassName} ${queryPropertyName}) throws Exception;

    /**
     * logic delete one line
     *
     * @param ${primaryKeyName} key
     * @return delete num
     * @throws Exception exception
     */
    public int delete(${primaryKeyType} ${primaryKeyName}) throws Exception;

}