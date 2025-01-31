package org.whispersystems.signalservice.api.subscriptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.whispersystems.signalservice.api.profiles.SignalServiceProfile;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Available subscription levels.
 */
public final class SubscriptionLevels {

  private final Map<String, Level> levels;

  @JsonCreator
  public SubscriptionLevels(@JsonProperty("levels") Map<String, Level> levels) {
    this.levels = levels;
  }

  public Map<String, Level> getLevels() {
    return levels;
  }

  /**
   * An available subscription level
   */
  public static final class Level {
    private final SignalServiceProfile.Badge badge;
    private final Map<String, BigDecimal>    currencies;

    @JsonCreator
    public Level(@JsonProperty("badge") SignalServiceProfile.Badge badge,
                 @JsonProperty("currencies") Map<String, BigDecimal> currencies)
    {
      this.badge      = badge;
      this.currencies = currencies;
    }

    public SignalServiceProfile.Badge getBadge() {
      return badge;
    }

    public Map<String, BigDecimal> getCurrencies() {
      return currencies;
    }
  }
}
