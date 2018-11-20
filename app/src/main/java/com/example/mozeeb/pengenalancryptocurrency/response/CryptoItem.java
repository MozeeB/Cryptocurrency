package com.example.mozeeb.pengenalancryptocurrency.response;

import com.google.gson.annotations.SerializedName;

public class CryptoItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("id")
	private String id;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("isi")
	private String isi;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setIsi(String isi){
		this.isi = isi;
	}

	public String getIsi(){
		return isi;
	}

	@Override
 	public String toString(){
		return 
			"CryptoItem{" + 
			"nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			",gambar = '" + gambar + '\'' + 
			",isi = '" + isi + '\'' + 
			"}";
		}
}