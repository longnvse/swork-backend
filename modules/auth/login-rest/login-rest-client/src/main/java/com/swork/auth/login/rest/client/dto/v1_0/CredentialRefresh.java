package com.swork.auth.login.rest.client.dto.v1_0;

import com.swork.auth.login.rest.client.function.UnsafeSupplier;
import com.swork.auth.login.rest.client.serdes.v1_0.CredentialRefreshSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class CredentialRefresh implements Cloneable, Serializable {

	public static CredentialRefresh toDTO(String json) {
		return CredentialRefreshSerDes.toDTO(json);
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setAccessToken(
		UnsafeSupplier<String, Exception> accessTokenUnsafeSupplier) {

		try {
			accessToken = accessTokenUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String accessToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public void setRefreshToken(
		UnsafeSupplier<String, Exception> refreshTokenUnsafeSupplier) {

		try {
			refreshToken = refreshTokenUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String refreshToken;

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public void setTokenType(
		UnsafeSupplier<String, Exception> tokenTypeUnsafeSupplier) {

		try {
			tokenType = tokenTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String tokenType;

	@Override
	public CredentialRefresh clone() throws CloneNotSupportedException {
		return (CredentialRefresh)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CredentialRefresh)) {
			return false;
		}

		CredentialRefresh credentialRefresh = (CredentialRefresh)object;

		return Objects.equals(toString(), credentialRefresh.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CredentialRefreshSerDes.toJSON(this);
	}

}