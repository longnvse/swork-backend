package com.swork.common.file.rest.resource.v2_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.common.file.rest.client.dto.v2_0.FileManager;
import com.swork.common.file.rest.client.http.HttpInvoker;
import com.swork.common.file.rest.client.pagination.Page;
import com.swork.common.file.rest.client.resource.v2_0.FileManagerResource;
import com.swork.common.file.rest.client.serdes.v2_0.FileManagerSerDes;

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
public abstract class BaseFileManagerResourceTestCase {

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

		_fileManagerResource.setContextCompany(testCompany);

		FileManagerResource.Builder builder = FileManagerResource.builder();

		fileManagerResource = builder.authentication(
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
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FileManager fileManager1 = randomFileManager();

		String json = objectMapper.writeValueAsString(fileManager1);

		FileManager fileManager2 = FileManagerSerDes.toDTO(json);

		Assert.assertTrue(equals(fileManager1, fileManager2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FileManager fileManager = randomFileManager();

		String json1 = objectMapper.writeValueAsString(fileManager);
		String json2 = FileManagerSerDes.toJSON(fileManager);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		FileManager fileManager = randomFileManager();

		fileManager.setFileName(regex);
		fileManager.setFileSize(regex);
		fileManager.setFileType(regex);
		fileManager.setMineType(regex);
		fileManager.setParentCode(regex);
		fileManager.setPkType(regex);
		fileManager.setType(regex);

		String json = FileManagerSerDes.toJSON(fileManager);

		Assert.assertFalse(json.contains(regex));

		fileManager = FileManagerSerDes.toDTO(json);

		Assert.assertEquals(regex, fileManager.getFileName());
		Assert.assertEquals(regex, fileManager.getFileSize());
		Assert.assertEquals(regex, fileManager.getFileType());
		Assert.assertEquals(regex, fileManager.getMineType());
		Assert.assertEquals(regex, fileManager.getParentCode());
		Assert.assertEquals(regex, fileManager.getPkType());
		Assert.assertEquals(regex, fileManager.getType());
	}

	@Test
	public void testGetAllFileManager() throws Exception {
		Page<FileManager> page = fileManagerResource.getAllFileManager(
			RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		FileManager fileManager1 = testGetAllFileManager_addFileManager(
			randomFileManager());

		FileManager fileManager2 = testGetAllFileManager_addFileManager(
			randomFileManager());

		page = fileManagerResource.getAllFileManager(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(fileManager1, (List<FileManager>)page.getItems());
		assertContains(fileManager2, (List<FileManager>)page.getItems());
		assertValid(page);
	}

	protected FileManager testGetAllFileManager_addFileManager(
			FileManager fileManager)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostFileManager() throws Exception {
		FileManager randomFileManager = randomFileManager();

		FileManager postFileManager = testPostFileManager_addFileManager(
			randomFileManager);

		assertEquals(randomFileManager, postFileManager);
		assertValid(postFileManager);
	}

	protected FileManager testPostFileManager_addFileManager(
			FileManager fileManager)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteFileManager() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteFileManager() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetFileManager() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetFileManager() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetFileManagerNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteMediaFiles() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		FileManager fileManager, List<FileManager> fileManagers) {

		boolean contains = false;

		for (FileManager item : fileManagers) {
			if (equals(fileManager, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			fileManagers + " does not contain " + fileManager, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		FileManager fileManager1, FileManager fileManager2) {

		Assert.assertTrue(
			fileManager1 + " does not equal " + fileManager2,
			equals(fileManager1, fileManager2));
	}

	protected void assertEquals(
		List<FileManager> fileManagers1, List<FileManager> fileManagers2) {

		Assert.assertEquals(fileManagers1.size(), fileManagers2.size());

		for (int i = 0; i < fileManagers1.size(); i++) {
			FileManager fileManager1 = fileManagers1.get(i);
			FileManager fileManager2 = fileManagers2.get(i);

			assertEquals(fileManager1, fileManager2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<FileManager> fileManagers1, List<FileManager> fileManagers2) {

		Assert.assertEquals(fileManagers1.size(), fileManagers2.size());

		for (FileManager fileManager1 : fileManagers1) {
			boolean contains = false;

			for (FileManager fileManager2 : fileManagers2) {
				if (equals(fileManager1, fileManager2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				fileManagers2 + " does not contain " + fileManager1, contains);
		}
	}

	protected void assertValid(FileManager fileManager) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("fileId", additionalAssertFieldName)) {
				if (fileManager.getFileId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (fileManager.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileSize", additionalAssertFieldName)) {
				if (fileManager.getFileSize() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileType", additionalAssertFieldName)) {
				if (fileManager.getFileType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("metadata", additionalAssertFieldName)) {
				if (fileManager.getMetadata() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mineType", additionalAssertFieldName)) {
				if (fileManager.getMineType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentCode", additionalAssertFieldName)) {
				if (fileManager.getParentCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("pkType", additionalAssertFieldName)) {
				if (fileManager.getPkType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (fileManager.getType() == null) {
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

	protected void assertValid(Page<FileManager> page) {
		boolean valid = false;

		java.util.Collection<FileManager> fileManagers = page.getItems();

		int size = fileManagers.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.swork.common.file.rest.dto.v2_0.FileManager.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

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

	protected boolean equals(
		FileManager fileManager1, FileManager fileManager2) {

		if (fileManager1 == fileManager2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("fileId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getFileId(), fileManager2.getFileId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getFileName(),
						fileManager2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileSize", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getFileSize(),
						fileManager2.getFileSize())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getFileType(),
						fileManager2.getFileType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("metadata", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getMetadata(),
						fileManager2.getMetadata())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mineType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getMineType(),
						fileManager2.getMineType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getParentCode(),
						fileManager2.getParentCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("pkType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getPkType(), fileManager2.getPkType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileManager1.getType(), fileManager2.getType())) {

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

		if (!(_fileManagerResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_fileManagerResource;

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
		EntityField entityField, String operator, FileManager fileManager) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("fileId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileName")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getFileName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileSize")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getFileSize()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileType")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getFileType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("metadata")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mineType")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getMineType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentCode")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getParentCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("pkType")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getPkType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("type")) {
			sb.append("'");
			sb.append(String.valueOf(fileManager.getType()));
			sb.append("'");

			return sb.toString();
		}

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

	protected FileManager randomFileManager() throws Exception {
		return new FileManager() {
			{
				fileId = RandomTestUtil.randomLong();
				fileName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileSize = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				mineType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				parentCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				pkType = StringUtil.toLowerCase(RandomTestUtil.randomString());
				type = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected FileManager randomIrrelevantFileManager() throws Exception {
		FileManager randomIrrelevantFileManager = randomFileManager();

		return randomIrrelevantFileManager;
	}

	protected FileManager randomPatchFileManager() throws Exception {
		return randomFileManager();
	}

	protected FileManagerResource fileManagerResource;
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
		LogFactoryUtil.getLog(BaseFileManagerResourceTestCase.class);

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
	private com.swork.common.file.rest.resource.v2_0.FileManagerResource
		_fileManagerResource;

}