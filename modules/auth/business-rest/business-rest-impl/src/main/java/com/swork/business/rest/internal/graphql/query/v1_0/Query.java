package com.swork.business.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.resource.v1_0.BusinessResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Query {

	public static void setBusinessResourceComponentServiceObjects(
		ComponentServiceObjects<BusinessResource>
			businessResourceComponentServiceObjects) {

		_businessResourceComponentServiceObjects =
			businessResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {business(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the business. Results can be paginated, filtered, searched, and sorted."
	)
	public BusinessPage business(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> new BusinessPage(
				businessResource.getBusinessPage(
					search,
					_filterBiFunction.apply(businessResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(businessResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {business(businessId: ___){externalReferenceCode, id, name, customerName, email, phoneNumber, businessAddress, fieldOperations, status, logoId, userAdmin}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get an Business")
	public Business business(@GraphQLName("businessId") Long businessId)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.getBusiness(businessId));
	}

	@GraphQLName("BusinessPage")
	public class BusinessPage {

		public BusinessPage(Page businessPage) {
			actions = businessPage.getActions();

			items = businessPage.getItems();
			lastPage = businessPage.getLastPage();
			page = businessPage.getPage();
			pageSize = businessPage.getPageSize();
			totalCount = businessPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Business> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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

	private void _populateResourceContext(BusinessResource businessResource)
		throws Exception {

		businessResource.setContextAcceptLanguage(_acceptLanguage);
		businessResource.setContextCompany(_company);
		businessResource.setContextHttpServletRequest(_httpServletRequest);
		businessResource.setContextHttpServletResponse(_httpServletResponse);
		businessResource.setContextUriInfo(_uriInfo);
		businessResource.setContextUser(_user);
		businessResource.setGroupLocalService(_groupLocalService);
		businessResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<BusinessResource>
		_businessResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}