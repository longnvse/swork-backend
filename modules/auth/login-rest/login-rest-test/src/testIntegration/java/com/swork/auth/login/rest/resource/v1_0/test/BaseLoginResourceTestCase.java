package com.swork.auth.login.rest.resource.v1_0.test;

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

import com.swork.auth.login.rest.client.dto.v1_0.Credential;
import com.swork.auth.login.rest.client.dto.v1_0.CredentialRefresh;
import com.swork.auth.login.rest.client.http.HttpInvoker;
import com.swork.auth.login.rest.client.pagination.Page;
import com.swork.auth.login.rest.client.resource.v1_0.LoginResource;

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
 * @author Long Hip
 * @generated
 */
@Generated("")
public abstract class BaseLoginResourceTestCase {

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

		_loginResource.setContextCompany(testCompany);

		LoginResource.Builder builder = LoginResource.builder();

		loginResource = builder.authentication(
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
	public void testPostCredentialLogout() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostCredential() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPostCredentialRefresh() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Object login, List<Object> logins) {
		boolean contains = false;

		for (Object item : logins) {
			if (equals(login, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(logins + " does not contain " + login, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object login1, Object login2) {
		Assert.assertTrue(
			login1 + " does not equal " + login2, equals(login1, login2));
	}

	protected void assertEquals(List<Object> logins1, List<Object> logins2) {
		Assert.assertEquals(logins1.size(), logins2.size());

		for (int i = 0; i < logins1.size(); i++) {
			Object login1 = logins1.get(i);
			Object login2 = logins2.get(i);

			assertEquals(login1, login2);
		}
	}

	protected void assertEquals(
		Credential credential1, Credential credential2) {

		Assert.assertTrue(
			credential1 + " does not equal " + credential2,
			equals(credential1, credential2));
	}

	protected void assertEquals(
		CredentialRefresh credentialRefresh1,
		CredentialRefresh credentialRefresh2) {

		Assert.assertTrue(
			credentialRefresh1 + " does not equal " + credentialRefresh2,
			equals(credentialRefresh1, credentialRefresh2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> logins1, List<Object> logins2) {

		Assert.assertEquals(logins1.size(), logins2.size());

		for (Object login1 : logins1) {
			boolean contains = false;

			for (Object login2 : logins2) {
				if (equals(login1, login2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				logins2 + " does not contain " + login1, contains);
		}
	}

	protected void assertValid(Object login) throws Exception {
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

		java.util.Collection<Object> logins = page.getItems();

		int size = logins.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Credential credential) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalCredentialAssertFieldNames()) {

			if (Objects.equals("accessToken", additionalAssertFieldName)) {
				if (credential.getAccessToken() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (credential.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (credential.getPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("refreshToken", additionalAssertFieldName)) {
				if (credential.getRefreshToken() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("rememberMe", additionalAssertFieldName)) {
				if (credential.getRememberMe() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tokenType", additionalAssertFieldName)) {
				if (credential.getTokenType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("username", additionalAssertFieldName)) {
				if (credential.getUsername() == null) {
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

	protected void assertValid(CredentialRefresh credentialRefresh) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalCredentialRefreshAssertFieldNames()) {

			if (Objects.equals("accessToken", additionalAssertFieldName)) {
				if (credentialRefresh.getAccessToken() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("refreshToken", additionalAssertFieldName)) {
				if (credentialRefresh.getRefreshToken() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tokenType", additionalAssertFieldName)) {
				if (credentialRefresh.getTokenType() == null) {
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

	protected String[] getAdditionalCredentialAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalCredentialRefreshAssertFieldNames() {
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

	protected boolean equals(Object login1, Object login2) {
		if (login1 == login2) {
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

	protected boolean equals(Credential credential1, Credential credential2) {
		if (credential1 == credential2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalCredentialAssertFieldNames()) {

			if (Objects.equals("accessToken", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getAccessToken(),
						credential2.getAccessToken())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getAccountId(),
						credential2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getPassword(), credential2.getPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("refreshToken", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getRefreshToken(),
						credential2.getRefreshToken())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("rememberMe", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getRememberMe(),
						credential2.getRememberMe())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tokenType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getTokenType(),
						credential2.getTokenType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("username", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credential1.getUsername(), credential2.getUsername())) {

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
		CredentialRefresh credentialRefresh1,
		CredentialRefresh credentialRefresh2) {

		if (credentialRefresh1 == credentialRefresh2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalCredentialRefreshAssertFieldNames()) {

			if (Objects.equals("accessToken", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credentialRefresh1.getAccessToken(),
						credentialRefresh2.getAccessToken())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("refreshToken", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credentialRefresh1.getRefreshToken(),
						credentialRefresh2.getRefreshToken())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tokenType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						credentialRefresh1.getTokenType(),
						credentialRefresh2.getTokenType())) {

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

		if (!(_loginResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_loginResource;

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
		EntityField entityField, String operator, Object login) {

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

	protected Credential randomCredential() throws Exception {
		return new Credential() {
			{
				accessToken = RandomTestUtil.randomString();
				accountId = RandomTestUtil.randomLong();
				password = RandomTestUtil.randomString();
				refreshToken = RandomTestUtil.randomString();
				rememberMe = RandomTestUtil.randomBoolean();
				tokenType = RandomTestUtil.randomString();
				username = RandomTestUtil.randomString();
			}
		};
	}

	protected CredentialRefresh randomCredentialRefresh() throws Exception {
		return new CredentialRefresh() {
			{
				accessToken = RandomTestUtil.randomString();
				refreshToken = RandomTestUtil.randomString();
				tokenType = RandomTestUtil.randomString();
			}
		};
	}

	protected LoginResource loginResource;
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
		LogFactoryUtil.getLog(BaseLoginResourceTestCase.class);

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
	private com.swork.auth.login.rest.resource.v1_0.LoginResource
		_loginResource;

}