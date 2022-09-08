package com.gfttrainign.dgs.data;

import java.util.List;
import java.util.stream.Collectors;

import com.gfttrainign.dgs.model.Account;
import com.gfttrainign.dgs.model.Operation;
import com.gfttrainign.dgs.model.Transaction;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class AccountData {
	private final List<Account> listAccounts = List.of(
			new Account("2980137782361",854.52f,
				List.of(
					new Transaction("1","The Old Town Pharmacy","07/09/2022",41.72f)
				), 
				List.of(
					new Operation("1","Send","https://mockicon.jpg")
				)
			),
			new Account("2980137782362",84.52f,
				List.of(
					new Transaction("2","The power gas station","07/09/2022",76.62f)
				), 
				List.of(
					new Operation("1","Send","https://mockicon.jpg")
				)
			),
			new Account("2980137782363",2341.52f,
			List.of(
				new Transaction("1","Speedy internet service","07/09/2022",38.72f)
			), 
			List.of(
				new Operation("1","Send","https://mockicon.jpg")
			)
		)
			
	);
	
	
	
	public List<Account> getListAccounts() {
		return listAccounts;
	}
}
