package uz.liti.configurator4j.modbus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModbusClientRepository extends JpaRepository<ModbusClient,Long> {
}
