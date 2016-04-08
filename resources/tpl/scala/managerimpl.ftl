package ${package}

import javax.annotation.Resource
<#list importList as import>
import ${import}
</#list>
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


/**
 * ${className}
 *
 * User: ${user}
 * Date: ${today}
 */
@Service("${managerPropertyName}")
class ${className} extends ${managerClassName}{
    private val logger = LoggerFactory.getLogger(this.getClass)

    @Resource
    val ${daoPropertyName}: ${daoClassName} = _

    /**
     * insert one data
     *
     * @param ${objPropertyName} object
     * @return primaryKey ${primaryKeyType}
     * @throws Exception exception
     */
    override def insert(${objPropertyName}: ${objClassName}): ${primaryKeyType} = {
        try{
            <#if managerUseBO>
            ${daoPropertyName}.insert(${transferClassName}.toDO(${objPropertyName}))
            <#else>
            ${daoPropertyName}.insert(${objPropertyName})
            </#if>
        }catch {
            case e:Exception =>
                logger.error("[${className}.insert]",e)
                null
        }
    }

    /**
     * update data
     *
     * @param ${objPropertyName} object
     * @return update num
     * @throws Exception exception
     */
    override def update(${objPropertyName}: ${objClassName}): Int = {
        try{
            <#if managerUseBO>
            ${daoPropertyName}.update(${transferClassName}.toDO(${objPropertyName}))
            <#else>
            ${daoPropertyName}.update(${objPropertyName})
            </#if>
        }catch {
            case e:Exception =>
                logger.error("[${className}.update]",e)
                0
        }
    }

    /**
     * get an obj
     *
     * @param ${primaryKeyName} key
     * @return do obj
     * @throws Exception exception
     */
    override def get(${primaryKeyName}: ${primaryKeyType}): ${objClassName} = {
        try{
            <#if managerUseBO>
            ${transferClassName}.toBO(${daoPropertyName}.get(${primaryKeyName}))
            <#else>
            ${daoPropertyName}.get(${primaryKeyName})
            </#if>
        }catch {
            case e:Exception =>
                logger.error("[${className}.get]",e)
                null
        }
    }

    /**
     * query a list
     *
     * @param ${queryPropertyName} query
     * @return List
     * @throws Exception exception
     */
    override def getList(${queryPropertyName}: ${queryClassName}): util.List[${objClassName}] = {
        try{
            <#if managerUseBO>
            ${transferClassName}.toBOList(${daoPropertyName}.getList(${queryPropertyName}))
            <#else>
            ${daoPropertyName}.getList(${queryPropertyName})
            </#if>
        }catch {
            case e:Exception =>
                logger.error("[${className}.getList]",e)
                null
        }
    }

    /**
     * query count
     *
     * @param ${queryPropertyName} query
     * @return Integer
     * @throws Exception exception
     */
    override def getCount(${queryPropertyName}: ${queryClassName}): Int = {
        try{
            ${daoPropertyName}.getCount(${queryPropertyName})
        }catch {
            case e:Exception =>
                logger.error("[${className}.getCount]",e)
                0
        }
    }

    /**
     * logic delete one line
     *
     * @param ${primaryKeyName} key
     * @return delete num
     * @throws Exception exception
     */
    override def delete(${primaryKeyName}: ${primaryKeyType}): Int = {
        try{
            ${daoPropertyName}.delete(${primaryKeyName})
        }catch {
            case e:Exception =>
                logger.error("[${className}.delete]",e)
                0
        }
    }

}