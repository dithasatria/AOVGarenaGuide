package com.example.android.aovgarenaguide.model.select_hero.detail_hero;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResultItemDetailHero implements Parcelable {

	@SerializedName("id_hero")
	private String idHero;

	@SerializedName("img_backdrop")
	private String imgBackdrop;

	@SerializedName("id_skin_hero")
	private String idSkinHero;

	@SerializedName("initial_hero")
	private String initialHero;

	@SerializedName("price_gold_hero")
	private String priceGoldHero;

	@SerializedName("price_voucher_hero")
	private String priceVoucherHero;

	public void setIdHero(String idHero){
		this.idHero = idHero;
	}

	public String getIdHero(){
		return idHero;
	}

	public void setImgBackdrop(String imgBackdrop){
		this.imgBackdrop = imgBackdrop;
	}

	public String getImgBackdrop(){
		return imgBackdrop;
	}

	public void setIdSkinHero(String idSkinHero){
		this.idSkinHero = idSkinHero;
	}

	public String getIdSkinHero(){
		return idSkinHero;
	}

	public void setInitialHero(String initialHero){
		this.initialHero = initialHero;
	}

	public String getInitialHero(){
		return initialHero;
	}

	public void setPriceGoldHero(String priceGoldHero){
		this.priceGoldHero = priceGoldHero;
	}

	public String getPriceGoldHero(){
		return priceGoldHero;
	}

	public void setPriceVoucherHero(String priceVoucherHero){
		this.priceVoucherHero = priceVoucherHero;
	}

	public String getPriceVoucherHero(){
		return priceVoucherHero;
	}

	@Override
 	public String toString(){
		return 
			"ResultItemDetailHero{" +
			"id_hero = '" + idHero + '\'' + 
			",img_backdrop = '" + imgBackdrop + '\'' + 
			",id_skin_hero = '" + idSkinHero + '\'' + 
			",initial_hero = '" + initialHero + '\'' + 
			",price_gold_hero = '" + priceGoldHero + '\'' + 
			",price_voucher_hero = '" + priceVoucherHero + '\'' + 
			"}";
		}

	public ResultItemDetailHero() {
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.idHero);
		dest.writeString(this.imgBackdrop);
		dest.writeString(this.idSkinHero);
		dest.writeString(this.initialHero);
		dest.writeString(this.priceGoldHero);
		dest.writeString(this.priceVoucherHero);
	}

	protected ResultItemDetailHero(Parcel in) {
		this.idHero = in.readString();
		this.imgBackdrop = in.readString();
		this.idSkinHero = in.readString();
		this.initialHero = in.readString();
		this.priceGoldHero = in.readString();
		this.priceVoucherHero = in.readString();
	}

	public static final Parcelable.Creator<ResultItemDetailHero> CREATOR = new Parcelable.Creator<ResultItemDetailHero>() {
		@Override
		public ResultItemDetailHero createFromParcel(Parcel source) {
			return new ResultItemDetailHero(source);
		}

		@Override
		public ResultItemDetailHero[] newArray(int size) {
			return new ResultItemDetailHero[size];
		}
	};
}