package it.auties.whatsapp.protobuf.beta;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(fluent = true)
public class ProtocolMessage {

  @JsonProperty(value = "10", required = false)
  @JsonPropertyDescription("AppStateFatalExceptionNotification")
  private AppStateFatalExceptionNotification appStateFatalExceptionNotification;

  @JsonProperty(value = "9", required = false)
  @JsonPropertyDescription("InitialSecurityNotificationSettingSync")
  private InitialSecurityNotificationSettingSync initialSecurityNotificationSettingSync;

  @JsonProperty(value = "8", required = false)
  @JsonPropertyDescription("AppStateSyncKeyRequest")
  private AppStateSyncKeyRequest appStateSyncKeyRequest;

  @JsonProperty(value = "7", required = false)
  @JsonPropertyDescription("AppStateSyncKeyShare")
  private AppStateSyncKeyShare appStateSyncKeyShare;

  @JsonProperty(value = "6", required = false)
  @JsonPropertyDescription("HistorySyncNotification")
  private HistorySyncNotification historySyncNotification;

  @JsonProperty(value = "5", required = false)
  @JsonPropertyDescription("int64")
  private long ephemeralSettingTimestamp;

  @JsonProperty(value = "4", required = false)
  @JsonPropertyDescription("uint32")
  private int ephemeralExpiration;

  @JsonProperty(value = "2", required = false)
  @JsonPropertyDescription("ProtocolMessageType")
  private ProtocolMessageType type;

  @JsonProperty(value = "1", required = false)
  @JsonPropertyDescription("MessageKey")
  private MessageKey key;

  @Accessors(fluent = true)
  public enum ProtocolMessageType {
    REVOKE(0),
    EPHEMERAL_SETTING(3),
    EPHEMERAL_SYNC_RESPONSE(4),
    HISTORY_SYNC_NOTIFICATION(5),
    APP_STATE_SYNC_KEY_SHARE(6),
    APP_STATE_SYNC_KEY_REQUEST(7),
    MSG_FANOUT_BACKFILL_REQUEST(8),
    INITIAL_SECURITY_NOTIFICATION_SETTING_SYNC(9),
    APP_STATE_FATAL_EXCEPTION_NOTIFICATION(10);

    private final @Getter int index;

    ProtocolMessageType(int index) {
      this.index = index;
    }

    @JsonCreator
    public static ProtocolMessageType forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }
}
