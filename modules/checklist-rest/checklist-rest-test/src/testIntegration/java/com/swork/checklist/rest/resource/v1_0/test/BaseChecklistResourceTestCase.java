package com.swork.checklist.rest.resource.v1_0.test;

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

import com.swork.checklist.rest.client.dto.v1_0.CheckList;
import com.swork.checklist.rest.client.http.HttpInvoker;
import com.swork.checklist.rest.client.pagination.Page;
import com.swork.checklist.rest.client.pagination.Pagination;
import com.swork.checklist.rest.client.resource.v1_0.ChecklistResource;

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
 * @author adm
 * @generated
 */
@Generated("")
public abstract class BaseChecklistResourceTestCase {

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

		_checklistResource.setContextCompany(testCompany);

		ChecklistResource.Builder builder = ChecklistResource.builder();

		checklistResource = builder.authentication(
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
	public void testGetChecklistPages() throws Exception {
		Page<Checklist> page = checklistResource.getChecklistPages(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Checklist checklist1 = testGetChecklistPages_addChecklist(
			randomChecklist());

		Checklist checklist2 = testGetChecklistPages_addChecklist(
			randomChecklist());

		page = checklistResource.getChecklistPages(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(checklist1, (List<Checklist>)page.getItems());
		assertContains(checklist2, (List<Checklist>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetChecklistPagesWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Checklist checklist1 = randomChecklist();

		checklist1 = testGetChecklistPages_addChecklist(checklist1);

		for (EntityField entityField : entityFields) {
			Page<Checklist> page = checklistResource.getChecklistPages(
				null, getFilterString(entityField, "between", checklist1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(checklist1),
				(List<Checklist>)page.getItems());
		}
	}

	@Test
	public void testGetChecklistPagesWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Checklist checklist1 = testGetChecklistPages_addChecklist(
			randomChecklist());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Checklist checklist2 = testGetChecklistPages_addChecklist(
			randomChecklist());

		for (EntityField entityField : entityFields) {
			Page<Checklist> page = checklistResource.getChecklistPages(
				null, getFilterString(entityField, "eq", checklist1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(checklist1),
				(List<Checklist>)page.getItems());
		}
	}

	@Test
	public void testGetChecklistPagesWithPagination() throws Exception {
		Page<Checklist> totalPage = checklistResource.getChecklistPages(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Checklist checklist1 = testGetChecklistPages_addChecklist(
			randomChecklist());

		Checklist checklist2 = testGetChecklistPages_addChecklist(
			randomChecklist());

		Checklist checklist3 = testGetChecklistPages_addChecklist(
			randomChecklist());

		Page<Checklist> page1 = checklistResource.getChecklistPages(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Checklist> checklists1 = (List<Checklist>)page1.getItems();

		Assert.assertEquals(
			checklists1.toString(), totalCount + 2, checklists1.size());

		Page<Checklist> page2 = checklistResource.getChecklistPages(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Checklist> checklists2 = (List<Checklist>)page2.getItems();

		Assert.assertEquals(checklists2.toString(), 1, checklists2.size());

		Page<Checklist> page3 = checklistResource.getChecklistPages(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(checklist1, (List<Checklist>)page3.getItems());
		assertContains(checklist2, (List<Checklist>)page3.getItems());
		assertContains(checklist3, (List<Checklist>)page3.getItems());
	}

	@Test
	public void testGetChecklistPagesWithSortDateTime() throws Exception {
		testGetChecklistPagesWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, checklist1, checklist2) -> {
				BeanUtils.setProperty(
					checklist1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetChecklistPagesWithSortInteger() throws Exception {
		testGetChecklistPagesWithSort(
			EntityField.Type.INTEGER,
			(entityField, checklist1, checklist2) -> {
				BeanUtils.setProperty(checklist1, entityField.getName(), 0);
				BeanUtils.setProperty(checklist2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetChecklistPagesWithSortString() throws Exception {
		testGetChecklistPagesWithSort(
			EntityField.Type.STRING,
			(entityField, checklist1, checklist2) -> {
				Class<?> clazz = checklist1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						checklist1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						checklist2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						checklist1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						checklist2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						checklist1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						checklist2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetChecklistPagesWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Checklist, Checklist, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Checklist checklist1 = randomChecklist();
		Checklist checklist2 = randomChecklist();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, checklist1, checklist2);
		}

		checklist1 = testGetChecklistPages_addChecklist(checklist1);

		checklist2 = testGetChecklistPages_addChecklist(checklist2);

		for (EntityField entityField : entityFields) {
			Page<Checklist> ascPage = checklistResource.getChecklistPages(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(checklist1, checklist2),
				(List<Checklist>)ascPage.getItems());

			Page<Checklist> descPage = checklistResource.getChecklistPages(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(checklist2, checklist1),
				(List<Checklist>)descPage.getItems());
		}
	}

	protected Checklist testGetChecklistPages_addChecklist(Checklist checklist)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteCheckList() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Test
	public void testPostCheckList() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testChangeCheckListStatusById() throws Exception {
		Checklist postChecklist = testPutChecklist_addChecklist();

		testChangeCheckListStatusById_addCheckList(
			postChecklist.getId(), randomCheckList());

		CheckList randomCheckList = randomCheckList();

		CheckList putCheckList = checklistResource.changeCheckListStatusById(
			null, null);

		assertEquals(randomCheckList, putCheckList);
		assertValid(putCheckList);
	}

	protected CheckList testChangeCheckListStatusById_addCheckList(
			long checklistId, CheckList checkList)
		throws Exception {

		return checklistResource.changeCheckListStatusById(
			checklistId, checkList);
	}

	@Test
	public void testGetCheckListById() throws Exception {
		Checklist postChecklist = testGetChecklist_addChecklist();

		CheckList postCheckList = testGetCheckListById_addCheckList(
			postChecklist.getId(), randomCheckList());

		CheckList getCheckList = checklistResource.getCheckListById(
			postChecklist.getId());

		assertEquals(postCheckList, getCheckList);
		assertValid(getCheckList);
	}

	protected CheckList testGetCheckListById_addCheckList(
			long checklistId, CheckList checkList)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateCheckList() throws Exception {
		Checklist postChecklist = testPutChecklist_addChecklist();

		testUpdateCheckList_addCheckList(
			postChecklist.getId(), randomCheckList());

		CheckList randomCheckList = randomCheckList();

		CheckList putCheckList = checklistResource.updateCheckList(
			null, randomCheckList);

		assertEquals(randomCheckList, putCheckList);
		assertValid(putCheckList);
	}

	protected CheckList testUpdateCheckList_addCheckList(
			long checklistId, CheckList checkList)
		throws Exception {

		return checklistResource.updateCheckList(checklistId, checkList);
	}

	protected void assertContains(Object checklist, List<Object> checklists) {
		boolean contains = false;

		for (Object item : checklists) {
			if (equals(checklist, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			checklists + " does not contain " + checklist, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object checklist1, Object checklist2) {
		Assert.assertTrue(
			checklist1 + " does not equal " + checklist2,
			equals(checklist1, checklist2));
	}

	protected void assertEquals(
		List<Object> checklists1, List<Object> checklists2) {

		Assert.assertEquals(checklists1.size(), checklists2.size());

		for (int i = 0; i < checklists1.size(); i++) {
			Object checklist1 = checklists1.get(i);
			Object checklist2 = checklists2.get(i);

			assertEquals(checklist1, checklist2);
		}
	}

	protected void assertEquals(CheckList checkList1, CheckList checkList2) {
		Assert.assertTrue(
			checkList1 + " does not equal " + checkList2,
			equals(checkList1, checkList2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> checklists1, List<Object> checklists2) {

		Assert.assertEquals(checklists1.size(), checklists2.size());

		for (Object checklist1 : checklists1) {
			boolean contains = false;

			for (Object checklist2 : checklists2) {
				if (equals(checklist1, checklist2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				checklists2 + " does not contain " + checklist1, contains);
		}
	}

	protected void assertValid(Object checklist) throws Exception {
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

		java.util.Collection<Object> checklists = page.getItems();

		int size = checklists.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(CheckList checkList) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalCheckListAssertFieldNames()) {

			if (Objects.equals("checkListId", additionalAssertFieldName)) {
				if (checkList.getCheckListId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (checkList.getEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("handlers", additionalAssertFieldName)) {
				if (checkList.getHandlers() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (checkList.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (checkList.getStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (checkList.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("taskId", additionalAssertFieldName)) {
				if (checkList.getTaskId() == null) {
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

	protected String[] getAdditionalCheckListAssertFieldNames() {
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

	protected boolean equals(Object checklist1, Object checklist2) {
		if (checklist1 == checklist2) {
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

	protected boolean equals(CheckList checkList1, CheckList checkList2) {
		if (checkList1 == checkList2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalCheckListAssertFieldNames()) {

			if (Objects.equals("checkListId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getCheckListId(),
						checkList2.getCheckListId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getEndDate(), checkList2.getEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("handlers", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getHandlers(), checkList2.getHandlers())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getName(), checkList2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getStartDate(), checkList2.getStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getStatus(), checkList2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("taskId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						checkList1.getTaskId(), checkList2.getTaskId())) {

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

		if (!(_checklistResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_checklistResource;

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
		EntityField entityField, String operator, Object checklist) {

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

	protected CheckList randomCheckList() throws Exception {
		return new CheckList() {
			{
				checkListId = RandomTestUtil.randomLong();
				endDate = RandomTestUtil.nextDate();
				name = RandomTestUtil.randomString();
				startDate = RandomTestUtil.nextDate();
				status = RandomTestUtil.randomBoolean();
				taskId = RandomTestUtil.randomLong();
			}
		};
	}

	protected ChecklistResource checklistResource;
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
		LogFactoryUtil.getLog(BaseChecklistResourceTestCase.class);

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
	private com.swork.checklist.rest.resource.v1_0.ChecklistResource
		_checklistResource;

}