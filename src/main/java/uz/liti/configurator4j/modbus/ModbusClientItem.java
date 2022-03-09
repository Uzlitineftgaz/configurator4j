package uz.liti.configurator4j.modbus;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ModbusClientItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int address;
    private int quantity;


    @ManyToOne
    private ModbusClient client;


}
