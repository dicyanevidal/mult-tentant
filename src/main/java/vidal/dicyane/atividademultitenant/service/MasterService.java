package vidal.dicyane.atividademultitenant.service;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;

public class MasterService {

    public static Map<Object, Object> getDataSourceHashMap(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo_database?createDatabaseIfNotExist=true&characterEncoding=latin1&useConfigs=maxPerformance");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/demo_database_2?createDatabaseIfNotExist=true&characterEncoding=latin1&useConfigs=maxPerformance");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");

        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);
        return hashMap;
    }
}
