
<#list importList as import>
import ${import}
</#list>

/**
 * ${className}
 *
 * User: ${user}
 * Date: ${today}
 */

trait ${className}{

    /**
     * insert one data
     *
     * @param ${objPropertyName} object
     * @return primaryKey ${primaryKeyType}
     * @throws Exception exception
     */
     def insert(${objPropertyName}: ${objClassName}): ${primaryKeyType}

    /**
     * update data
     *
     * @param ${objPropertyName} object
     * @return update num
     * @throws Exception exception
     */
    def update(${objPropertyName}: ${objClassName}): Int

    /**
     * get an obj
     *
     * @param ${primaryKeyName} key
     * @return obj obj
     * @throws Exception exception
     */
    def get(${primaryKeyName}: ${primaryKeyType}): ${objClassName}

    /**
     * query a list
     *
     * @param ${queryPropertyName} query
     * @return List
     * @throws Exception exception
     */
    def getList(${queryPropertyName}: ${queryClassName}): util.List[${objClassName}]

    /**
     * query count
     *
     * @param ${queryPropertyName} query
     * @return Integer
     * @throws Exception exception
     */
    def getCount(${queryPropertyName}: ${queryClassName}): Int

    /**
     * logic delete one line
     *
     * @param ${primaryKeyName} key
     * @return delete num
     * @throws Exception exception
     */
    def delete(${primaryKeyName}: ${primaryKeyType}): Int

}