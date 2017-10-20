package com.example.android.aovgarenaguide.model.select_hero;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseSelectHero {

	@SerializedName("result")
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"APIResponseSelectHero{" +
			"result = '" + result + '\'' + 
			"}";
		}

	public APIResponseSelectHero() {
	}
}