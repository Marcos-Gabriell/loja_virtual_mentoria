package br.com.marcos.lojavirtual.security;

import static java.util.Objects.isNull;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component
public class JWTTokenAutenticacaoService {

	private static final long EXPIRATION_TME = 959990000;

	private static final String SECRET = "ss/-*-*sds565dsd-s/d-s*dsds";

	private static final String TOKEN_PREFIX = "Bearer";

	private static final String HEADER_STRING = "Authorization";
	
	public void addAuthentication(HttpServletResponse response, String username) throws Exception {
		
		String jWT = Jwts.builder().
				setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		String token = TOKEN_PREFIX + " " + jWT;
		
		response.addHeader(HEADER_STRING, token);
		
		liberarCorsPolicy(response);
		
		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");

	}
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
		
		String token = request.getHeader(HEADER_STRING);
		
		if(token != null) {
			
			String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();
			
		}
		liberarCorsPolicy(response);
		return null;
	}
	
	
	// CORS policy
		private void liberarCorsPolicy(HttpServletResponse response) {
			if (isNull(response.getHeader("Access-Control-Allow-Origin"))) {
				response.addHeader("Access-Control-Allow-Origin", "*");		
			}
			if (isNull(response.getHeader("Access-Control-Allow-Headers"))) {
				response.addHeader("Access-Control-Allow-Headers", "*");		
			}
			if (isNull(response.getHeader("Access-Control-Request-Headers"))) {
				response.addHeader("Access-Control-Request-Headers", "*");		
			}
			if (isNull(response.getHeader("Access-Control-Allow-Methods"))) {
				response.addHeader("Access-Control-Allow-Methods", "*");		
			}
		}
}
