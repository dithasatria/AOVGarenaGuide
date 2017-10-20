package com.example.android.aovgarenaguide.model.select_hero.detail_hero;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseDetailHero{

	@SerializedName("result")
	private List<ResultItemDetailHero> result;

	public void setResult(List<ResultItemDetailHero> result){
		this.result = result;
	}

	public List<ResultItemDetailHero> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"APIResponseDetailHero{" + 
			"result = '" + result + '\'' + 
			"}";
		}

	public APIResponseDetailHero() {
	}
}