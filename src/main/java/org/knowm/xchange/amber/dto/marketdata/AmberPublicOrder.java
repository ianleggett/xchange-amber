package org.knowm.xchange.amber.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class AmberPublicOrder {

  private final BigDecimal price;
  private final BigDecimal volume; 

  @JsonCreator
  public AmberPublicOrder(@JsonProperty BigDecimal[] inp) {
	    this.price = inp[0];
	    this.volume = inp[1];    
	  }
  
  public AmberPublicOrder(BigDecimal price, BigDecimal volume) {
    this.price = price;
    this.volume = volume;    
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getVolume() {

    return volume;
  }

  @Override
  public String toString() {

    return "AmberOrder [price=" + price + ", volume=" + volume + "]";
  }

//  static class AmberOrderDeserializer extends JsonDeserializer<AmberPublicOrder> {
//
//    @Override
//    public AmberPublicOrder deserialize(JsonParser jsonParser, DeserializationContext ctxt)
//        throws IOException, JsonProcessingException {
//
//      ObjectCodec oc = jsonParser.getCodec();
//      JsonNode node = oc.readTree(jsonParser);
//      if (node.isArray()) {
//        BigDecimal price = new BigDecimal(node.path(0).asText());
//        BigDecimal volume = new BigDecimal(node.path(1).asText());        
//
//        return new AmberPublicOrder(price, volume);
//      }
//
//      return null;
//    }
//  }
}
