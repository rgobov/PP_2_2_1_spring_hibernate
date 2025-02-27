package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

   private String model;
   private int series;

   @Id
   @OneToOne
   @JoinColumn(name = "user_id",referencedColumnName = "id")
   private User user;

   public Car() {

   }
   public Car(String model, int series) {
      this.model = model;
      this.series = series;

   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getSeries() {
      return series;
   }

   public void setSeries(int series) {
      this.series = series;
   }
}
