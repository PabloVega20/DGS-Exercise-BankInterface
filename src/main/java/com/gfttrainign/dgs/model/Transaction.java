package com.gfttrainign.dgs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
	private String category,description,date;
	private float amount;
}
