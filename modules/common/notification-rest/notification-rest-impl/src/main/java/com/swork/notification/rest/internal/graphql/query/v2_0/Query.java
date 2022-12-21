package com.swork.notification.rest.internal.graphql.query.v2_0;

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

import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.dto.v2_0.NotificationNew;
import com.swork.notification.rest.resource.v2_0.NotificationNewResource;
import com.swork.notification.rest.resource.v2_0.NotificationResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Query {

	public static void setNotificationResourceComponentServiceObjects(
		ComponentServiceObjects<NotificationResource>
			notificationResourceComponentServiceObjects) {

		_notificationResourceComponentServiceObjects =
			notificationResourceComponentServiceObjects;
	}

	public static void setNotificationNewResourceComponentServiceObjects(
		ComponentServiceObjects<NotificationNewResource>
			notificationNewResourceComponentServiceObjects) {

		_notificationNewResourceComponentServiceObjects =
			notificationNewResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {countNotification(category: ___, status: ___){}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Integer countNotification(
			@GraphQLName("category") String category,
			@GraphQLName("status") String status)
		throws Exception {

		return _applyComponentServiceObjects(
			_notificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationResource -> notificationResource.getCountNotification(
				category, status));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {notification(category: ___, page: ___, pageSize: ___, status: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public NotificationPage notification(
			@GraphQLName("category") String category,
			@GraphQLName("status") String status,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_notificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationResource -> new NotificationPage(
				notificationResource.getNotification(
					category, status, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {notificationNew{count, totalTime}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public NotificationNew notificationNew() throws Exception {
		return _applyComponentServiceObjects(
			_notificationNewResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationNewResource ->
				notificationNewResource.getNotificationNew());
	}

	@GraphQLName("NotificationPage")
	public class NotificationPage {

		public NotificationPage(Page notificationPage) {
			actions = notificationPage.getActions();

			items = notificationPage.getItems();
			lastPage = notificationPage.getLastPage();
			page = notificationPage.getPage();
			pageSize = notificationPage.getPageSize();
			totalCount = notificationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Notification> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("NotificationNewPage")
	public class NotificationNewPage {

		public NotificationNewPage(Page notificationNewPage) {
			actions = notificationNewPage.getActions();

			items = notificationNewPage.getItems();
			lastPage = notificationNewPage.getLastPage();
			page = notificationNewPage.getPage();
			pageSize = notificationNewPage.getPageSize();
			totalCount = notificationNewPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<NotificationNew> items;

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

	private void _populateResourceContext(
			NotificationResource notificationResource)
		throws Exception {

		notificationResource.setContextAcceptLanguage(_acceptLanguage);
		notificationResource.setContextCompany(_company);
		notificationResource.setContextHttpServletRequest(_httpServletRequest);
		notificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		notificationResource.setContextUriInfo(_uriInfo);
		notificationResource.setContextUser(_user);
		notificationResource.setGroupLocalService(_groupLocalService);
		notificationResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			NotificationNewResource notificationNewResource)
		throws Exception {

		notificationNewResource.setContextAcceptLanguage(_acceptLanguage);
		notificationNewResource.setContextCompany(_company);
		notificationNewResource.setContextHttpServletRequest(
			_httpServletRequest);
		notificationNewResource.setContextHttpServletResponse(
			_httpServletResponse);
		notificationNewResource.setContextUriInfo(_uriInfo);
		notificationNewResource.setContextUser(_user);
		notificationNewResource.setGroupLocalService(_groupLocalService);
		notificationNewResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<NotificationResource>
		_notificationResourceComponentServiceObjects;
	private static ComponentServiceObjects<NotificationNewResource>
		_notificationNewResourceComponentServiceObjects;

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