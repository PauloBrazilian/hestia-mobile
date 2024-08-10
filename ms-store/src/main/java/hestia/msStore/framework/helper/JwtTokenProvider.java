package hestia.msStore.framework.helper;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

//    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
//
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public boolean validateToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            logger.debug("Validating token with secret: {}", secret);
//            JWT.require(algorithm)
//                    .withIssuer("ms-security")
//                    .build()
//                    .verify(token)
//                    .getSubject();
//            logger.debug("Token is valid");
//            return true;
//        } catch (JWTVerificationException exception) {
//            logger.error("Token validation error: {}", exception.getMessage());
//            throw new RuntimeException("Error while authenticating", exception);
//        }
//    }
//
//    public String getUsernameFromToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            logger.debug("Getting username from token");
//            return JWT.require(algorithm)
//                    .withIssuer("ms-security")
//                    .build()
//                    .verify(token)
//                    .getSubject();
//        } catch (JWTVerificationException exception) {
//            logger.error("Error getting username from token: {}", exception.getMessage());
//            return null;
//        }
//    }

}
