package com.design.patterns.factory;

public class Shop extends Website {


	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}

}
