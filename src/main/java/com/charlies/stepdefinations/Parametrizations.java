package com.charlies.stepdefinations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parametrizations {
	
	private int i,j,r =0;
	
	@Given("I have two numbers {int} & {int}")
	public void i_have_two_numbers(int i, int j) {
		this.i=i;
		this.j=j;
	    System.out.println("First no is:"+ i);
	    System.out.println("Second no is:" + j);
	}

	@When("I add them")
	public void i_add_them() {
		r = i+j; 
	}

	@Then("I should get result to be prime no.")
	public void i_should_get_result_to_be_prime_no() {
		if(r%2==0) 
		{
			System.out.println("Result is prime:" + r);
		}
		else
		{
			System.out.println("Result is not prime:" + r);
		}
	}
		@Given("I have number {int}")
		public void acceptingOneNumber(int x) {
			System.out.println(x);
		}
		
		@Given("I have name {string}")
		public void acceptingString(String s) {
			System.out.println(s);

		}
		
		@Given("I have a <RTO_Codes> and <State_name>")
		public void acceptRTOCode(DataTable dt) {
			Map rto_codes =dt.asMap();
			Set<Entry>state_info=rto_codes.entrySet();
			for(Entry e:state_info) 
			{
				System.out.println(e.getKey()+":"+e.getValue());
			}
		}
		
		@Given("I have list of {word} and {word}")
		public void I_have_list_of_rtocode_And_statename(String rtocodes, String statenames) {
			System.out.println(rtocodes); 
			System.out.println(statenames);


		}
}	
