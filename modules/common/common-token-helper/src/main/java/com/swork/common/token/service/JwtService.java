package com.swork.common.token.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.token.util.Helper;
import com.swork.common.token.util.TokenKeys;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Properties;

@Component(immediate = true, service = JwtService.class)
public class JwtService {
    private static final String AUTH_PROPERTIES_PATH = "/configuration/auth.properties";
    private final Properties authProperties =
            new Helper().loadResourceBundled(AUTH_PROPERTIES_PATH);

    public String getAuthPropertiesPath(String key) {
        return authProperties.getProperty(key);
    }

    public String getJWToken( long accountId, String userName) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String token;

        byte[] apiKeySecretBytes =
                DatatypeConverter.parseBase64Binary(authProperties.getProperty(TokenKeys.SECRET_KEY));

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        int expiration = GetterUtil.getInteger(authProperties.getProperty(TokenKeys.EXPIRATION_TIME));

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, expiration);
        Claims claims = Jwts.claims().setSubject(TokenKeys.TOKEN_SUBJECT);

        claimsUtils.buildClaims( accountId, userName, claims);

        token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(c.getTime())
                .signWith(signingKey, signatureAlgorithm)
                .compact();

        return token;
    }

    public Claims decodeJWToken(String token) {
        if (Validator.isNull(token)) {
            return null;
        }

        byte[] signingKey = DatatypeConverter
                .parseBase64Binary(authProperties.getProperty(TokenKeys.SECRET_KEY));

        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(
                            DatatypeConverter.parseBase64Binary(authProperties.getProperty(TokenKeys.SECRET_KEY)))
                    .build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            _log.error("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            _log.error("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            _log.error("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            _log.error("JWT claims string is empty: " + e.getMessage());
        } catch (SignatureException e) {
            _log.error("JWT signature does not match locally computed signature: " + e.getMessage());
        }

        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(JwtService.class);

    @Reference
    private ClaimsService claimsUtils;

}
