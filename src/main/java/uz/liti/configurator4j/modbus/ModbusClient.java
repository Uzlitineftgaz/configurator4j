package uz.liti.configurator4j.modbus;

import lombok.*;
import org.apache.plc4x.java.modbus.config.ModbusConfiguration;
import org.apache.plc4x.java.modbus.field.ModbusFieldHoldingRegister;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ModbusClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String ip;
    private int port;
    private int connectionTimeout = 500;
    private boolean active=false;


    public void Connect(){
        ModbusConfiguration configuration=new ModbusConfiguration();
        ModbusFieldHoldingRegister holdingRegister=ModbusFieldHoldingRegister.of("4");

    }

}
