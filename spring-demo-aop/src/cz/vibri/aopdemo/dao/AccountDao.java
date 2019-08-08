package cz.vibri.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDOING AN ACCOUNT");
	}
}
