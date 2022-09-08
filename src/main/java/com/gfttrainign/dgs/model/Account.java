package com.gfttrainign.dgs.model;

import java.util.List;

import com.netflix.graphql.dgs.DgsComponent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
	private String iban;
	private float balance;
	private List<Transaction> lastTransactions;
	private List<Operation> operations;
}
