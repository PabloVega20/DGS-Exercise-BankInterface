package com.gfttrainign.dgs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerComplete {
	private String id,alias,name;
	private List<Account> accounts;
	private List<Promo> promos;
}
