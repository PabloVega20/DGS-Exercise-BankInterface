package com.gfttrainign.dgs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private String id,alias,name;
	private List<String> accounts;
	private List<String> promos;
}
