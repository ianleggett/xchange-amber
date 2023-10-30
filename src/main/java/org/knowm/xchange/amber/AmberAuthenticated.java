package org.knowm.xchange.amber;

import java.io.IOException;
import java.math.BigDecimal;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.knowm.xchange.amber.dto.accounts.AmberBalanceData;
import org.knowm.xchange.amber.dto.trade.AmberTradeAdd;
import org.knowm.xchange.amber.dto.trade.AmberTradeCancel;
import org.knowm.xchange.amber.dto.trade.AmberTradeList;
import org.knowm.xchange.amber.dto.trade.AmberTradeView;

import si.mazi.rescu.ParamsDigest;

@Path("api/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AmberAuthenticated {

	public static final String APIKEY = "access-key";
	public static final String ACCESS_SIGN = "access-sign";
	public static final String TMSTAMP = "access-timestamp";

	@POST
	@Path("trade_list")
	AmberTradeList getTradeList(@FormParam("key") String apiKey, @FormParam("signature") ParamsDigest signer,
			@FormParam("nonce") long nonce, @FormParam("since") long since, @FormParam("coin") String coin,
			@FormParam("type ") String type) throws IOException;

	@POST
	@Path("trade_view")
	AmberTradeView getTradeView(@FormParam("key") String apiKey, @FormParam("signature") ParamsDigest signer,
			@FormParam("nonce") long nonce, @FormParam("id") String tradeID, @FormParam("coin") String coin)
			throws IOException;

	@POST
	@Path("trade_cancel")
	AmberTradeCancel getTradeCancel(@FormParam("key") String apiKey, @FormParam("signature") ParamsDigest signer,
			@FormParam("nonce") long nonce, @FormParam("id") String id, @FormParam("coin") String coin)
			throws IOException;

	@POST
	@Path("trade_add")
	AmberTradeAdd getTradeAdd(@FormParam("key") String apiKey, @FormParam("signature") ParamsDigest signer,
			@FormParam("nonce") long nonce, @FormParam("amount") BigDecimal amount,
			@FormParam("price") BigDecimal price, @FormParam("type") String type, @FormParam("coin") String coin)
			throws IOException;
}
