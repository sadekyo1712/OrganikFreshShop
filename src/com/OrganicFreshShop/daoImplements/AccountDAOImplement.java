package com.OrganicFreshShop.daoImplements;

import com.OrganicFreshShop.dao.AccountDAO;
import com.OrganicFreshShop.mapper.AccountMapper;
import com.OrganicFreshShop.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by root on 11/22/16.
 */
public class AccountDAOImplement implements AccountDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDAOImplement( DataSource dataSource ) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate( dataSource );
    }

    @Override
    public Account fetchAccount(String username) {
        String SQL_FETCH_ACCOUNT =
                "Select * " +
                "From Account " +
                "Where User_Name = ?";

        try {
            return jdbcTemplate.queryForObject( SQL_FETCH_ACCOUNT, new Object[]{ username }, new AccountMapper() );
        } catch ( Exception ex ) {
            System.out.println("Error when fetch Account in fetchAccount()");
        }
        return null;
    }

    @Override
    public void createAccount( Account account ) {
        String SQL_INSERT_ACCOUNT_USER =
                "insert into Account( User_Name, Active, Password, User_Role, Name, Address, Email, Phone )" +
                "values ( ?, 1, ?, 'USER', ?, ?, ?, ? )";
        String SQL_UPDATE_ACCOUNT_USER =
                "update Account " +
                "set User_Name = ?, Active = ?, Password = ?, User_Role = ?, Name = ?, Address = ?, Email = ?, Phone = ? " +
                "where User_Name = ?";
        String username = account.getUsername();
        Account accountTemp = null;
        accountTemp = this.fetchAccount( username );
        if ( accountTemp != null ) {
            try {
                jdbcTemplate.update( SQL_UPDATE_ACCOUNT_USER,
                        account.getUsername(),
                        account.isActive(),
                        account.getPassword(),
                        account.getUserRole(),
                        account.getName(),
                        account.getAddress(),
                        account.getEmail(),
                        account.getPhone(),
                        username );
                System.out.println("Update account :" + account + " successfully");
            } catch ( Exception ex ) {
                System.out.println("Error when update account in create account");
            }
        } else {
            try {
                jdbcTemplate.update( SQL_INSERT_ACCOUNT_USER,
                        account.getUsername(),
                        account.getPassword(),
                        account.getName(),
                        account.getAddress(),
                        account.getEmail(),
                        account.getPhone() );
                System.out.println("Create account :" + account + " successfully !");
            } catch ( Exception ex ) {
                System.out.println("Error when create Account in createAccount()");
            }
        }
    }
}
