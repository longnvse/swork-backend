package com.swork.auth.login.rest.client.dto.v1_0;

import com.swork.auth.login.rest.client.function.UnsafeSupplier;
import com.swork.auth.login.rest.client.serdes.v1_0.CredentialSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Credential implements Cloneable, Serializable {

	public static Credential toDTO(String json) {
		return CredentialSerDes.toDTO(json);
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

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountId(
		UnsafeSupplier<Long, Exception> accountIdUnsafeSupplier) {

		try {
			accountId = accountIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long accountId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(
		UnsafeSupplier<String, Exception> passwordUnsafeSupplier) {

		try {
			password = passwordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String password;

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

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public void setRememberMe(
		UnsafeSupplier<Boolean, Exception> rememberMeUnsafeSupplier) {

		try {
			rememberMe = rememberMeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean rememberMe;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUsername(
		UnsafeSupplier<String, Exception> usernameUnsafeSupplier) {

		try {
			username = usernameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String username;

	@Override
	public Credential clone() throws CloneNotSupportedException {
		return (Credential)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Credential)) {
			return false;
		}

		Credential credential = (Credential)object;

		return Objects.equals(toString(), credential.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CredentialSerDes.toJSON(this);
	}

}