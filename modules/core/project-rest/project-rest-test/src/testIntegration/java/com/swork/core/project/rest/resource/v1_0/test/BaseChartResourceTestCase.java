package com.swork.core.project.rest.resource.v1_0.test;

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

import com.swork.core.project.rest.client.dto.v1_0.Chart;
import com.swork.core.project.rest.client.http.HttpInvoker;
import com.swork.core.project.rest.client.pagination.Page;
import com.swork.core.project.rest.client.resource.v1_0.ChartResource;
import com.swork.core.project.rest.client.serdes.v1_0.ChartSerDes;

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
 * @author Long Hip
 * @generated
 */
@Generated("")
public abstract class BaseChartResourceTestCase {

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

		_chartResource.setContextCompany(testCompany);

		ChartResource.Builder builder = ChartResource.builder();

		chartResource = builder.authentication(
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

		Chart chart1 = randomChart();

		String json = objectMapper.writeValueAsString(chart1);

		Chart chart2 = ChartSerDes.toDTO(json);

		Assert.assertTrue(equals(chart1, chart2));
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

		Chart chart = randomChart();

		String json1 = objectMapper.writeValueAsString(chart);
		String json2 = ChartSerDes.toJSON(chart);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Chart chart = randomChart();

		chart.setObj(regex);
		chart.setUnit(regex);

		String json = ChartSerDes.toJSON(chart);

		Assert.assertFalse(json.contains(regex));

		chart = ChartSerDes.toDTO(json);

		Assert.assertEquals(regex, chart.getObj());
		Assert.assertEquals(regex, chart.getUnit());
	}

