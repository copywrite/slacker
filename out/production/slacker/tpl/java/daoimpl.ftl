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

@Service
public class ${className} extends BaseDAO{

    private static final String NAMESPACE = "${daoClassName}.";

    /**
     * insert one data
     *
     * @param ${doPropertyName} object
     * @return primaryKey ${primaryKeyType}
     * @throws Exception exception
     */
     public ${primaryKeyType} insert(${doClassName} ${doPropertyName}) throws DaoException{
        try{
            <#if daoUseSequence>
            ${primaryKeyType} ${primaryKeyName} = this.getNextId("${tableName}");
            ${doPropertyName}.set${primaryKeyNameAtMethod}(${primaryKeyName});
            sqlMapClientTemplate.insert(NAMESPACE + "insert", ${doPropertyName});
            return ${primaryKeyName};
            <#else>
            return (${primaryKeyType}) sqlMapClientTemplate.insert(NAMESPACE + "insert", ${doPropertyName});
            </#if>
        } catch (Exception e) {
            throw new DaoException(e);
        }
     }

    /**
     * update data
     *
     * @param ${doPropertyName} object
     * @return update num
     * @throws Exception exception
     */
    public int update(${doClassName} ${doPropertyName}) throws DaoException{
        try{
            return sqlMapClientTemplate.update(NAMESPACE + "update", ${doPropertyName});
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    /**
     * get an obj
     *
     * @param ${primaryKeyName} key
     * @return do obj
     * @throws Exception exception
     */
    public ${doClassName} get(${primaryKeyType} ${primaryKeyName}) throws DaoException{
        try{
            return (${doClassName}) sqlMapClientTemplate.queryForObject(NAMESPACE + "select", ${primaryKeyName});
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * query a list
     *
     * @param ${queryPropertyName} query
     * @return List
     * @throws Exception exception
     */
    @SuppressWarnings("unchecked")
    public List<${doClassName}> getList(${queryClassName} ${queryPropertyName}) throws DaoException{
        try{
            return (List<${doClassName}>) sqlMapClientTemplate.queryForList(NAMESPACE + "queryList", ${queryPropertyName});
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * query count
     *
     * @param ${queryPropertyName} query
     * @return Integer
     * @throws Exception exception
     */
    public Integer getCount(${queryClassName} ${queryPropertyName}) throws DaoException{
        try{
            return (Integer) sqlMapClientTemplate.queryForObject(NAMESPACE + "queryCount", ${queryPropertyName});
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
    <#if daoLogicDelete>
     * logically delete one line
    <#else>
     * physically delete one line
    </#if>
     *
     * @param ${primaryKeyName} key
     * @return delete num
     * @throws Exception exception
     */
    public int delete(${primaryKeyType} ${primaryKeyName}) throws Exception{
        try{
            <#if daoLogicDelete>
            return sqlMapClientTemplate.update(NAMESPACE + "delete", ${primaryKeyName});
            <#else>
            return sqlMapClientTemplate.delete(NAMESPACE + "delete", ${primaryKeyName});
            </#if>
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}