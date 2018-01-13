package resumewala;

import java.security.SecureRandom;
import java.math.BigInteger;

public class SessionIdGenerator {
	private static final int LENGTH = 32;
	private static SecureRandom random = new SecureRandom();

	public static String getSessionId() {

		BigInteger bigInteger = new BigInteger(130, random);

		String sessionId = String.valueOf(bigInteger.toString(LENGTH));

		return sessionId.toUpperCase();
	}
}
