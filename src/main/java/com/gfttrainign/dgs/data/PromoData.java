package com.gfttrainign.dgs.data;

import java.util.List;

import com.gfttrainign.dgs.model.Promo;


public class PromoData {
	private final List<Promo> listPromo = List.of(
			new Promo("1","Saving Account","Get up to 10% monthly interested"),
			new Promo("2","Increment Account","Get up to 10% more money on your account")		
	);
	
	
	
	public List<Promo> getListPromo() {
		return listPromo;
	}
}
