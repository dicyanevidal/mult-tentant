package vidal.dicyane.atividademultitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vidal.dicyane.atividademultitenant.config.CustomRoutingDataSource;
import vidal.dicyane.atividademultitenant.service.MasterService;
import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "vidal.dicyane.atividademultitenant")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "vidal.dicyane.atividademultitenant")
public class AtividadeMultiTenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeMultiTenantApplication.class, args);
	}

	@Bean
	public DataSource dataSource(){
		CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
		customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
		return customDataSource;
	}

}