	@Test
	public void testGetDashboardStatusWork() throws Exception {
		Page<Chart> page = chartResource.getDashboardStatusWork(null);

		long totalCount = page.getTotalCount();

		Chart chart1 = testGetDashboardStatusWork_addChart(randomChart());

		Chart chart2 = testGetDashboardStatusWork_addChart(randomChart());

		page = chartResource.getDashboardStatusWork(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(chart1, (List<Chart>)page.getItems());
		assertContains(chart2, (List<Chart>)page.getItems());
		assertValid(page);
	}

	protected Chart testGetDashboardStatusWork_addChart(Chart chart)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDashboardTeamInout() throws Exception {
		Page<Chart> page = chartResource.getDashboardTeamInout(null);

		long totalCount = page.getTotalCount();

		Chart chart1 = testGetDashboardTeamInout_addChart(randomChart());

		Chart chart2 = testGetDashboardTeamInout_addChart(randomChart());

		page = chartResource.getDashboardTeamInout(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(chart1, (List<Chart>)page.getItems());
		assertContains(chart2, (List<Chart>)page.getItems());
		assertValid(page);
	}

	protected Chart testGetDashboardTeamInout_addChart(Chart chart)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDashboardBurnDownWork() throws Exception {
		Page<Chart> page = chartResource.getDashboardBurnDownWork(null);

		long totalCount = page.getTotalCount();

		Chart chart1 = testGetDashboardBurnDownWork_addChart(randomChart());

		Chart chart2 = testGetDashboardBurnDownWork_addChart(randomChart());

		page = chartResource.getDashboardBurnDownWork(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(chart1, (List<Chart>)page.getItems());
		assertContains(chart2, (List<Chart>)page.getItems());
		assertValid(page);
	}

	protected Chart testGetDashboardBurnDownWork_addChart(Chart chart)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDashboardResourceProject() throws Exception {
		Page<Chart> page = chartResource.getDashboardResourceProject(null);

		long totalCount = page.getTotalCount();

		Chart chart1 = testGetDashboardResourceProject_addChart(randomChart());

		Chart chart2 = testGetDashboardResourceProject_addChart(randomChart());

		page = chartResource.getDashboardResourceProject(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(chart1, (List<Chart>)page.getItems());
		assertContains(chart2, (List<Chart>)page.getItems());
		assertValid(page);
	}

	protected Chart testGetDashboardResourceProject_addChart(Chart chart)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Chart chart, List<Chart> charts) {
		boolean contains = false;

		for (Chart item : charts) {
			if (equals(chart, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(charts + " does not contain " + chart, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Chart chart1, Chart chart2) {
		Assert.assertTrue(
			chart1 + " does not equal " + chart2, equals(chart1, chart2));
	}

	protected void assertEquals(List<Chart> charts1, List<Chart> charts2) {
		Assert.assertEquals(charts1.size(), charts2.size());

		for (int i = 0; i < charts1.size(); i++) {
			Chart chart1 = charts1.get(i);
			Chart chart2 = charts2.get(i);

			assertEquals(chart1, chart2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Chart> charts1, List<Chart> charts2) {

		Assert.assertEquals(charts1.size(), charts2.size());

		for (Chart chart1 : charts1) {
			boolean contains = false;

			for (Chart chart2 : charts2) {
				if (equals(chart1, chart2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				charts2 + " does not contain " + chart1, contains);
		}
	}

	protected void assertValid(Chart chart) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (chart.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("obj", additionalAssertFieldName)) {
				if (chart.getObj() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("sum", additionalAssertFieldName)) {
				if (chart.getSum() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("sumDouble", additionalAssertFieldName)) {
				if (chart.getSumDouble() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (chart.getUnit() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"valueArrayDoubles", additionalAssertFieldName)) {

				if (chart.getValueArrayDoubles() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"valueArrayStrings", additionalAssertFieldName)) {

				if (chart.getValueArrayStrings() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("valueArrays", additionalAssertFieldName)) {
				if (chart.getValueArrays() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("valueCharts", additionalAssertFieldName)) {
				if (chart.getValueCharts() == null) {
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

	protected void assertValid(Page<Chart> page) {
		boolean valid = false;

		java.util.Collection<Chart> charts = page.getItems();

		int size = charts.size();

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
					com.swork.core.project.rest.dto.v1_0.Chart.class)) {

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

	protected boolean equals(Chart chart1, Chart chart2) {
		if (chart1 == chart2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(chart1.getDate(), chart2.getDate())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("obj", additionalAssertFieldName)) {
				if (!Objects.deepEquals(chart1.getObj(), chart2.getObj())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("sum", additionalAssertFieldName)) {
				if (!Objects.deepEquals(chart1.getSum(), chart2.getSum())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("sumDouble", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chart1.getSumDouble(), chart2.getSumDouble())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("unit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(chart1.getUnit(), chart2.getUnit())) {
					return false;
				}

				continue;
			}

			if (Objects.equals(
					"valueArrayDoubles", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						chart1.getValueArrayDoubles(),
						chart2.getValueArrayDoubles())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"valueArrayStrings", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						chart1.getValueArrayStrings(),
						chart2.getValueArrayStrings())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("valueArrays", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chart1.getValueArrays(), chart2.getValueArrays())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("valueCharts", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chart1.getValueCharts(), chart2.getValueCharts())) {

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

		if (!(_chartResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_chartResource;

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
		EntityField entityField, String operator, Chart chart) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("date")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(chart.getDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(chart.getDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(chart.getDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("obj")) {
			sb.append("'");
			sb.append(String.valueOf(chart.getObj()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("sum")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("sumDouble")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("unit")) {
			sb.append("'");
			sb.append(String.valueOf(chart.getUnit()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("valueArrayDoubles")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("valueArrayStrings")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("valueArrays")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("valueCharts")) {
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

	protected Chart randomChart() throws Exception {
		return new Chart() {
			{
				date = RandomTestUtil.nextDate();
				obj = StringUtil.toLowerCase(RandomTestUtil.randomString());
				sum = RandomTestUtil.randomLong();
				sumDouble = RandomTestUtil.randomDouble();
				unit = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Chart randomIrrelevantChart() throws Exception {
		Chart randomIrrelevantChart = randomChart();

		return randomIrrelevantChart;
	}

	protected Chart randomPatchChart() throws Exception {
		return randomChart();
	}

	protected ChartResource chartResource;
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
		LogFactoryUtil.getLog(BaseChartResourceTestCase.class);

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
	private com.swork.core.project.rest.resource.v1_0.ChartResource
		_chartResource;

}