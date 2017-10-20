package com.example.android.aovgarenaguide.model.select_hero;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResultItem implements Parcelable {

	@SerializedName("id_hero")
	private String idHero;

	@SerializedName("pertahanan_hero")
	private String pertahananHero;

	@SerializedName("hero_name")
	private String heroName;

	@SerializedName("role_hero")
	private String roleHero;

	@SerializedName("img_hero")
	private String imgHero;

	@SerializedName("serangan_hero")
	private String seranganHero;

	@SerializedName("story_hero")
	private String storyHero;

	@SerializedName("efek_skill_hero")
	private String efekSkillHero;

	@SerializedName("kesulitan_hero")
	private String kesulitanHero;

	public void setIdHero(String idHero){
		this.idHero = idHero;
	}

	public String getIdHero(){
		return idHero;
	}

	public void setPertahananHero(String pertahananHero){
		this.pertahananHero = pertahananHero;
	}

	public String getPertahananHero(){
		return pertahananHero;
	}

	public void setHeroName(String heroName){
		this.heroName = heroName;
	}

	public String getHeroName(){
		return heroName;
	}

	public void setRoleHero(String roleHero){
		this.roleHero = roleHero;
	}

	public String getRoleHero(){
		return roleHero;
	}

	public void setImgHero(String imgHero){
		this.imgHero = imgHero;
	}

	public String getImgHero(){
		return imgHero;
	}

	public void setSeranganHero(String seranganHero){
		this.seranganHero = seranganHero;
	}

	public String getSeranganHero(){
		return seranganHero;
	}

	public void setStoryHero(String storyHero){
		this.storyHero = storyHero;
	}

	public String getStoryHero(){
		return storyHero;
	}

	public void setEfekSkillHero(String efekSkillHero){
		this.efekSkillHero = efekSkillHero;
	}

	public String getEfekSkillHero(){
		return efekSkillHero;
	}

	public void setKesulitanHero(String kesulitanHero){
		this.kesulitanHero = kesulitanHero;
	}

	public String getKesulitanHero(){
		return kesulitanHero;
	}

	@Override
 	public String toString(){
		return 
			"ResultItemDetailHero{" +
			"id_hero = '" + idHero + '\'' + 
			",pertahanan_hero = '" + pertahananHero + '\'' + 
			",hero_name = '" + heroName + '\'' + 
			",role_hero = '" + roleHero + '\'' + 
			",img_hero = '" + imgHero + '\'' + 
			",serangan_hero = '" + seranganHero + '\'' + 
			",story_hero = '" + storyHero + '\'' + 
			",efek_skill_hero = '" + efekSkillHero + '\'' + 
			",kesulitan_hero = '" + kesulitanHero + '\'' + 
			"}";
		}

	public ResultItem() {
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.idHero);
		dest.writeString(this.pertahananHero);
		dest.writeString(this.heroName);
		dest.writeString(this.roleHero);
		dest.writeString(this.imgHero);
		dest.writeString(this.seranganHero);
		dest.writeString(this.storyHero);
		dest.writeString(this.efekSkillHero);
		dest.writeString(this.kesulitanHero);
	}

	protected ResultItem(Parcel in) {
		this.idHero = in.readString();
		this.pertahananHero = in.readString();
		this.heroName = in.readString();
		this.roleHero = in.readString();
		this.imgHero = in.readString();
		this.seranganHero = in.readString();
		this.storyHero = in.readString();
		this.efekSkillHero = in.readString();
		this.kesulitanHero = in.readString();
	}

	public static final Parcelable.Creator<ResultItem> CREATOR = new Parcelable.Creator<ResultItem>() {
		@Override
		public ResultItem createFromParcel(Parcel source) {
			return new ResultItem(source);
		}

		@Override
		public ResultItem[] newArray(int size) {
			return new ResultItem[size];
		}
	};
}