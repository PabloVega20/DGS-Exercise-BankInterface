package com.gfttrainign.dgs.datafetcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gfttrainign.dgs.data.AccountData;
import com.gfttrainign.dgs.data.PromoData;
import com.gfttrainign.dgs.model.Account;
import com.gfttrainign.dgs.model.Customer;
import com.gfttrainign.dgs.model.CustomerComplete;
import com.gfttrainign.dgs.model.Operation;
import com.gfttrainign.dgs.model.Promo;
import com.gfttrainign.dgs.model.Transaction;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class CustomerDataFetcher {
	private final List<Customer> listCustomers = List.of(
		new Customer("1","@pablovegaroca","Pablo Vega",
			List.of("2980137782361"),
			List.of("1","2")
		),
		
		new Customer("2","@jantonlucci","Javier Antolucci",
			List.of("2980137782362"),
			List.of("2")
		),
		new Customer("3","@guillepaton","Guillermo Patón",
			List.of("2980137782363"),
			List.of("1","2")
		)					
	);
	
	@DgsQuery
	public CustomerComplete customer(@InputArgument String id){
		CustomerComplete finalCustomer = new CustomerComplete();
		
		Customer c = listCustomers.stream().filter(ca->ca.getId().equals(id)).reduce((a, b) -> {
            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
        })
        .get();
		
		finalCustomer.setId(c.getId());
		finalCustomer.setAlias(c.getAlias());
		finalCustomer.setName(c.getName());
		//GETTING ACCOUNTS 
		List<String> accounts = Stream.of(c).map(Customer::getAccounts).flatMap(List::stream).collect(Collectors.toList());
		
		List<Account> accList = new ArrayList<Account>();
		for(String acc: accounts) {
			Account accountByIban = adf.getListAccounts().stream().filter(a->a.getIban().equals(acc)).reduce((a, b) -> {
	            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
	        })
	        .get();
			
			accList.add(accountByIban);
		}
		
		finalCustomer.setAccounts(accList);
		
		//GETTING PROMOS
		List<String> promos = Stream.of(c).map(Customer::getPromos).flatMap(List::stream).collect(Collectors.toList());
		List<Promo> promoList = new ArrayList<Promo>();
		for(String pr: promos) {
			Promo promoById = pdf.getListPromo().stream().filter(a->a.getId().equals(pr)).reduce((a, b) -> {
	            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
	        })
	        .get();
			
			promoList.add(promoById);
		}
		
		finalCustomer.setPromos(promoList);
		
		return finalCustomer;
	}
	
	@DgsQuery
	public List<CustomerComplete> customers() {
		List<CustomerComplete> listCustomerComplete = new ArrayList<CustomerComplete>();
		
		for(Customer c: listCustomers) {
		CustomerComplete finalCustomer = new CustomerComplete();
		finalCustomer.setId(c.getId());
		finalCustomer.setAlias(c.getAlias());
		finalCustomer.setName(c.getName());
		//GETTING ACCOUNTS 
		List<String> accounts = Stream.of(c).map(Customer::getAccounts).flatMap(List::stream).collect(Collectors.toList());
		
		List<Account> accList = new ArrayList<Account>();
		for(String acc: accounts) {
			Account accountByIban = adf.getListAccounts().stream().filter(a->a.getIban().equals(acc)).reduce((a, b) -> {
	            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
	        })
	        .get();
			
			accList.add(accountByIban);
		}
		
		finalCustomer.setAccounts(accList);
		
		//GETTING PROMOS
		List<String> promos = Stream.of(c).map(Customer::getPromos).flatMap(List::stream).collect(Collectors.toList());
		List<Promo> promoList = new ArrayList<Promo>();
		for(String pr: promos) {
			Promo promoById = pdf.getListPromo().stream().filter(a->a.getId().equals(pr)).reduce((a, b) -> {
	            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
	        })
	        .get();
			
			promoList.add(promoById);
		}
		
		finalCustomer.setPromos(promoList);
		listCustomerComplete.add(finalCustomer);
		}
		
		return listCustomerComplete;
	}
	
	AccountData adf = new AccountData();
	PromoData pdf = new PromoData();
}
