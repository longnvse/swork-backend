package com.swork.common.file.rest.internal.graphql.query.v2_0;

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

import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.resource.v2_0.FileManagerResource;

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

	public static void setFileManagerResourceComponentServiceObjects(
		ComponentServiceObjects<FileManagerResource>
			fileManagerResourceComponentServiceObjects) {

		_fileManagerResourceComponentServiceObjects =
			fileManagerResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allFileManager(parentCode: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public FileManagerPage allFileManager(
			@GraphQLName("parentCode") String parentCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> new FileManagerPage(
				fileManagerResource.getAllFileManager(parentCode)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fileManager(fileId: ___){fileId, parentCode, fileType, fileName, fileSize, mineType, metadata}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FileManager fileManager(@GraphQLName("fileId") Long fileId)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.getFileManager(fileId));
	}

	@GraphQLName("FileManagerPage")
	public class FileManagerPage {

		public FileManagerPage(Page fileManagerPage) {
			actions = fileManagerPage.getActions();

			items = fileManagerPage.getItems();
			lastPage = fileManagerPage.getLastPage();
			page = fileManagerPage.getPage();
			pageSize = fileManagerPage.getPageSize();
			totalCount = fileManagerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<FileManager> items;

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
			FileManagerResource fileManagerResource)
		throws Exception {

		fileManagerResource.setContextAcceptLanguage(_acceptLanguage);
		fileManagerResource.setContextCompany(_company);
		fileManagerResource.setContextHttpServletRequest(_httpServletRequest);
		fileManagerResource.setContextHttpServletResponse(_httpServletResponse);
		fileManagerResource.setContextUriInfo(_uriInfo);
		fileManagerResource.setContextUser(_user);
		fileManagerResource.setGroupLocalService(_groupLocalService);
		fileManagerResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FileManagerResource>
		_fileManagerResourceComponentServiceObjects;

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