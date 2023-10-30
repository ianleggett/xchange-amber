package org.knowm.xchange.amber.dto.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberWebsocketToken {

  @JsonProperty("token")
  private final String token;

  @JsonProperty("expires")
  private final int expiresInSeconds;

  public AmberWebsocketToken(
      @JsonProperty("token") String token, @JsonProperty("expires") int expiresInSeconds) {
    this.token = token;
    this.expiresInSeconds = expiresInSeconds;
  }

  public String getToken() {
    return token;
  }

  public int getExpiresInSeconds() {
    return expiresInSeconds;
  }

  @Override
  public String toString() {
    return "AmberWebsocketToken{"
        + "token='"
        + token
        + '\''
        + ", expiresInSeconds="
        + expiresInSeconds
        + '}';
  }
}
