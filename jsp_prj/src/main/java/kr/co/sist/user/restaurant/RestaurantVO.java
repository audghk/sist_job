package kr.co.sist.user.restaurant;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantVO {
  private String name;
  private String menu;
  private double lat;
  private double lng;
  private Date input_date;
}
