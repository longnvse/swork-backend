package com.swork.notification.rest.resource.v2_0.test;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.notification.rest.client.dto.v2_0.Notification;
import com.swork.notification.rest.client.http.HttpInvoker;
import com.swork.notification.rest.client.pagination.Page;
import com.swork.notification.rest.client.pagination.Pagination;
import com.swork.notification.rest.client.resource.v2_0.NotificationResource;
import com.swork.notification.rest.client.serdes.v2_0.NotificationSerDes;

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
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public abstract class BaseNotificationResourceTestCase {

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

		_notificationResource.setContextCompany(testCompany);

		NotificationResource.Builder builder = NotificationResource.builder();

		notificationResource = builder.authentication(
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

		Notification notification1 = randomNotification();

		String json = objectMapper.writeValueAsString(notification1);

		Notification notification2 = NotificationSerDes.toDTO(json);

		Assert.assertTrue(equals(notification1, notification2));
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

		Notification notification = randomNotification();

		String json1 = objectMapper.writeValueAsString(notification);
		String json2 = NotificationSerDes.toJSON(notification);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Notification notification = randomNotification();

		notification.setCategory(regex);
		notification.setDescription(regex);
		notification.setExternalReferenceCode(regex);
		notification.setName(regex);
		notification.setReceiverName(regex);
		notification.setSubjectName(regex);

		String json = NotificationSerDes.toJSON(notification);

		Assert.assertFalse(json.contains(regex));

		notification = NotificationSerDes.toDTO(json);

		Assert.assertEquals(regex, notification.getCategory());
		Assert.assertEquals(regex, notification.getDescription());
		Assert.assertEquals(regex, notification.getExternalReferenceCode());
		Assert.assertEquals(regex, notification.getName());
		Assert.assertEquals(regex, notification.getReceiverName());
		Assert.assertEquals(regex, notification.getSubjectName());
	}

	@Test
	public void testGetCountNotification() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetNotification() throws Exception {
		Page<Notification> page = notificationResource.getNotification(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		Notification notification1 = testGetNotification_addNotification(
			randomNotification());

		Notification notification2 = testGetNotification_addNotification(
			randomNotification());

		page = notificationResource.getNotification(
			null, null, Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(notification1, (List<Notification>)page.getItems());
		assertContains(notification2, (List<Notification>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetNotificationWithPagination() throws Exception {
		Page<Notification> totalPage = notificationResource.getNotification(
			null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Notification notification1 = testGetNotification_addNotification(
			randomNotification());

		Notification notification2 = testGetNotification_addNotification(
			randomNotification());

		Notification notification3 = testGetNotification_addNotification(
			randomNotification());

		Page<Notification> page1 = notificationResource.getNotification(
			null, null, Pagination.of(1, totalCount + 2));

		List<Notification> notifications1 =
			(List<Notification>)page1.getItems();

		Assert.assertEquals(
			notifications1.toString(), totalCount + 2, notifications1.size());

		Page<Notification> page2 = notificationResource.getNotification(
			null, null, Pagination.of(2, totalCount + 2));

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Notification> notifications2 =
			(List<Notification>)page2.getItems();

		Assert.assertEquals(
			notifications2.toString(), 1, notifications2.size());

		Page<Notification> page3 = notificationResource.getNotification(
			null, null, Pagination.of(1, totalCount + 3));

		assertContains(notification1, (List<Notification>)page3.getItems());
		assertContains(notification2, (List<Notification>)page3.getItems());
		assertContains(notification3, (List<Notification>)page3.getItems());
	}

	protected Notification testGetNotification_addNotification(
			Notification notification)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testApprovalAllStatusByReceiver() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Notification notification =
			testApprovalAllStatusByReceiver_addNotification();

		assertHttpResponseStatusCode(
			204,
			notificationResource.approvalAllStatusByReceiverHttpResponse(
				notification.getReceiverId(), notification));

		assertHttpResponseStatusCode(
			404,
			notificationResource.approvalAllStatusByReceiverHttpResponse(
				notification.getReceiverId(), notification));
	}

	protected Notification testApprovalAllStatusByReceiver_addNotification()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testApprovalStatus() throws Exception {
		Notification postNotification = testApprovalStatus_addNotification();

		Notification randomNotification = randomNotification();

		Notification putNotification = notificationResource.approvalStatus(
			postNotification.getId(), randomNotification);

		assertEquals(randomNotification, putNotification);
		assertValid(putNotification);

		Notification getNotification = notificationResource.approvalStatus(
			putNotification.getId());

		assertEquals(randomNotification, getNotification);
		assertValid(getNotification);
	}

	protected Notification testApprovalStatus_addNotification()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Notification testGraphQLNotification_addNotification()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Notification notification, List<Notification> notifications) {

		boolean contains = false;

		for (Notification item : notifications) {
			if (equals(notification, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			notifications + " does not contain " + notification, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Notification notification1, Notification notification2) {

		Assert.assertTrue(
			notification1 + " does not equal " + notification2,
			equals(notification1, notification2));
	}

	protected void assertEquals(
		List<Notification> notifications1, List<Notification> notifications2) {

		Assert.assertEquals(notifications1.size(), notifications2.size());

		for (int i = 0; i < notifications1.size(); i++) {
			Notification notification1 = notifications1.get(i);
			Notification notification2 = notifications2.get(i);

			assertEquals(notification1, notification2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Notification> notifications1, List<Notification> notifications2) {

		Assert.assertEquals(notifications1.size(), notifications2.size());

		for (Notification notification1 : notifications1) {
			boolean contains = false;

			for (Notification notification2 : notifications2) {
				if (equals(notification1, notification2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				notifications2 + " does not contain " + notification1,
				contains);
		}
	}

	protected void assertValid(Notification notification) throws Exception {
		boolean valid = true;

		if (notification.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("category", additionalAssertFieldName)) {
				if (notification.getCategory() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (notification.getCreateDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (notification.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (notification.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (notification.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("receiverId", additionalAssertFieldName)) {
				if (notification.getReceiverId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("receiverName", additionalAssertFieldName)) {
				if (notification.getReceiverName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (notification.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subjectId", additionalAssertFieldName)) {
				if (notification.getSubjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subjectName", additionalAssertFieldName)) {
				if (notification.getSubjectName() == null) {
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

	protected void assertValid(Page<Notification> page) {
		boolean valid = false;

		java.util.Collection<Notification> notifications = page.getItems();

		int size = notifications.size();

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
					com.swork.notification.rest.dto.v2_0.Notification.class)) {

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
		Notification notification1, Notification notification2) {

		if (notification1 == notification2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("category", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getCategory(),
						notification2.getCategory())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getCreateDate(),
						notification2.getCreateDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getDescription(),
						notification2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						notification1.getExternalReferenceCode(),
						notification2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getId(), notification2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getName(), notification2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("receiverId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getReceiverId(),
						notification2.getReceiverId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("receiverName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getReceiverName(),
						notification2.getReceiverName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getStatus(), notification2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subjectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getSubjectId(),
						notification2.getSubjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subjectName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						notification1.getSubjectName(),
						notification2.getSubjectName())) {

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

		if (!(_notificationResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_notificationResource;

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
		EntityField entityField, String operator, Notification notification) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("category")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getCategory()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("createDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							notification.getCreateDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(notification.getCreateDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(notification.getCreateDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("receiverId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("receiverName")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getReceiverName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subjectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subjectName")) {
			sb.append("'");
			sb.append(String.valueOf(notification.getSubjectName()));
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

	protected Notification randomNotification() throws Exception {
		return new Notification() {
			{
				category = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				createDate = RandomTestUtil.nextDate();
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				receiverId = RandomTestUtil.randomLong();
				receiverName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				subjectId = RandomTestUtil.randomLong();
				subjectName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Notification randomIrrelevantNotification() throws Exception {
		Notification randomIrrelevantNotification = randomNotification();

		return randomIrrelevantNotification;
	}

	protected Notification randomPatchNotification() throws Exception {
		return randomNotification();
	}

	protected NotificationResource notificationResource;
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
		LogFactoryUtil.getLog(BaseNotificationResourceTestCase.class);

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
	private com.swork.notification.rest.resource.v2_0.NotificationResource
		_notificationResource;

}