package com.bandwidth.tutorial.springdata;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bandwidth.tutorial.springdata.entity.Employee;
import com.bandwidth.tutorial.springdata.entity.Gender;
import com.bandwidth.tutorial.springdata.entity.Salary;
import com.bandwidth.tutorial.springdata.entity.SalaryId;
import com.bandwidth.tutorial.springdata.entity.Title;
import com.bandwidth.tutorial.springdata.entity.TitleId;
import com.bandwidth.tutorial.springdata.repository.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories("com.bandwidth.tutorial.springdata.repository")
@EnableTransactionManagement
@EntityScan("com.bandwidth.tutorial.springdata.entity")
public class SpringDataApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SpringDataApplication.class);

    public static void main(final String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner demo(final EmployeeRepository employeeRepository) {
        return args -> {
            //Define new employee
            final Employee employee = new Employee();
            employee.setEmpNo(99999L);
            employee.setFirstName("Michael");
            employee.setLastName("Coughlin");
            employee.setGender(Gender.M);
            employee.setBirthDate(new Date());
            employee.setHireDate(new Date());

            //Define new title
            final Title title = new Title();
            title.setEmployee(employee);
            final TitleId titleId = new TitleId();
            titleId.setFromDate(new Date());
            title.setToDate(new Date());
            titleId.setTitle("President");
            title.setId(titleId);
            employee.getTitles().add(title);

            //Define new salary
            final Salary salary = new Salary();
            salary.setEmployee(employee);
            final SalaryId salaryId = new SalaryId();
            salaryId.setFromDate(new Date());
            salary.setToDate(new Date());
            salary.setId(salaryId);
            salary.setSalary(new BigDecimal(50000));
            employee.getSalaries().add(salary);

            LOG.info("Saving employee");
            employeeRepository.save(employee);

            LOG.info("Retrieving employee");
            final Employee retrievedEmployee = employeeRepository.findByFirstNameAndLastName("Michael", "Coughlin").get(0);

            LOG.info("Deleting employee");
            employeeRepository.delete(retrievedEmployee);
        };
    }
}
