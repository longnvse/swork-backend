package com.swork.account.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
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
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.swork.account.rest.client.dto.v1_0.AccountPermision;
import com.swork.account.rest.client.http.HttpInvoker;
import com.swork.account.rest.client.pagination.Page;
import com.swork.account.rest.client.pagination.Pagination;
import com.swork.account.rest.client.resource.v1_0.AccountPermisionResource;
import com.swork.account.rest.client.serdes.v1_0.AccountPermisionSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
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
 * @author Long Hip
 * @generated
 */
@Generated("")
public abstract class BaseAccountPermisionResourceTestCase {

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

		_accountPermisionResource.setContextCompany(testCompany);

		AccountPermisionResource.Builder builder =
			AccountPermisionResource.builder();

		accountPermisionResource = builder.authentication(
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

		AccountPermision accountPermision1 = randomAccountPermision();

		String json = objectMapper.writeValueAsString(accountPermision1);

		AccountPermision accountPermision2 = AccountPermisionSerDes.toDTO(json);

		Assert.assertTrue(equals(accountPermision1, accountPermision2));
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

		AccountPermision accountPermision = randomAccountPermision();

		String json1 = objectMapper.writeValueAsString(accountPermision);
		String json2 = AccountPermisionSerDes.toJSON(accountPermision);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		AccountPermision accountPermision = randomAccountPermision();

		String json = AccountPermisionSerDes.toJSON(accountPermision);

		Assert.assertFalse(json.contains(regex));

		accountPermision = AccountPermisionSerDes.toDTO(json);
	}

	@Test
	public void testGetAccountPermisionsPage() throws Exception {
		Page<AccountPermision> page =
			accountPermisionResource.getAccountPermisionsPage(
				null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		AccountPermision accountPermision1 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		AccountPermision accountPermision2 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		page = accountPermisionResource.getAccountPermisionsPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			accountPermision1, (List<AccountPermision>)page.getItems());
		assertContains(
			accountPermision2, (List<AccountPermision>)page.getItems());
		assertValid(page);

		accountPermisionResource.deleteAccountPermision(
			accountPermision1.getId());

		accountPermisionResource.deleteAccountPermision(
			accountPermision2.getId());
	}

	@Test
	public void testGetAccountPermisionsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		AccountPermision accountPermision1 = randomAccountPermision();

		accountPermision1 = testGetAccountPermisionsPage_addAccountPermision(
			accountPermision1);

		for (EntityField entityField : entityFields) {
			Page<AccountPermision> page =
				accountPermisionResource.getAccountPermisionsPage(
					null,
					getFilterString(entityField, "between", accountPermision1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(accountPermision1),
				(List<AccountPermision>)page.getItems());
		}
	}

	@Test
	public void testGetAccountPermisionsPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		AccountPermision accountPermision1 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		AccountPermision accountPermision2 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		for (EntityField entityField : entityFields) {
			Page<AccountPermision> page =
				accountPermisionResource.getAccountPermisionsPage(
					null, getFilterString(entityField, "eq", accountPermision1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(accountPermision1),
				(List<AccountPermision>)page.getItems());
		}
	}

