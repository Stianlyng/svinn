package ntnu.idatt2105.stianlyng.svinn.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDTO {
    private String briefDescription;
    private String fullDescription;
    private double price;
    private Integer categoryId;
    private Integer locationId;
}