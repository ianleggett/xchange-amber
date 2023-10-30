package org.knowm.xchange.amber;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.Mac;

import org.knowm.xchange.service.BaseParamsDigest;
import org.knowm.xchange.utils.DigestUtils;

import si.mazi.rescu.RestInvocation;

public class AmberDigest extends BaseParamsDigest {

		  private AmberDigest(String secretKeyBase64) throws IllegalArgumentException {
		    super(secretKeyBase64, HMAC_SHA_256);
		  }

		  public static AmberDigest createInstance(String secretKeyBase64) {
		    return new AmberDigest(secretKeyBase64);
		  }

		  @Override
		  public String digestParams(RestInvocation restInvocation) {			
			    try {			
			      Map<String, String> headers = restInvocation.getHttpHeadersFromParams();
			      String apiKey = headers.get(AmberAuthenticated.APIKEY);
			      Long requestTimestamp = Long.parseLong(headers.get(AmberAuthenticated.TMSTAMP));
			      String hashContent = "key="+apiKey+"&timestamp=" + requestTimestamp;
			      Mac mac = getMac();
			      mac.update(hashContent.getBytes("UTF-8")	); 	    
			      return hex(mac.doFinal());			      			
			    } catch (IllegalStateException | UnsupportedEncodingException e) {
			    	throw new RuntimeException(e);
				}			   
		  }

		  private static String hex(byte[] b) {
			    return DigestUtils.bytesToHex(b).toLowerCase();
			  }
}
