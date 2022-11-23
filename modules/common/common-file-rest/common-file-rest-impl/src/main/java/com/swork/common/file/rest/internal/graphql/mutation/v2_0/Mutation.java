package com.swork.common.file.rest.internal.graphql.mutation.v2_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.resource.v2_0.FileManagerResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFileManagerResourceComponentServiceObjects(
		ComponentServiceObjects<FileManagerResource>
			fileManagerResourceComponentServiceObjects) {

		_fileManagerResourceComponentServiceObjects =
			fileManagerResourceComponentServiceObjects;
	}

	@GraphQLField
	public FileManager createFileManager(
			@GraphQLName("fileManager") FileManager fileManager)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.postFileManager(
				fileManager));
	}

	@GraphQLField
	public Response createFileManagerBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.postFileManagerBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteFileManager(@GraphQLName("fileId") Long fileId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.deleteFileManager(
				fileId));

		return true;
	}

	@GraphQLField
	public Response deleteFileManagerBatch(
			@GraphQLName("fileId") Long fileId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.deleteFileManagerBatch(
				fileId, callbackURL, object));
	}

	@GraphQLField
	public boolean deleteMediaFiles(
			@GraphQLName("parentCode") String parentCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileManagerResource -> fileManagerResource.deleteMediaFiles(
				parentCode));

		return true;
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}