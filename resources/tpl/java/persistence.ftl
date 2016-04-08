<?xml version="1.0" encoding="${encoding}"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>


    <!-- dynamic data source -->
    <bean id="projectDS" class="com.taobao.tddl.jdbc.group.TGroupDataSource" init-method="init">
        <property name="dbGroupKey" value="{DIAMOND_PROJECT}_GROUP" />
        <property name="appName" value="{DIAMOND_PROJECT}_APP"/>
    </bean>

	<bean id="jndiTemplate" class="org.springframework.jndi.JndiTemplate"/>


	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource">
			<ref local="projectDS" />
		</property>
	</bean>

	<bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
		<property name="transactionManager">
			<ref local="transactionManager" />
		</property>
	</bean>

    <alias alias="transactionOperations" name="transactionTemplate"/>

	<bean id="sqlMapClientFactoryBean" class="org.springframework.orm.ibatis.SqlMapClientFactoryBean">
		<property name="configLocation" value="classpath:sqlmap-sample.xml"/>
		<property name="dataSource" ref="projectDS"/>
	</bean>
	
	<bean id="sqlMapClientTemplate" class="org.springframework.orm.ibatis.SqlMapClientTemplate" >
		<property name="sqlMapClient">
			<ref local="sqlMapClientFactoryBean" />
		</property>
	</bean>

    <bean id="sequenceDao" class="com.taobao.tddl.client.sequence.impl.DefaultSequenceDao" lazy-init="default"
          dependency-check="default">
        <property name="dataSource" ref="projectDS"/>
        <property name="tableName" value="sequence"/>
        <property name="nameColumnName" value="k"/>
        <property name="valueColumnName" value="val"/>
        <property name="gmtModifiedColumnName" value="gmt_modified"/>
        <property name="step" value="1"/>
    </bean>

    <bean id="${tablePropertyName}Sequence" class="com.taobao.tddl.client.sequence.impl.DefaultSequence" lazy-init="default"
          dependency-check="default">
        <property name="sequenceDao" ref="sequenceDao"/>
        <property name="name" value="${tableName}"/>
    </bean>


    <bean id="baseDAO" class="${package}.BaseDAO" abstract="true">
        <property name="sequenceTable">
            <map>
                <entry key="${tableName}_sequence" value-ref="${tablePropertyName}Sequence"/>
            </map>
        </property>
        <property name="sqlMapClient" ref="sqlMapClientTemplate"/>
    </bean>

</beans>