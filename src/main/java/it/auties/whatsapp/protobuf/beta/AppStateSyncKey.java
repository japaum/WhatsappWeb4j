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
public class AppStateSyncKey {

  @JsonProperty(value = "2", required = false)
  @JsonPropertyDescription("AppStateSyncKeyData")
  private AppStateSyncKeyData keyData;

  @JsonProperty(value = "1", required = false)
  @JsonPropertyDescription("AppStateSyncKeyId")
  private AppStateSyncKeyId keyId;
}
