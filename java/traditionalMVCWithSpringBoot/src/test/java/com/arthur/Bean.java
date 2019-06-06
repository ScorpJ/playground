package com.arthur;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Bean {
	
	
  @JsonProperty("ProfileId")
  private Long profileId = -1;
  @JsonProperty("ProfileType")
  private String profileType = "";
  @JsonProperty("ProfileName")
  private String profileName = "";

}
