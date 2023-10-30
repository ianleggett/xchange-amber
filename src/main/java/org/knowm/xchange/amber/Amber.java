package org.knowm.xchange.amber;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.knowm.xchange.amber.dto.accounts.AmberBalanceResult;
import org.knowm.xchange.amber.dto.accounts.AmberRFQResult;
import org.knowm.xchange.amber.dto.marketdata.AmberContractResult;
import org.knowm.xchange.amber.dto.marketdata.AmberOrders;
import org.knowm.xchange.amber.dto.marketdata.AmberTicker;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade;

import si.mazi.rescu.ParamsDigest;

@Path("api/v1")
@Produces(MediaType.APPLICATION_JSON)
public interface Amber {

	public static final String APIKEY = "access-key";
	public static final String ACCESS_SIGN = "access-sign";
	public static final String TMSTAMP = "access-timestamp";

	@GET
	@Path("ticker?coin={symbol}")
	AmberTicker getTicker(@PathParam("symbol") String symbol) throws IOException;

	@GET
	@Path("orders?coin={symbol}")
	AmberTrade[] getTrades(@PathParam("symbol") String symbol) throws IOException;

	@GET
	@Path("depth/region/{region}?coin={symbol}")
	AmberOrders getOrders(@PathParam("region") String region, @PathParam("symbol") String symbol) throws IOException;

	@GET
	@Path("rfq?contract={contract}&quantity={quantity}&direction={direction}")
	AmberRFQResult getRFQ(@HeaderParam(TMSTAMP) long tmstamp, @HeaderParam(APIKEY) String apiKey,
			@HeaderParam(ACCESS_SIGN) ParamsDigest signature,@PathParam("contract") String region, @PathParam("quantity") BigDecimal quantity,
			@PathParam("direction") String direction) throws IOException;

	@GET
	@Path("balance")
	AmberBalanceResult getBalance(@HeaderParam(TMSTAMP) long tmstamp, @HeaderParam(APIKEY) String apiKey,
			@HeaderParam(ACCESS_SIGN) ParamsDigest signature) throws IOException;

	@GET
	@Path("contracts")
	AmberContractResult getContracts(@HeaderParam(TMSTAMP) long tmstamp, @HeaderParam(APIKEY) String apiKey,
			@HeaderParam(ACCESS_SIGN) ParamsDigest signature) throws IOException;
}
