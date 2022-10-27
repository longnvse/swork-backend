package com.swork.account.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.AccountPermision;
import com.swork.account.rest.resource.v1_0.AccountPermisionResource;
import com.swork.account.rest.resource.v1_0.AccountResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setAccountResourceComponentServiceObjects(
		ComponentServiceObjects<AccountResource>
			accountResourceComponentServiceObjects) {

		_accountResourceComponentServiceObjects =
			accountResourceComponentServiceObjects;
	}

	public static void setAccountPermisionResourceComponentServiceObjects(
		ComponentServiceObjects<AccountPermisionResource>
			accountPermisionResourceComponentServiceObjects) {

		_accountPermisionResourceComponentServiceObjects =
			accountPermisionResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Account")
	public Account createAccount(@GraphQLName("account") Account account)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.postAccount(account));
	}

	@GraphQLField
	public Response createAccountBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.postAccountBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete an account")
	public boolean deleteAccount(@GraphQLName("accountId") Long accountId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.deleteAccount(accountId));

		return true;
	}

	@GraphQLField
	public Response deleteAccountBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.deleteAccountBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update an Account")
	public Account updateAccount(
			@GraphQLName("accountId") Long accountId,
			@GraphQLName("account") Account account)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.putAccount(accountId, account));
	}

	@GraphQLField
	public Response updateAccountBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountResource -> accountResource.putAccountBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new AccountPermision")
	public AccountPermision createAccountPermision(
			@GraphQLName("accountPermision") AccountPermision accountPermision)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountPermisionResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountPermisionResource ->
				accountPermisionResource.postAccountPermision(
					accountPermision));
	}

	@GraphQLField
	public Response createAccountPermisionBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountPermisionResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountPermisionResource ->
				accountPermisionResource.postAccountPermisionBatch(
					callbackURL, object));
	}

	@GraphQLField(description = "Delete an accountPermision")
	public boolean deleteAccountPermision(
			@GraphQLName("accountPermisionId") Long accountPermisionId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_accountPermisionResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountPermisionResource ->
				accountPermisionResource.deleteAccountPermision(
					accountPermisionId));

		return true;
	}

	@GraphQLField
	public Response deleteAccountPermisionBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_accountPermisionResourceComponentServiceObjects,
			this::_populateResourceContext,
			accountPermisionResource ->
				accountPermisionResource.deleteAccountPermisionBatch(
					callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AccountResource accountResource)
		throws Exception {

		accountResource.setContextAcceptLanguage(_acceptLanguage);
		accountResource.setContextCompany(_company);
		accountResource.setContextHttpServletRequest(_httpServletRequest);
		accountResource.setContextHttpServletResponse(_httpServletResponse);
		accountResource.setContextUriInfo(_uriInfo);
		accountResource.setContextUser(_user);
		accountResource.setGroupLocalService(_groupLocalService);
		accountResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			AccountPermisionResource accountPermisionResource)
		throws Exception {

		accountPermisionResource.setContextAcceptLanguage(_acceptLanguage);
		accountPermisionResource.setContextCompany(_company);
		accountPermisionResource.setContextHttpServletRequest(
			_httpServletRequest);
		accountPermisionResource.setContextHttpServletResponse(
			_httpServletResponse);
		accountPermisionResource.setContextUriInfo(_uriInfo);
		accountPermisionResource.setContextUser(_user);
		accountPermisionResource.setGroupLocalService(_groupLocalService);
		accountPermisionResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AccountResource>
		_accountResourceComponentServiceObjects;
	private static ComponentServiceObjects<AccountPermisionResource>
		_accountPermisionResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}