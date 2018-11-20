package com.example.mozeeb.pengenalancryptocurrency.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseCoin{

	@SerializedName("status")
	private boolean status;

	@SerializedName("crypto")
	private List<CryptoItem> crypto;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setCrypto(List<CryptoItem> crypto){
		this.crypto = crypto;
	}

	public List<CryptoItem> getCrypto(){
		return crypto;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCoin{" + 
			"status = '" + status + '\'' + 
			",crypto = '" + crypto + '\'' + 
			"}";
		}
}