	@Test
	public void testGetAccountPermisionsPageWithPagination() throws Exception {
		Page<AccountPermision> totalPage =
			accountPermisionResource.getAccountPermisionsPage(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		AccountPermision accountPermision1 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		AccountPermision accountPermision2 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		AccountPermision accountPermision3 =
			testGetAccountPermisionsPage_addAccountPermision(
				randomAccountPermision());

		Page<AccountPermision> page1 =
			accountPermisionResource.getAccountPermisionsPage(
				null, null, Pagination.of(1, totalCount + 2), null);

		List<AccountPermision> accountPermisions1 =
			(List<AccountPermision>)page1.getItems();

		Assert.assertEquals(
			accountPermisions1.toString(), totalCount + 2,
			accountPermisions1.size());

		Page<AccountPermision> page2 =
			accountPermisionResource.getAccountPermisionsPage(
				null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<AccountPermision> accountPermisions2 =
			(List<AccountPermision>)page2.getItems();

		Assert.assertEquals(
			accountPermisions2.toString(), 1, accountPermisions2.size());

		Page<AccountPermision> page3 =
			accountPermisionResource.getAccountPermisionsPage(
				null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(
			accountPermision1, (List<AccountPermision>)page3.getItems());
		assertContains(
			accountPermision2, (List<AccountPermision>)page3.getItems());
		assertContains(
			accountPermision3, (List<AccountPermision>)page3.getItems());
	}

	@Test
	public void testGetAccountPermisionsPageWithSortDateTime()
		throws Exception {

		testGetAccountPermisionsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, accountPermision1, accountPermision2) -> {
				BeanUtils.setProperty(
					accountPermision1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetAccountPermisionsPageWithSortInteger() throws Exception {
		testGetAccountPermisionsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, accountPermision1, accountPermision2) -> {
				BeanUtils.setProperty(
					accountPermision1, entityField.getName(), 0);
				BeanUtils.setProperty(
					accountPermision2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetAccountPermisionsPageWithSortString() throws Exception {
		testGetAccountPermisionsPageWithSort(
			EntityField.Type.STRING,
			(entityField, accountPermision1, accountPermision2) -> {
				Class<?> clazz = accountPermision1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						accountPermision1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						accountPermision2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						accountPermision1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						accountPermision2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						accountPermision1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						accountPermision2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetAccountPermisionsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, AccountPermision, AccountPermision, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		AccountPermision accountPermision1 = randomAccountPermision();
		AccountPermision accountPermision2 = randomAccountPermision();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, accountPermision1, accountPermision2);
		}

		accountPermision1 = testGetAccountPermisionsPage_addAccountPermision(
			accountPermision1);

		accountPermision2 = testGetAccountPermisionsPage_addAccountPermision(
			accountPermision2);

		for (EntityField entityField : entityFields) {
			Page<AccountPermision> ascPage =
				accountPermisionResource.getAccountPermisionsPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(accountPermision1, accountPermision2),
				(List<AccountPermision>)ascPage.getItems());

			Page<AccountPermision> descPage =
				accountPermisionResource.getAccountPermisionsPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(accountPermision2, accountPermision1),
				(List<AccountPermision>)descPage.getItems());
		}
	}

	protected AccountPermision testGetAccountPermisionsPage_addAccountPermision(
			AccountPermision accountPermision)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAccountPermisionsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"accountPermisions",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject accountPermisionsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/accountPermisions");

		long totalCount = accountPermisionsJSONObject.getLong("totalCount");

		AccountPermision accountPermision1 =
			testGraphQLAccountPermision_addAccountPermision();
		AccountPermision accountPermision2 =
			testGraphQLAccountPermision_addAccountPermision();

		accountPermisionsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/accountPermisions");

		Assert.assertEquals(
			totalCount + 2, accountPermisionsJSONObject.getLong("totalCount"));

		assertContains(
			accountPermision1,
			Arrays.asList(
				AccountPermisionSerDes.toDTOs(
					accountPermisionsJSONObject.getString("items"))));
		assertContains(
			accountPermision2,
			Arrays.asList(
				AccountPermisionSerDes.toDTOs(
					accountPermisionsJSONObject.getString("items"))));
	}

	@Test
	public void testPostAccountPermision() throws Exception {
		AccountPermision randomAccountPermision = randomAccountPermision();

		AccountPermision postAccountPermision =
			testPostAccountPermision_addAccountPermision(
				randomAccountPermision);

		assertEquals(randomAccountPermision, postAccountPermision);
		assertValid(postAccountPermision);
	}

	protected AccountPermision testPostAccountPermision_addAccountPermision(
			AccountPermision accountPermision)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAccountPermision() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		AccountPermision accountPermision =
			testDeleteAccountPermision_addAccountPermision();

		assertHttpResponseStatusCode(
			204,
			accountPermisionResource.deleteAccountPermisionHttpResponse(
				accountPermision.getId()));
	}

	protected AccountPermision testDeleteAccountPermision_addAccountPermision()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteAccountPermision() throws Exception {
		AccountPermision accountPermision =
			testGraphQLAccountPermision_addAccountPermision();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteAccountPermision",
						new HashMap<String, Object>() {
							{
								put(
									"accountPermisionId",
									accountPermision.getId());
							}
						})),
				"JSONObject/data", "Object/deleteAccountPermision"));
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected AccountPermision testGraphQLAccountPermision_addAccountPermision()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		AccountPermision accountPermision,
		List<AccountPermision> accountPermisions) {

		boolean contains = false;

		for (AccountPermision item : accountPermisions) {
			if (equals(accountPermision, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			accountPermisions + " does not contain " + accountPermision,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		AccountPermision accountPermision1,
		AccountPermision accountPermision2) {

		Assert.assertTrue(
			accountPermision1 + " does not equal " + accountPermision2,
			equals(accountPermision1, accountPermision2));
	}

	protected void assertEquals(
		List<AccountPermision> accountPermisions1,
		List<AccountPermision> accountPermisions2) {

		Assert.assertEquals(
			accountPermisions1.size(), accountPermisions2.size());

		for (int i = 0; i < accountPermisions1.size(); i++) {
			AccountPermision accountPermision1 = accountPermisions1.get(i);
			AccountPermision accountPermision2 = accountPermisions2.get(i);

			assertEquals(accountPermision1, accountPermision2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<AccountPermision> accountPermisions1,
		List<AccountPermision> accountPermisions2) {

		Assert.assertEquals(
			accountPermisions1.size(), accountPermisions2.size());

		for (AccountPermision accountPermision1 : accountPermisions1) {
			boolean contains = false;

			for (AccountPermision accountPermision2 : accountPermisions2) {
				if (equals(accountPermision1, accountPermision2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				accountPermisions2 + " does not contain " + accountPermision1,
				contains);
		}
	}

	protected void assertValid(AccountPermision accountPermision)
		throws Exception {

		boolean valid = true;

		if (accountPermision.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (accountPermision.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("permisionId", additionalAssertFieldName)) {
				if (accountPermision.getPermisionId() == null) {
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

	protected void assertValid(Page<AccountPermision> page) {
		boolean valid = false;

		java.util.Collection<AccountPermision> accountPermisions =
			page.getItems();

		int size = accountPermisions.size();

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
					com.swork.account.rest.dto.v1_0.AccountPermision.class)) {

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
		AccountPermision accountPermision1,
		AccountPermision accountPermision2) {

		if (accountPermision1 == accountPermision2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountPermision1.getAccountId(),
						accountPermision2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountPermision1.getId(), accountPermision2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("permisionId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountPermision1.getPermisionId(),
						accountPermision2.getPermisionId())) {

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

		if (!(_accountPermisionResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_accountPermisionResource;

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
		EntityField entityField, String operator,
		AccountPermision accountPermision) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("permisionId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected AccountPermision randomAccountPermision() throws Exception {
		return new AccountPermision() {
			{
				accountId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				permisionId = RandomTestUtil.randomLong();
			}
		};
	}

	protected AccountPermision randomIrrelevantAccountPermision()
		throws Exception {

		AccountPermision randomIrrelevantAccountPermision =
			randomAccountPermision();

		return randomIrrelevantAccountPermision;
	}

	protected AccountPermision randomPatchAccountPermision() throws Exception {
		return randomAccountPermision();
	}

	protected AccountPermisionResource accountPermisionResource;
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
		LogFactoryUtil.getLog(BaseAccountPermisionResourceTestCase.class);

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
	private com.swork.account.rest.resource.v1_0.AccountPermisionResource
		_accountPermisionResource;

}