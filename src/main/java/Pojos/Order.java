package Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT )
public class Order {
    private String Id;
    private String ProjectId;
}
