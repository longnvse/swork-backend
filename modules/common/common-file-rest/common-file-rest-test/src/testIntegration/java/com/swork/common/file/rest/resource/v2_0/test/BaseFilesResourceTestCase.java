package com.swork.common.file.rest.resource.v2_0.test;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.common.file.rest.client.dto.v2_0.FileData;
import com.swork.common.file.rest.client.dto.v2_0.FileRes;
import com.swork.common.file.rest.client.dto.v2_0.FileUpdate;
import com.swork.common.file.rest.client.http.HttpInvoker;
import com.swork.common.file.rest.client.pagination.Page;
import com.swork.common.file.rest.client.resource.v2_0.FilesResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public abstract class BaseFilesResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_filesResource.setContextCompany(testCompany);

		FilesResource.Builder builder = FilesResource.builder();

		filesResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testPostFile() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testUpdateFile() throws Exception {
		Files postFiles = testPutFiles_addFiles();

		testUpdateFile_addFileUpdate(postFiles.getId(), randomFileUpdate());

		FileUpdate randomFileUpdate = randomFileUpdate();

		FileUpdate putFileUpdate = filesResource.updateFile(
			null, randomFileUpdate);

		assertEquals(randomFileUpdate, putFileUpdate);
		assertValid(putFileUpdate);
	}

	protected FileUpdate testUpdateFile_addFileUpdate(
			long filesId, FileUpdate fileUpdate)
		throws Exception {

		return filesResource.updateFile(filesId, fileUpdate);
	}

	@Test
	public void testGetFileById() throws Exception {
		Files postFiles = testGetFiles_addFiles();

		FileData postFileData = testGetFileById_addFileData(
			postFiles.getId(), randomFileData());

		FileData getFileData = filesResource.getFileById(postFiles.getId());

		assertEquals(postFileData, getFileData);
		assertValid(getFileData);
	}

	protected FileData testGetFileById_addFileData(
			long filesId, FileData fileData)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Object files, List<Object> fileses) {
		boolean contains = false;

		for (Object item : fileses) {
			if (equals(files, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(fileses + " does not contain " + files, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object files1, Object files2) {
		Assert.assertTrue(
			files1 + " does not equal " + files2, equals(files1, files2));
	}

	protected void assertEquals(List<Object> fileses1, List<Object> fileses2) {
		Assert.assertEquals(fileses1.size(), fileses2.size());

		for (int i = 0; i < fileses1.size(); i++) {
			Object files1 = fileses1.get(i);
			Object files2 = fileses2.get(i);

			assertEquals(files1, files2);
		}
	}

	protected void assertEquals(FileRes fileRes1, FileRes fileRes2) {
		Assert.assertTrue(
			fileRes1 + " does not equal " + fileRes2,
			equals(fileRes1, fileRes2));
	}

	protected void assertEquals(
		FileUpdate fileUpdate1, FileUpdate fileUpdate2) {

		Assert.assertTrue(
			fileUpdate1 + " does not equal " + fileUpdate2,
			equals(fileUpdate1, fileUpdate2));
	}

	protected void assertEquals(FileData fileData1, FileData fileData2) {
		Assert.assertTrue(
			fileData1 + " does not equal " + fileData2,
			equals(fileData1, fileData2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> fileses1, List<Object> fileses2) {

		Assert.assertEquals(fileses1.size(), fileses2.size());

		for (Object files1 : fileses1) {
			boolean contains = false;

			for (Object files2 : fileses2) {
				if (equals(files1, files2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				fileses2 + " does not contain " + files1, contains);
		}
	}

	protected void assertValid(Object files) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> fileses = page.getItems();

		int size = fileses.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(FileRes fileRes) {
		boolean valid = true;

		if (fileRes.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalFileResAssertFieldNames()) {

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (fileRes.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileSize", additionalAssertFieldName)) {
				if (fileRes.getFileSize() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("metadata", additionalAssertFieldName)) {
				if (fileRes.getMetadata() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mimeType", additionalAssertFieldName)) {
				if (fileRes.getMimeType() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(FileUpdate fileUpdate) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalFileUpdateAssertFieldNames()) {

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (fileUpdate.getSize() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("url", additionalAssertFieldName)) {
				if (fileUpdate.getUrl() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(FileData fileData) {
		boolean valid = true;

		if (fileData.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalFileDataAssertFieldNames()) {

			if (Objects.equals("data", additionalAssertFieldName)) {
				if (fileData.getData() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("documentType", additionalAssertFieldName)) {
				if (fileData.getDocumentType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileType", additionalAssertFieldName)) {
				if (fileData.getFileType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("key", additionalAssertFieldName)) {
				if (fileData.getKey() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (fileData.getSize() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (fileData.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (fileData.getType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("url", additionalAssertFieldName)) {
				if (fileData.getUrl() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalFileResAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalFileUpdateAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalFileDataAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Object files1, Object files2) {
		if (files1 == files2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(FileRes fileRes1, FileRes fileRes2) {
		if (fileRes1 == fileRes2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalFileResAssertFieldNames()) {

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRes1.getFileName(), fileRes2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileSize", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRes1.getFileSize(), fileRes2.getFileSize())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(fileRes1.getId(), fileRes2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("metadata", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRes1.getMetadata(), fileRes2.getMetadata())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mimeType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRes1.getMimeType(), fileRes2.getMimeType())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(FileUpdate fileUpdate1, FileUpdate fileUpdate2) {
		if (fileUpdate1 == fileUpdate2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalFileUpdateAssertFieldNames()) {

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileUpdate1.getSize(), fileUpdate2.getSize())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("url", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileUpdate1.getUrl(), fileUpdate2.getUrl())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(FileData fileData1, FileData fileData2) {
		if (fileData1 == fileData2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalFileDataAssertFieldNames()) {

			if (Objects.equals("data", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getData(), fileData2.getData())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("documentType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getDocumentType(),
						fileData2.getDocumentType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getFileType(), fileData2.getFileType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(fileData1.getId(), fileData2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("key", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getKey(), fileData2.getKey())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getSize(), fileData2.getSize())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getTitle(), fileData2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getType(), fileData2.getType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("url", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileData1.getUrl(), fileData2.getUrl())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_filesResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_filesResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object files) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected FileRes randomFileRes() throws Exception {
		return new FileRes() {
			{
				fileName = RandomTestUtil.randomString();
				fileSize = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				mimeType = RandomTestUtil.randomString();
			}
		};
	}

	protected FileUpdate randomFileUpdate() throws Exception {
		return new FileUpdate() {
			{
				size = RandomTestUtil.randomLong();
				url = RandomTestUtil.randomString();
			}
		};
	}

	protected FileData randomFileData() throws Exception {
		return new FileData() {
			{
				data = RandomTestUtil.randomString();
				documentType = RandomTestUtil.randomString();
				fileType = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				key = RandomTestUtil.randomString();
				size = RandomTestUtil.randomLong();
				title = RandomTestUtil.randomString();
				type = RandomTestUtil.randomString();
				url = RandomTestUtil.randomString();
			}
		};
	}

	protected FilesResource filesResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseFilesResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.swork.common.file.rest.resource.v2_0.FilesResource
		_filesResource;

}